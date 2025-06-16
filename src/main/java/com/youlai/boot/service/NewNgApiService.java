package com.youlai.boot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youlai.boot.common.constant.SysGroupConstants;
import com.youlai.boot.service.model.GameParams;
import com.youlai.boot.system.service.SysGroupDataService;
import com.youlai.boot.utils.HttpClientUtil;
import com.youlai.boot.utils.MD5Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * NGAPI Java实现
 * 
 * @link https://wiki.neapi.com
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class NewNgApiService {

    @Autowired
    private SysGroupDataService sysGroupDataService;

    private String creatememberaccountUrl;          // 创建会员账户
    private String getbalanceUrl;                   // 查询余额
    private String getplatformbalanceUrl;           // 查询全平台余额
    private String conversionallUrl;                // 一键转出全平台额度
    private String gameloginUrl;                    // 获取游戏登录地址
    private String demologinUrl;                    // 获取demo游戏登录地址
    private String gameorderUrl;                    // 游戏订单查询
    private String gamerealtimerecordsUrl;          // 实时游戏记录
    private String gamehistoryrecordsUrl;           // 历史游戏记录
    private String conversionUrl;                   // 额度转换
    private String conversionStatusUrl;             // 额度转换状态查询
    private String gamecodeUrl;                     // 获取游戏代码
    private String getmerchantBalanceUrl;           // 查询商户余额
 
    private String apiUrl;                          // API接口域名
    private String sn;                              // 注册开通后商户前缀,请登录管理后台查看
    private String secretKey;                       // 注册开通后商户密钥,请登录管理后台查看
    private String currency;                        // 币种代码
    private String sign;                            // 32 位小写 md5(random+sn+secretKey)
    private String random;                          // 随机字符串16-32 位 小写字母 + 数字
    
    private final String GAME_TYPE_LIVE = "1";      // 视讯
    private final String GAME_TYPE_SLOT = "2";      // 老虎机
    private final String GAME_TYPE_LOTTERY = "3";   // 彩票
    private final String GAME_TYPE_SPORTS = "4";    // 体育
    private final String GAME_TYPE_ESPORTS = "5";   // 电竞
    private final String GAME_TYPE_FISHING = "6";   // 捕鱼
    private final String GAME_TYPE_POKER = "7";     // 棋牌
    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    /**
     * 初始化API设置
     */
    private void initializeApiSettings() {
        GameParams gameParams = getGameParams();
        apiUrl = gameParams.getApiUrl();         // API接口域名
        sn = gameParams.getMerchantPrefix();     // 注册开通后商户前缀,请登录管理后台查看
        secretKey = gameParams.getMerchantSecret(); // 注册开通后商户密钥,请登录管理后台查看
        currency = "CNY";                        // 货币
        
        refreshRandomAndSign();
        
        creatememberaccountUrl = apiUrl + "/api/server/create";
        getbalanceUrl = apiUrl + "/api/server/balance";
        getplatformbalanceUrl = apiUrl + "/api/server/balanceAll";
        conversionallUrl = apiUrl + "/api/server/transferAll";
        gameloginUrl = apiUrl + "/api/server/gameUrl";
        demologinUrl = apiUrl + "/api/server/demoUrl";
        gameorderUrl = apiUrl + "/api/server/recordOrder";
        gamerealtimerecordsUrl = apiUrl + "/api/server/recordAll";
        gamehistoryrecordsUrl = apiUrl + "/api/server/recordHistory";
        conversionUrl = apiUrl + "/api/server/all-credit";
        conversionStatusUrl = apiUrl + "/api/server/record";
        gamecodeUrl = apiUrl + "/api/server/gameCode";
        getmerchantBalanceUrl = apiUrl + "/api/server/quota";
    }
    
    /**
     * 刷新随机字符串和签名
     */
    private void refreshRandomAndSign() {
        random = generateRandom(16, 32);
        sign = MD5Util.md5(random + sn + secretKey);
    }
    
    /**
     * 创建玩家
     * 
     * @param username 玩家账号，长度限制 5-11 位 小写字母 + 数字组合
     * @return 创建结果
     */
    public String register(String username, String platType) {
        Map<String, Object> data = new HashMap<>();
        data.put("playerId", username);
        data.put("platType", platType);
        data.put("currency", currency);
        
        return sendRequest(creatememberaccountUrl, data);
    }
    
    /**
     * 查询余额
     * 
     * @param username 玩家账号
     * @return 余额查询结果
     */
    public String getbalance(String username, String platType) {
        Map<String, Object> data = new HashMap<>();
        data.put("platType", platType);
        data.put("playerId", username);
        data.put("currency", currency);
        
        return sendRequest(getbalanceUrl, data);
    }
    
    /**
     * 查询全平台余额
     * 
     * @param username 玩家账号
     * @return 全平台余额查询结果
     */
    public String getbalanceall(String username) {
        Map<String, Object> data = new HashMap<>();
        data.put("playerId", username);
        data.put("currency", currency);
        
        return sendRequest(getplatformbalanceUrl, data);
    }
    
    /**
     * 获取游戏登录地址
     * 
     * @param username 玩家账号
     * @param lang 游戏语言，默认简体中文
     * @param gameCode 游戏代码，默认游戏大厅
     * @param returnUrl 游戏退出时跳转地址
     * @param ingress 终端类型，device1:电脑网页版、device2:手机网页版
     * @param oddsType 彩票盘口，A:(默认)、B、C，仅IG彩票和SGWin彩票可选
     * @return 游戏登录地址
     */
    public String gamelogin(String username, String lang, String gameCode, String returnUrl, String ingress, String oddsType, String platType) {
        Map<String, Object> data = new HashMap<>();
        data.put("platType", platType);
        data.put("playerId", username);
        data.put("gameType", GAME_TYPE_LIVE);
        data.put("currency", currency);
        data.put("lang", lang);
        data.put("gameCode", gameCode);
        data.put("returnUrl", returnUrl);
        data.put("ingress", ingress != null && !ingress.isEmpty() ? ingress : "device1");
        data.put("oddsType", oddsType);
        
        return sendRequest(gameloginUrl, data);
    }
    
    /**
     * 获取实时下注记录
     * 
     * @param page 页码
     * @param pageSize 每页记录数
     * @return 实时下注记录
     */
    public String gamerealtimerecords(int page, int pageSize) {
        Map<String, Object> data = new HashMap<>();
        data.put("currency", currency);
        data.put("pageNo", page);
        data.put("pageSize", pageSize);
        
        return sendRequest(gamerealtimerecordsUrl, data);
    }
    
    /**
     * 获取游戏代码
     * 
     * @return 游戏代码列表
     */
    public String gamecode(String platType) {
        Map<String, Object> data = new HashMap<>();
        data.put("platType", platType);
        
        return sendRequest(gamecodeUrl, data);
    }
    
    /**
     * 查询商户平台额度
     * 
     * @return 商户平台额度
     */
    public String quota() {
        Map<String, Object> data = new HashMap<>();
        
        return sendRequest(getmerchantBalanceUrl, data);
    }
    
    /**
     * 发送HTTP请求
     * 
     * @param url 请求URL
     * @param data 请求数据
     * @return 响应内容
     */
    private String sendRequest(String url, Map<String, Object> data) {
        try {
            // 在每次请求前刷新随机字符串和签名，确保安全性
            refreshRandomAndSign();
            
            // 合并请求数据和请求头到单个Map中
            Map<String, Object> requestParams = new HashMap<>(data);
            
            // 添加请求头信息为特殊字段
            requestParams.put("_headers", new HashMap<String, Object>() {{
                put("sn", sn);
                put("sign", sign);
                put("random", random);
                put("Content-Type", "application/json");
            }});
            
            // 调用HttpClientUtil发送请求
            Map<String, Object> responseMap = HttpClientUtil.post(url, requestParams);
            
            // 将响应结果转换为JSON字符串返回
            return objectMapper.writeValueAsString(responseMap);
        } catch (Exception e) {
            throw new RuntimeException("API请求失败: " + e.getMessage(), e);
        }
    }
    
    /**
     * 生成指定长度的随机字符串
     * 
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @return 随机字符串
     */
    private String generateRandom(int minLength, int maxLength) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        StringBuilder sb = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        
        return sb.toString();
    }

    private GameParams getGameParams() {
        GameParams gameParams = new GameParams();
        List<HashMap<String, Object>> listMapByGid = sysGroupDataService.getListMapByGid(SysGroupConstants.GROUP_ID_ADMIN_PROVIDER_LIST);
        return gameParams;
    }
}