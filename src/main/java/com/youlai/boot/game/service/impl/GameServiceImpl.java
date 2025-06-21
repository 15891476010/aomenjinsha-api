package com.youlai.boot.game.service.impl;

import com.youlai.boot.common.constant.SysConfigConstant;
import com.youlai.boot.common.constant.SysGroupConstants;
import com.youlai.boot.common.exception.UsdtException;
import com.youlai.boot.core.security.model.EbUserDetails;
import com.youlai.boot.core.security.util.SecurityUtils;
import com.youlai.boot.game.model.entity.GameCategoryData;
import com.youlai.boot.game.model.vo.GameCategoryFrontVO;
import com.youlai.boot.game.service.GameCategoryDataService;
import com.youlai.boot.game.service.GameCategoryService;
import com.youlai.boot.game.service.GameService;
import com.youlai.boot.service.EzPgApiService;
import com.youlai.boot.service.NewNgApiService;
import com.youlai.boot.service.model.GameResultCode;
import com.youlai.boot.system.service.ConfigService;
import com.youlai.boot.system.service.SysGroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Map<String, Object> getGameUrl(Long id) {
        GameCategoryData byId = gameCategoryDataService.getById(id);
        // 获取当前玩家id
        Long player_id = SecurityUtils.getFrontUserId();
        Optional<EbUserDetails> frontUser = SecurityUtils.getFrontUser();
        String username = frontUser.map(EbUserDetails::getUsername).orElse(null);
        if (configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MERCHANT_ID).equals(byId.getProvider())) {
            Map<String, Object> post = ezPgApiService.getGameUrl(player_id, byId.getGameCode());
            if (post != null) {
                String code = (String) post.get("success");
                if (!"1".equals(code)) {
                    throw new RuntimeException("地址获取失败");
                }
                return post;
            }
        } else if(configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_NEW_NG_MERCHANT_ID).equals(byId.getProvider())) {
            String lang = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_NEW_NG_LANGUAGE);
            String returnUrl = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_NEW_NG_RETURN_URL);
            GameCategoryFrontVO gameCategoryById = gameCategoryService.getGameCategoryById(Long.valueOf(byId.getPid()));
            Map<String, Object> post = newNgApiService.gamelogin(username, lang, byId.getGameCode(), returnUrl, "", "", byId.getPlatType(), gameCategoryById.getGameType());
            System.out.println(post);
            String code =String.valueOf(post.get("code"));
            if (code.equals(GameResultCode.PLAYER_NOT_EXIST.getCode())) {
                Map<String, Object> register = newNgApiService.register(username, byId.getPlatType());
                if (register != null) {
                    if (String.valueOf(register.get("code")).equals(GameResultCode.SUCCESS.getCode())) {
                        System.out.println(newNgApiService.gamelogin(username, lang, byId.getGameCode(), returnUrl, "", "", byId.getPlatType(), gameCategoryById.getGameType()));
                    } else {
                        throw new UsdtException(GameResultCode.getValue(register.get("code").toString()).getMsg());
                    }
                }
            }
        }
        return Map.of();
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
