package com.youlai.boot.game.service.impl;

import com.youlai.boot.common.constant.SysConfigConstant;
import com.youlai.boot.common.constant.SysGroupConstants;
import com.youlai.boot.core.security.util.SecurityUtils;
import com.youlai.boot.game.model.entity.GameCategoryData;
import com.youlai.boot.game.service.GameCategoryDataService;
import com.youlai.boot.game.service.GameService;
import com.youlai.boot.service.EzPgApiService;
import com.youlai.boot.service.NewNgApiService;
import com.youlai.boot.system.service.ConfigService;
import com.youlai.boot.system.service.SysGroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> getGameUrl(Long id) {
        GameCategoryData byId = gameCategoryDataService.getById(id);
        // 获取当前玩家id
        Long player_id = SecurityUtils.getFrontUserId();
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
            Map<String, Object> gamelogin = newNgApiService.gamelogin(player_id, lang, byId.getGameCode(), returnUrl, "", "", byId.getPlatType());
            System.out.println(gamelogin);
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
