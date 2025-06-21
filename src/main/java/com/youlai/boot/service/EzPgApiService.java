package com.youlai.boot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youlai.boot.common.constant.SysConfigConstant;
import com.youlai.boot.system.service.ConfigService;
import com.youlai.boot.system.service.SysGroupDataService;
import com.youlai.boot.utils.HttpClientUtil;
import com.youlai.boot.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

/**
 * NGAPI Java实现
 * 
 * @link https://wiki.neapi.com
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class EzPgApiService {

    @Autowired
    private SysGroupDataService sysGroupDataService;
    @Autowired
    private ConfigService configService;

    private String createUrl; // 创建会员账户
    private String depositUrl; // 玩家上分
    private String withdrawUrl; // 玩家下分
    private String balanceUrl; // 查询玩家余额
    private String transactionQueryUrl; // 玩家交易查询
    private String playerPlayUrl; // 获取游戏地址
    private String getPlayerBetHistoryUrl; // 玩家历史游戏记录
 
    private String apiUrl;                          // API接口域名
    private String merchant_id;                       // 商户id
    private String currency;                        // 币种代码
    private String sign;                            // 32 位小写 md5(random+sn+secretKey)
    private Integer timestamp;                      // 时间戳，当前10位，如1714381728
    private String language; // 语言
    private String merchant_secret; // 商户密钥

    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    /**
     * 初始化API设置
     */
    private void initializeApiSettings() {
        apiUrl = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_API_URL);         // API接口域名
        merchant_id = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MERCHANT_ID);
        merchant_secret = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MERCHANT_SECRET); // 注册开通后商户密钥,请登录管理后台查看
        currency = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_CURRENCY);                        // 货币
        language = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_LANGUAGE);
        
        refreshRandomAndSign();

        createUrl = apiUrl + "/player/create";
        depositUrl = apiUrl + "/player/deposit";
        withdrawUrl = apiUrl + "/player/withdraw";
        balanceUrl = apiUrl + "/player/balance";
        transactionQueryUrl = apiUrl + "/transaction/query";
        playerPlayUrl = apiUrl + "/player/play_url";
        getPlayerBetHistoryUrl = apiUrl + "/player/bet_history";
    }
    
    /**
     * 刷新随机字符串和签名
     */
    private void refreshRandomAndSign() {
        timestamp = (int) Instant.now().getEpochSecond();
    }
    
    /**
     * 创建玩家
     * 
     * @param player_id 玩家账号，长度限制 5-11 位 小写字母 + 数字组合
     * @return 创建结果
     */
    public Map<String, Object> register(Long player_id, String username) {
        initializeApiSettings();
        refreshRandomAndSign();
        Map<String, Object> data = new HashMap<>();
        data.put("player_id", player_id);
        data.put("player_name", username);
        data.put("currency", currency);
        data.put("language", language);
        sign = MD5Util.md5(merchant_id + player_id + username + currency + language + timestamp + merchant_secret);
        return sendRequest(createUrl, data);
    }
    
    /**
     * 获取游戏登录地址
     *
     * @return 游戏登录地址
     */
    public Map<String, Object> getGameUrl(Long player_id, String gameid) {
        initializeApiSettings();
        refreshRandomAndSign();
        Map<String, Object> data = new HashMap<>();
        data.put("player_id", player_id);
        data.put("gameid", gameid);
        data.put("currency", currency);
        data.put("language", language);
        sign = MD5Util.md5(merchant_id + player_id + currency + gameid + timestamp + merchant_secret);
        return sendRequest(playerPlayUrl, data);
    }
    
    /**
     * 发送HTTP请求
     * 
     * @param url 请求URL
     * @param data 请求数据
     * @return 响应内容
     */
    private Map<String, Object> sendRequest(String url, Map<String, Object> data) {
        try {
            data.put("merchant_id", merchant_id);
            data.put("timestamp", timestamp);
            data.put("sign", sign);
            return HttpClientUtil.post(url, data);
        } catch (Exception e) {
            throw new RuntimeException("API请求失败: " + e.getMessage(), e);
        }
    }
}