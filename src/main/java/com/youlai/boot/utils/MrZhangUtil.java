package com.youlai.boot.utils;

import cn.hutool.captcha.generator.CodeGenerator;
import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MrZhangUtil {
    /**
     * 字符串分割，转化为数组
     * @param str 字符串
     * @author Mr.Zhang
     * @since 2020-04-22
     * @return List<String>
     */
    public static List<String> stringToArrayStr(String str){
        return stringToArrayStrRegex(str, ",");
    }

    /**
     * 字符串分割，转化为数组
     * @param str 字符串
     * @param regex 分隔符有
     * @author Mr.Zhang
     * @since 2020-04-22
     * @return List<String>
     */
    public static List<String> stringToArrayStrRegex(String str, String regex ){
        List<String> list = new ArrayList<>();
        if (str.contains(regex)){

            String[] split = str.split(regex);

            for (String value : split) {
                if(!StringUtils.isBlank(value)){
                    list.add(value);
                }
            }
        }else {
            list.add(str);
        }
        return list;
    }

    /**
     * 获取uuid
     * @author Mr.Zhang
     * @since 2020-05-06
     * @
     */
    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * json字符串转数组
     * @param str 字符串
     * @author Mr.Zhang
     * @since 2020-04-22
     * @return List<T>
     */
    public static <T> List<T> jsonToListClass(String str, Class<T> cls){
        try{
            return JSONObject.parseArray(str, cls);
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    // 根据IP获取地理位置的方法
    public static String getLocationByIp(String ip) {
        // 如果是本地IP或内网IP，直接返回内网
        if (ip.equals("0:0:0:0:0:0:0:1") || ip.equals("127.0.0.1") || ip.startsWith("192.168.")
                || ip.startsWith("10.") || ip.startsWith("172.")) {
            return "内网";
        }

        // 使用第三方API获取IP地理位置
        try {
            // 方法1: 使用免费API (例如ip-api.com)
            String url = "http://ip-api.com/json/" + ip + "?lang=zh-CN";
            String response = HttpUtil.get(url, 5000);
            cn.hutool.json.JSONObject json = JSONUtil.parseObj(response);
            if ("success".equals(json.getStr("status"))) {
                return json.getStr("country") + " " + json.getStr("city");
            }

        } catch (Exception e) {
            return "未知";
        }

        return "未知";
    }

    public static String encryptPassword(String pwd, String key) {
        DES des = new DES(getDESSercretKey(key));
        byte[] result = des.encrypt(pwd);
        return Base64.encode(result);
    }

    /**
     * 解密密码
     */
    public static String decryptPassword(String pwd, String key) {
        DES des = new DES(getDESSercretKey(key));
        return des.decryptStr(pwd);
    }

    /**
     * 获得DES加密秘钥
     * @param key
     * @return
     */
    public static byte[] getDESSercretKey(String key) {
        byte[] result = new byte[8];
        byte[] keys = null;
        keys = key.getBytes(StandardCharsets.UTF_8);
        for(int i = 0; i<8;i++){
            if(i < keys.length){
                result[i] = keys[i];
            }else{
                result[i] = 0x01;
            }
        }
        return result;
    }
}
