package com.youlai.boot.service.model;

import com.youlai.boot.common.result.IResultCode;
import com.youlai.boot.common.result.ResultCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public enum GameResultCode implements IResultCode, Serializable {
    SUCCESS("10000", "成功"),
    FAIL("10001", "失败"),
    PLAYER_EXIST("10002", "账号已存在"),
    PLAYER_NOT_EXIST("10003", "账号不存在"),
    PLAYER_FORMAT_ERROR("10004", "账号格式错误"),
    TRANSFER_FAILED("10005", "额度转换失败"),
    AMOUNT_ERROR("10006", "转换金额错误"),
    TIME_FORMAT_ERROR("10007", "时间格式错误"),
    URL_FORMAT_ERROR("10008", "链接格式错误"),
    REQUEST_FREQUENT("10009", "接口请求频繁"),
    DEMO_NOT_SUPPORTED("10010", "此游戏不支持试玩"),
    ORDER_ID_INVALID("10011", "订单号不符合要求"),
    ORDER_ID_EXIST("10012", "订单号重复"),
    ORDER_ID_NOT_EXIST("10013", "订单号不存在"),
    INSUFFICIENT_QUOTA("10014", "额度不足"),
    INSUFFICIENT_MERCHANT_BALANCE("10015", "商户余额不足"),
    IP_RESTRICTED("10403", "IP限制访问"),
    SIGNATURE_FAILED("10404", "签名验证失败"),
    MISSING_PARAMETER("10405", "缺少参数"),
    TOO_MANY_PARAMETERS("10406", "参数过多"),
    PLATFORM_ERROR("10407", "游戏平台错误"),
    GAME_TYPE_ERROR("10408", "游戏类型错误"),
    TRANSFER_TYPE_ERROR("10409", "转换类型错误"),

    // 新增 MS 前缀错误码(中英文对照)
    MS_SUCCESS("0", "成功"),
    MS_UNKNOWN_ERROR("-1", "未知错误"),
    MS_API_CODE_ERROR("10", "API编码错误"),
    MS_MERCHANT_API_CODE_ERROR("11", "商户API编码错误"),
    MS_MEMBER_EXIST("33", "会员已存在"),
    MS_MEMBER_NOT_EXIST("34", "会员未注册"),
    MS_ORDER_EXIST("35", "订单号重复"),
    MS_INSUFFICIENT_MERCHANT_BALANCE("56", "商户额度不足"),
    MS_MERCHANT_KEY_ERROR("999", "商户或密钥错误"),
    MS_INTERFACE_MAINTENANCE("1000", "接口维护中"),
    MS_IP_UNAUTHORIZED("9999", "IP未授权");

    private String code;
    private String msg;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code + '\"' +
                ", \"msg\":\"" + msg + '\"' +
                '}';
    }

    public static GameResultCode getValue(String code) {
        for (GameResultCode value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return FAIL; // 默认系统执行错误
    }
}
