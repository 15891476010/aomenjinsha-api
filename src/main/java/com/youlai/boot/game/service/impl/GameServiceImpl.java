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
import com.youlai.boot.service.MsGameApiService;
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
    private SysGroupDataService sysGroupDataService;
    @Autowired
    private MsGameApiService msGameApiService;

    @Override
    public Map<String, Object> getGameUrl(Long id) {
        // 2. 获取当前玩家信息
        Long playerId = SecurityUtils.getFrontUserId();
        Optional<EbUserDetails> frontUser = SecurityUtils.getFrontUser();
        String username = frontUser.map(EbUserDetails::getUsername).orElseThrow(() ->
                new RuntimeException("用户未登录"));

        // 4. 如果都不匹配，返回空Map
        return Collections.emptyMap();
    }

    @Override
    public Map<String, Object> memberRegister(Long player_id, String player_name) {
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
}
