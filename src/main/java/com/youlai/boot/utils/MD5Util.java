package com.youlai.boot.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /**
     * MD5加密
     * @param input 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String md5(String input) {
        try {
            // 获取MD5实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 将输入字符串转换为字节数组并进行加密
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5加密失败", e);
        }
    }
}