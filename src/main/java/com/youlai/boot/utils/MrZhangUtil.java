package com.youlai.boot.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

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
}
