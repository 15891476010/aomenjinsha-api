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
import java.util.HashMap;
import java.util.Map;

/**
 * NGAPI Java实现
 * 
 * @link https://wiki.neapi.com
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class MsGameApiService {
    @Autowired
    private ConfigService configService;

    private String createUrl; // 创建会员账户
    private String balanceUrl; // 查询玩家余额
    private String playerPlayUrl; // 获取游戏地址
    private String orderstatusUrl; // 查询转账状态
    private String creditUrl; // 获取商户额度
    private String gamelistUrl; // 获取游戏列表
    private String gamerecordUrl; // 获取游戏记录
    private String depositUrl; // 额度转换转入
    private String withdrawalUrl; // 额度转换转出

    private String apiUrl;                          // API接口域名
    private String merchant_id;                       // 商户id
    private String merchant_secret; // 商户密钥

    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    /**
     * 初始化API设置
     */
    private void initializeApiSettings() {
        apiUrl = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MS_API_URL);         // API接口域名
        merchant_id = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MS_MERCHANT_ID);
        merchant_secret = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MS_MERCHANT_SECRET); // 注册开通后商户密钥,请登录管理后台查看

        createUrl = apiUrl + "/ley/register";
        balanceUrl = apiUrl + "/ley/balance";
        orderstatusUrl = apiUrl + "/ley/orderstatus";
        playerPlayUrl = apiUrl + "/ley/login";
        creditUrl = apiUrl + "/ley/credit";
        gamelistUrl = apiUrl + "/ley/gamelist";
        gamerecordUrl = apiUrl + "/ley/gamerecord";
        depositUrl = apiUrl + "/ley/deposit";
        withdrawalUrl = apiUrl + "/ley/withdrawal";
    }
    
    /**
     * 创建玩家
     * 
     * @param username 玩家账号，长度限制 5-11 位 小写字母 + 数字组合
     * @return 创建结果
     */
    public Map<String, Object> register(String username, String password, String apiCode) {
        initializeApiSettings();
        Map<String, Object> data = new HashMap<>();
        data.put("username", username);
        data.put("password", password);
        data.put("api_code", apiCode);
        return sendRequest(createUrl, data);
    }
    
    /**
     * 获取游戏登录地址
     *
     * @return 游戏登录地址
     */
    public Map<String, Object> getGameUrl(String username, String apiCode, String gameType, String gameCode, Integer isMobile) {
        initializeApiSettings();
        Map<String, Object> data = new HashMap<>();
        data.put("username", username);
        data.put("gameType", gameType);
        data.put("gameCode", gameCode);
        data.put("isMobile", isMobile);
        data.put("api_code", apiCode);
        return sendRequest(playerPlayUrl, data);
    }

    /**
     * 获取玩家余额
     * @param username 用户名
     * @param apiCode 接口标识
     * @return 玩家余额
     */
    public Map<String, Object> getBalance(String username, String apiCode) {
        initializeApiSettings();
        Map<String, Object> data = new HashMap<>();
        data.put("username", username);
        data.put("api_code", apiCode);
        return sendRequest(balanceUrl, data);
    }

    /**
     * 获取转账状态
     * @param username 用户名
     * @param apiCode 接口标识
     * @param transferno 转账单号
     * @return 转账状态
     */
    public Map<String, Object> getOrderStatus(String username, String apiCode, String transferno) {
        initializeApiSettings();
        Map<String, Object> data = new HashMap<>();
        data.put("username", username);
        data.put("api_code", apiCode);
        data.put("transferno", transferno);
        return sendRequest(orderstatusUrl, data);
    }

    /**
     * 获取商户额度
     * @param apiCode 接口标识
     * @return 商户额度
     */
    public Map<String, Object> getCredit(String apiCode) {
        initializeApiSettings();
        Map<String, Object> data = new HashMap<>();
        data.put("api_code", apiCode);
        return sendRequest(creditUrl, data);
    }

    /**
     * 获取游戏列表
     * @param apiCode 接口标识
     * @return 游戏列表
     */
    public Map<String, Object> getGameList(String apiCode) {
        initializeApiSettings();
        Map<String, Object> data = new HashMap<>();
        data.put("api_code", apiCode);
        return sendRequest(gamelistUrl, data);
    }

    /**
     * 获取游戏记录
     * @param method updateTime 根据修改时间采集，betTime 根据投注时间采集
     * @param start_at 开始时间，十位时间戳1602333908
     * @param end_at 结束时间，十位时间戳1602852308
     * @param page 页码
     * @param pageSize 每页数量
     * @return 游戏记录
     */
    public Map<String, Object> getGameRecord(String method, String start_at, String end_at, Integer page, Integer pageSize) {
        initializeApiSettings();
        Map<String, Object> data = new HashMap<>();
        data.put("method", method);
        data.put("start_at", start_at);
        data.put("end_at", end_at);
        data.put("page", page);
        data.put("pageSize", pageSize);
        return sendRequest(gamerecordUrl, data);
    }

    /**
     * 额度转换转入
     * @param username 用户名
     * @param apiCode 接口标识
     * @param amount 转账金额
     * @param transferno 转账订单号，建议时间戳+随机数字，最小16位，最大32位（可选）
     * @return 转账结果
     */
    public Map<String, Object> deposit(String username, String apiCode, Integer amount, String transferno) {
        initializeApiSettings();
        Map<String, Object> data = new HashMap<>();
        data.put("username", username);
        data.put("api_code", apiCode);
        data.put("amount", amount);
        data.put("transferno", transferno);
        return sendRequest(depositUrl, data);
    }

    /**
     * 额度转换转出
     * @param username 用户名
     * @param apiCode 接口标识
     * @param amount 转账金额
     * @param transferno 转账订单号，建议时间戳+随机数字，最小16位，最大32位（可选）
     * @return 转账结果
     */
    public Map<String, Object> withdrawal(String username, String apiCode, String amount, String transferno) {
        initializeApiSettings();
        Map<String, Object> data = new HashMap<>();
        data.put("username", username);
        data.put("api_code", apiCode);
        data.put("amount", amount);
        data.put("transferno", transferno);
        return sendRequest(withdrawalUrl, data);
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
            data.put("account", merchant_id);
            data.put("api_key", merchant_secret);
            return HttpClientUtil.post(url, data);
        } catch (Exception e) {
//            throw new RuntimeException("API请求失败: " + e.getMessage(), e);
            return new HashMap<>();
        }
    }
}