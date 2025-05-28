package com.youlai.boot.game.service.impl;

import com.youlai.boot.common.constant.SysConfigConstant;
import com.youlai.boot.common.constant.SysGroupConstants;
import com.youlai.boot.core.security.util.SecurityUtils;
import com.youlai.boot.game.model.entity.GameCategoryData;
import com.youlai.boot.game.service.GameCategoryDataService;
import com.youlai.boot.game.service.GameService;
import com.youlai.boot.system.service.ConfigService;
import com.youlai.boot.system.service.SysGroupDataService;
import com.youlai.boot.utils.HttpClientUtil;
import com.youlai.boot.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private ConfigService configService;

    @Autowired
    private GameCategoryDataService gameCategoryDataService;

    @Autowired
    private SysGroupDataService sysGroupDataService;

    @Override
    public Map<String, Object> getGameUrl(Long id) {
        GameCategoryData byId = gameCategoryDataService.getById(id);
        String BASE_URL = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_API_URL);
        // 获取商户id
        String merchant_id = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MERCHANT_ID);
        // 获取语言类型
        String language = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_LANGUAGE);
        // 获取币种
        String currency = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_CURRENCY);
        // 获取商户密钥
        String merchant_secret = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MERCHANT_SECRET);
        // 获取当前10位时间戳
        int timestamp = (int) Instant.now().getEpochSecond();
        // 获取当前玩家id
        Long player_id = SecurityUtils.getFrontUserId();
        String gameid = byId.getTargetUrl();
        String signStr = merchant_id + player_id + currency + gameid + timestamp + merchant_secret;
        String sign = MD5Util.md5(signStr);
        Map<String, Object> map = new HashMap<>();
        map.put("merchant_id", merchant_id);
        map.put("player_id", player_id);
        map.put("gameid", gameid);
        map.put("currency", currency);
        map.put("language", language);
        map.put("timestamp", timestamp);
//        map.put("with_html", 1);
        map.put("sign", sign);
        try {
            Map<String, Object> post = HttpClientUtil.post(BASE_URL + "/player/play_url", map);
            if (post != null) {
                String code = (String) post.get("success");
                if (!"1".equals(code)) {
                    throw new RuntimeException("地址获取失败");
                }
                return post;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Map.of();
    }

    @Override
    public Map<String, Object> memberRegister(Long player_id, String player_name) {
        String BASE_URL = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_API_URL);
        // 获取商户id
        String merchant_id = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MERCHANT_ID);
        // 获取语言类型
        String language = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_LANGUAGE);
        // 获取币种
        String currency = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_CURRENCY);
        // 获取商户密钥
        String merchant_secret = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MERCHANT_SECRET);
        // 获取当前10位时间戳
        int timestamp = (int) Instant.now().getEpochSecond();
        String signStr = merchant_id + player_id + player_name + currency + language + timestamp + merchant_secret;

        String sign = MD5Util.md5(signStr);
        Map<String, Object> map = new HashMap<>();
        map.put("merchant_id", merchant_id);
        map.put("player_id", player_id);
        map.put("player_name", player_name);
        map.put("currency", currency);
        map.put("language", language);
        map.put("timestamp", timestamp);
        map.put("sign", sign);

        try {
            Map<String, Object> post = HttpClientUtil.post(BASE_URL + "/player/create", map);
            if (post != null) {
                String code = (String) post.get("success");
                if (!"1".equals(code)) {
                    throw new RuntimeException("创建玩家失败");
                }
                return post;
            }
        } catch (IOException e) {
            e.printStackTrace();
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
