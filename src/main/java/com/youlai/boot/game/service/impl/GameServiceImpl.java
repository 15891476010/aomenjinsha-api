package com.youlai.boot.game.service.impl;

import com.youlai.boot.common.constant.SysConfigConstant;
import com.youlai.boot.common.constant.SysGroupConstants;
import com.youlai.boot.common.exception.UsdtException;
import com.youlai.boot.core.security.model.EbUserDetails;
import com.youlai.boot.core.security.util.SecurityUtils;
import com.youlai.boot.game.model.entity.GameCategoryData;
import com.youlai.boot.game.model.entity.GamePlatType;
import com.youlai.boot.game.model.vo.GameCategoryFrontVO;
import com.youlai.boot.game.service.GameCategoryDataService;
import com.youlai.boot.game.service.GameCategoryService;
import com.youlai.boot.game.service.GamePlatTypeService;
import com.youlai.boot.game.service.GameService;
import com.youlai.boot.service.EzPgApiService;
import com.youlai.boot.service.NewNgApiService;
import com.youlai.boot.service.model.GameResultCode;
import com.youlai.boot.system.service.ConfigService;
import com.youlai.boot.system.service.SysGroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameCategoryDataService gameCategoryDataService;

    @Autowired
    private SysGroupDataService sysGroupDataService;
    @Autowired
    private EzPgApiService ezPgApiService;
    @Autowired
    private ConfigService configService;
    @Autowired
    private NewNgApiService newNgApiService;
    @Autowired
    private GameCategoryService gameCategoryService;
    @Autowired
    private GamePlatTypeService gamePlatTypeService;

    @Override
    public Map<String, Object> getGameUrl(Long id, Boolean type) {
        // 2. 获取当前玩家信息
        Long playerId = SecurityUtils.getFrontUserId();
        Optional<EbUserDetails> frontUser = SecurityUtils.getFrontUser();
        String username = frontUser.map(EbUserDetails::getUsername).orElseThrow(() ->
                new RuntimeException("用户未登录"));
        if (type) {
            GamePlatType gamePlatType = gamePlatTypeService.getBaseMapper().selectById(id);
            return handleNewNgProvider(username, gamePlatType);
        } else {
            // 1. 根据游戏ID获取游戏分类数据
            GameCategoryData gameData = gameCategoryDataService.getById(id);
            if (gameData == null) {
                throw new RuntimeException("游戏数据不存在");
            }

            // 3. 根据不同的游戏提供商处理游戏URL获取逻辑
            String provider = gameData.getProvider();
            String merchantId = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MERCHANT_ID);
            String newNgMerchantId = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_NEW_NG_MERCHANT_ID);

            // 3.1 处理EZPG提供商逻辑
            if (merchantId.equals(provider)) {
                return handleEzPgProvider(playerId, gameData);
            }
            // 3.2 处理NewNG提供商逻辑
            else if (newNgMerchantId.equals(provider)) {
                return handleNewNgProvider(username, gameData);
            }
        }
        // 4. 如果都不匹配，返回空Map
        return Collections.emptyMap();
    }

    /**
     * 处理EZPG提供商的游戏URL获取
     */
    private Map<String, Object> handleEzPgProvider(Long playerId, GameCategoryData gameData) {
        Map<String, Object> response = ezPgApiService.getGameUrl(playerId, gameData.getGameCode());

        if (response == null) {
            throw new RuntimeException("EZPG服务无响应");
        }

        String code = (String) response.get("success");
        if (!"1".equals(code)) {
            throw new RuntimeException("EZPG地址获取失败");
        }

        return response;
    }

    /**
     * 处理NewNG提供商的游戏URL获取
     */
    private Map<String, Object> handleNewNgProvider(String username, GameCategoryData gameData) {
        // 获取配置信息
        String lang = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_NEW_NG_LANGUAGE);
        String returnUrl = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_NEW_NG_RETURN_URL);

        // 获取游戏分类信息
        GameCategoryFrontVO gameCategory = gameCategoryService.getGameCategoryById(Long.valueOf(gameData.getPid()));

        // 尝试登录游戏
        Map<String, Object> loginResponse = newNgApiService.gamelogin(
                username, lang, gameData.getGameCode(), returnUrl, "", "",
                gameData.getPlatType(), gameCategory.getGameType());

        String code = String.valueOf(loginResponse.get("code"));

        // 处理玩家不存在的情况 - 先注册再登录
        if (GameResultCode.PLAYER_NOT_EXIST.getCode().equals(code)) {
            return handlePlayerRegistration(username, gameData, lang, returnUrl, gameCategory);
        }
        // 处理成功情况
        else if (GameResultCode.SUCCESS.getCode().equals(code)) {
            return loginResponse;
        }
        // 处理其他错误情况
        else {
            throw new UsdtException(GameResultCode.getValue(loginResponse.get("code").toString()).getMsg());
        }
    }

    /**
     * 处理NewNG提供商的游戏URL获取
     */
    private Map<String, Object> handleNewNgProvider(String username, GamePlatType gamePlatType) {
        // 获取配置信息
        String lang = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_NEW_NG_LANGUAGE);
        String returnUrl = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_NEW_NG_RETURN_URL);

        // 获取游戏分类信息
        GameCategoryFrontVO gameCategory = gameCategoryService.getGameCategoryById(Long.valueOf(gamePlatType.getGameType()));
        // 尝试登录游戏
        Map<String, Object> loginResponse = newNgApiService.gamelogin(
                username, lang, "", returnUrl, "", "",
                gamePlatType.getPlatType(), gameCategory.getGameType());

        String code = String.valueOf(loginResponse.get("code"));

        // 处理玩家不存在的情况 - 先注册再登录
        if (GameResultCode.PLAYER_NOT_EXIST.getCode().equals(code)) {
            return handlePlayerRegistration(username, gamePlatType, lang, returnUrl, gameCategory);
        }
        // 处理成功情况
        else if (GameResultCode.SUCCESS.getCode().equals(code)) {
            playerQuotaConversion(gamePlatType.getPlatType());
            return loginResponse;
        }
        // 处理其他错误情况
        else {
            throw new UsdtException(GameResultCode.getValue(loginResponse.get("code").toString()).getMsg());
        }
    }

    /**
     * 处理新玩家注册流程
     */
    private Map<String, Object> handlePlayerRegistration(String username, GameCategoryData gameData,
                                                         String lang, String returnUrl, GameCategoryFrontVO gameCategory) {

        // 先注册玩家
        Map<String, Object> registerResponse = newNgApiService.register(username, gameData.getPlatType());

        if (registerResponse == null) {
            throw new UsdtException("注册服务无响应");
        }

        String registerCode = String.valueOf(registerResponse.get("code"));

        // 注册成功后再尝试登录
        if (GameResultCode.SUCCESS.getCode().equals(registerCode)) {
            Map<String, Object> gamelogin = newNgApiService.gamelogin(
                    username, lang, gameData.getGameCode(), returnUrl, "", "",
                    gameData.getPlatType(), gameCategory.getGameType());
            playerQuotaConversion(gameData.getPlatType());
            return gamelogin;
        } else {
            throw new UsdtException(GameResultCode.getValue(registerResponse.get("code").toString()).getMsg());
        }
    }

    /**
     * 玩家额度转换的方法，在玩家掉用登录接口之后调用
     */
    public void playerQuotaConversion(String platType) {
        Optional<EbUserDetails> frontUser = SecurityUtils.getFrontUser();
        BigDecimal bigDecimal = frontUser.map(EbUserDetails::getBalance).orElse(null);
        String username = frontUser.map(EbUserDetails::getUsername).orElse(null);
        Map<String, Object> conversion = newNgApiService.conversion(username, platType, String.valueOf(bigDecimal), "1");
        if(GameResultCode.SUCCESS.getCode().equals(String.valueOf(conversion.get("code")))) {
            throw new UsdtException(GameResultCode.getValue(conversion.get("code").toString()).getMsg());
        }
    }

    /**
     * 处理新玩家注册流程
     */
    private Map<String, Object> handlePlayerRegistration(String username, GamePlatType gamePlatType,
                                                         String lang, String returnUrl, GameCategoryFrontVO gameCategory) {

        // 先注册玩家
        Map<String, Object> registerResponse = newNgApiService.register(username, gamePlatType.getPlatType());

        if (registerResponse == null) {
            throw new UsdtException("注册服务无响应");
        }

        String registerCode = String.valueOf(registerResponse.get("code"));

        // 注册成功后再尝试登录
        if (GameResultCode.SUCCESS.getCode().equals(registerCode)) {
            return newNgApiService.gamelogin(
                    username, lang, "", returnUrl, "", "",
                    gamePlatType.getPlatType(), gameCategory.getGameType());
        } else {
            throw new UsdtException(GameResultCode.getValue(registerResponse.get("code").toString()).getMsg());
        }
    }

    @Override
    public Map<String, Object> memberRegister(Long player_id, String player_name) {
        Map<String, Object> post = ezPgApiService.register(player_id, player_name);
        if (post != null) {
            String code = (String) post.get("success");
            if (!"1".equals(code)) {
                throw new RuntimeException("创建玩家失败");
            }
            return post;
        }
        return Map.of();
    }

    @Override
    public List<Map<String, String>> getGameProviderList() {
        List<HashMap<String, Object>> listMapByGid = sysGroupDataService.getListMapByGid(SysGroupConstants.GROUP_ID_ADMIN_PROVIDER_LIST);
        List<Map<String, String>> objects = new ArrayList<>();
        listMapByGid.forEach(map -> {
            Map<String, String> stringStringMap = new HashMap<>();
            stringStringMap.put("label", map.get("provider").toString());
            stringStringMap.put("value", map.get("MerchantID").toString());
            objects.add(stringStringMap);
        });
        return objects;
    }
}
