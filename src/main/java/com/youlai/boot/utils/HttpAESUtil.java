package com.youlai.boot.utils;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.youlai.boot.config.property.EncryptProperties;

import java.io.*;
import java.security.Key;
import java.util.Base64;

@Component
public class HttpAESUtil {

    private static EncryptProperties encryptProperties;

    @Autowired
    public void setEncryptProperties(EncryptProperties encryptProperties) {
        HttpAESUtil.encryptProperties = encryptProperties;
    }

    // 获取 AES 加密所需的 Key 对象
    private static Key generateKey() throws Exception {
        return new SecretKeySpec(encryptProperties.getSecretKey().getBytes(), encryptProperties.getAlgorithm());
    }

    // 加密JSON字符串
    public static String encrypt(String json) throws Exception {
        Cipher cipher = Cipher.getInstance(encryptProperties.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, generateKey());
        byte[] encryptedBytes = cipher.doFinal(json.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // 解密为JSON字符串
    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(encryptProperties.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, generateKey());
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes, java.nio.charset.StandardCharsets.UTF_8);
    }

    // 兼容老的Java序列化方式解密
    public static Object decryptToObject(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(encryptProperties.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, generateKey());
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        ByteArrayInputStream bis = new ByteArrayInputStream(decryptedBytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}

