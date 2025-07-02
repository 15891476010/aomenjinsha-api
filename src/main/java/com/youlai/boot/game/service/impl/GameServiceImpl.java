package com.youlai.boot.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.constant.SysConfigConstant;
import com.youlai.boot.common.constant.SysGroupConstants;
import com.youlai.boot.common.exception.UsdtException;
import com.youlai.boot.core.security.model.EbUserDetails;
import com.youlai.boot.core.security.util.SecurityUtils;
import com.youlai.boot.game.mapper.GameCategoryDataMapper;
import com.youlai.boot.game.mapper.GameCategoryMapper;
import com.youlai.boot.game.mapper.GamePlatTypeMapper;
import com.youlai.boot.game.model.entity.GameCategory;
import com.youlai.boot.game.model.entity.GameCategoryData;
import com.youlai.boot.game.model.entity.GamePlatType;
import com.youlai.boot.game.model.vo.GameCategoryFrontVO;
import com.youlai.boot.game.service.GameCategoryDataService;
import com.youlai.boot.game.service.GameCategoryService;
import com.youlai.boot.game.service.GamePlatTypeService;
import com.youlai.boot.game.service.GameService;
import com.youlai.boot.index.mapper.EbUserMapper;
import com.youlai.boot.index.model.entity.EbUser;
import com.youlai.boot.index.service.EbUserService;
import com.youlai.boot.service.MsGameApiService;
import com.youlai.boot.service.model.GameResultCode;
import com.youlai.boot.system.service.ConfigService;
import com.youlai.boot.system.service.SysGroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private SysGroupDataService sysGroupDataService;
    @Autowired
    private MsGameApiService msGameApiService;
    @Autowired
    private GameCategoryDataMapper gameCategoryDataMapper;
    @Autowired
    private GameCategoryMapper gameCategoryMapper;
    @Autowired
    private EbUserMapper ebUserMapper;
    @Autowired
    private GamePlatTypeMapper gamePlatTypeMapper;

    @Override
    public Map<String, Object> getGameUrl(Long id) {
        // 2. 获取当前玩家信息
        Long playerId = SecurityUtils.getFrontUserId();
        Optional<EbUserDetails> frontUser = SecurityUtils.getFrontUser();
        String username = frontUser.map(EbUserDetails::getUsername).orElseThrow(() ->
                new RuntimeException("用户未登录"));

        GameCategoryData byId = gameCategoryDataMapper.selectById(id);
        GameCategory byId1 = gameCategoryMapper.selectById(byId.getPid());
        Map<String, Object> gameUrl = getGameUrl(username, byId.getTag(), byId1.getGameType(), byId.getGameCode(), 1);
        // 4. 如果都不匹配，返回空Map
        if ((int) gameUrl.get("Code") == 34) {
            Map<String, Object> user = memberRegister(username, byId.getTag());
            if ((int) user.get("Code") == 0) {
                gameUrl = getGameUrl(username, byId.getTag(), byId1.getGameType(), byId.getGameCode(), 1);
            }
        }
        if ((int) gameUrl.get("Code") == 0) {
            EbUser byId2 = ebUserMapper.selectById(playerId);
            Map<String, Object> result = msGameApiService.deposit(username, byId.getTag(), byId2.getBalance(), generateOrderNo());
            if ((int) result.get("Code") != 0) {
                throw new UsdtException(result.get("Message").toString());
            } else {
                byId2.setBalance(new BigDecimal(0));
                ebUserMapper.updateById(byId2);
            }
        }
        return gameUrl;
    }

    @Override
    public Map<String, Object> getGameHomeUrl(Long id) {
        // 2. 获取当前玩家信息
        Long playerId = SecurityUtils.getFrontUserId();
        Optional<EbUserDetails> frontUser = SecurityUtils.getFrontUser();
        String username = frontUser.map(EbUserDetails::getUsername).orElseThrow(() ->
                new RuntimeException("用户未登录"));

        GamePlatType gamePlatType = gamePlatTypeMapper.selectById(id);
        LambdaQueryWrapper<GameCategory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GameCategory::getGameType, gamePlatType.getGameType());
        GameCategory gameCategory = gameCategoryMapper.selectOne(wrapper);
        Map<String, Object> gameUrl = getGameUrl(username, gamePlatType.getPlatType(), gameCategory.getGameType(), gamePlatType.getGameCode(), 1);
        // 4. 如果都不匹配，返回空Map
        if ((int) gameUrl.get("Code") == 34) {
            Map<String, Object> user = memberRegister(username, gamePlatType.getPlatType());
            if ((int) user.get("Code") == 0) {
                gameUrl = getGameUrl(username, gamePlatType.getPlatType(), gameCategory.getGameType(), gamePlatType.getGameCode(), 1);
            }
        }
        if ((int) gameUrl.get("Code") == 0) {
            EbUser byId2 = ebUserMapper.selectById(playerId);
            Map<String, Object> result = msGameApiService.deposit(username, gamePlatType.getPlatType(), byId2.getBalance(), generateOrderNo());
            if ((int) result.get("Code") != 0) {
                throw new UsdtException(result.get("Message").toString());
            } else {
                byId2.setBalance(new BigDecimal(0));
                ebUserMapper.updateById(byId2);
            }
        }
        return gameUrl;
    }

    private Map<String, Object> getGameUrl(String username, String apiCode, String gameType, String gameCode, Integer isMobile) {
        return msGameApiService.getGameUrl(username, apiCode, gameType, gameCode, isMobile);
    }
    private Map<String, Object> memberRegister(String player_name, String apiCode) {
        return msGameApiService.register(player_name, "a12345678", apiCode);
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

    /**
     * 生成转账16位订单号，时间戳+随机数字
     */
    private String generateOrderNo() {
        // 获取当前时间戳，格式为 yyyyMMddHHmmss
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // 生成两位随机数字（10以内补0）
        int randomNumber = new Random().nextInt(100); // 0 - 99
        String randomPart = String.format("%02d", randomNumber);

        // 拼接成16位订单号
        return timestamp + randomPart;
    }

    /**
     * 获取商户额度
     * @param apiCode
     * @return
     */
    @Override
    public String getCredit(String apiCode) {
        Map<String, Object> post = msGameApiService.getCredit(apiCode);
        if ((int)post.get("Code") == 0) {
            Map<String, Object> data = (Map<String, Object>) post.get("Data");
            return (String) data.get("money");
        }
        return "0";
    }

    @Override
    public Map<String, Object> userTransfer(String gamePlate) {
        // 2. 获取当前玩家信息
        Long playerId = SecurityUtils.getFrontUserId();
        Optional<EbUserDetails> frontUser = SecurityUtils.getFrontUser();
        String username = frontUser.map(EbUserDetails::getUsername).orElseThrow(() ->
                new RuntimeException("用户未登录"));
        // 先查询用户余额
        Map<String, Object> balance = msGameApiService.getBalance(username, gamePlate);
        if ((int) balance.get("Code") != 0) {
            throw new UsdtException(balance.get("Message").toString());
        } else {
            Map<String, Object> data = (Map<String, Object>) balance.get("Data");
            BigDecimal balanceData = new BigDecimal(data.get("balance").toString());
            // 判断是否大于等于1，如果大于等于一，那么就向下对余额取整
            if (balanceData.compareTo(new BigDecimal(1)) >= 0) {
                balanceData = balanceData.setScale(0, RoundingMode.DOWN);
                EbUser byId2 = ebUserMapper.selectById(playerId);
                Map<String, Object> withdrawal = msGameApiService.withdrawal(username, gamePlate, balanceData.intValue(), generateOrderNo());
                if ((int) withdrawal.get("Code") != 0) {
                    throw new UsdtException(withdrawal.get("Message").toString());
                }
                byId2.setBalance(balanceData);
                ebUserMapper.updateById(byId2);
            }
        }
        return balance;
    }
}
