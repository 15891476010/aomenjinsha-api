package com.youlai.boot.common.advice;

import com.youlai.boot.common.annotation.AesEncrypt;
import com.youlai.boot.config.property.EncryptProperties;
import com.youlai.boot.utils.HttpAESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.*;
import java.lang.reflect.Type;

@RestControllerAdvice
public class AesRequestBodyAdvice implements RequestBodyAdvice {

    @Autowired
    private EncryptProperties encryptProperties;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.hasMethodAnnotation(AesEncrypt.class) || methodParameter.getContainingClass().isAnnotationPresent(AesEncrypt.class);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        // 如果未启用加密，直接返回原始inputMessage
        if (encryptProperties != null && Boolean.FALSE.equals(encryptProperties.getEnabled())) {
            return inputMessage;
        }
        String encrypted = new String(inputMessage.getBody().readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
        String decryptedJson = null;
        Exception lastException = null;
        // 只尝试用JSON解密
        try {
            decryptedJson = HttpAESUtil.decrypt(encrypted);
            if (decryptedJson != null && (decryptedJson.trim().startsWith("{") || decryptedJson.trim().startsWith("["))) {
                // 是合法JSON，直接返回
                InputStream decryptedStream = new ByteArrayInputStream(decryptedJson.getBytes(java.nio.charset.StandardCharsets.UTF_8));
                return new HttpInputMessage() {
                    @Override
                    public InputStream getBody() {
                        return decryptedStream;
                    }
                    @Override
                    public HttpHeaders getHeaders() {
                        return inputMessage.getHeaders();
                    }
                };
            }
        } catch (Exception e) {
            lastException = e;
        }
        // 解密失败抛出异常
        throw new IOException("AES解密失败: " + (lastException != null ? lastException.getMessage() : "未知错误"), lastException);
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
}