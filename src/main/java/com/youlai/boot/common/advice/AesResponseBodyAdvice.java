package com.youlai.boot.common.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youlai.boot.common.annotation.AesEncrypt;
import com.youlai.boot.utils.HttpAESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class AesResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper objectMapper; // 注入全局配置的ObjectMapper

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.hasMethodAnnotation(AesEncrypt.class) || returnType.getContainingClass().isAnnotationPresent(AesEncrypt.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  org.springframework.http.server.ServerHttpRequest request,
                                  org.springframework.http.server.ServerHttpResponse response) {
        try {
            String json = objectMapper.writeValueAsString(body); // 用全局的
            System.out.println("加密前内容：" + json);
            System.out.println("加密前原始对象：" + body);
            return HttpAESUtil.encrypt(json);
        } catch (Exception e) {
            e.printStackTrace(); // 这行很关键！
            throw new RuntimeException("AES加密失败: " + e.getMessage(), e);
        }
    }
} 