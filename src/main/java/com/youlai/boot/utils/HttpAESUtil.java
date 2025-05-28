package com.youlai.boot.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;
import java.util.Base64;

public class HttpAESUtil {

    // 密钥（32 字节 = 256 bit）
    private static final String SECRET_KEY = "7a9K3pR2eF5gH8jL1qW4sD6xZ0cV2bN3";
    private static final String ALGORITHM = "AES";

    // 获取 AES 加密所需的 Key 对象
    private static Key generateKey() throws Exception {
        return new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
    }

    // 加密JSON字符串
    public static String encrypt(String json) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, generateKey());
        byte[] encryptedBytes = cipher.doFinal(json.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // 解密为JSON字符串
    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, generateKey());
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes, java.nio.charset.StandardCharsets.UTF_8);
    }

    // 兼容老的Java序列化方式解密
    public static Object decryptToObject(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, generateKey());
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        ByteArrayInputStream bis = new ByteArrayInputStream(decryptedBytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}

