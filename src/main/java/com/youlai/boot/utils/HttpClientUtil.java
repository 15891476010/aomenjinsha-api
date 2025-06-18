package com.youlai.boot.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.MediaType;
import org.springframework.http.*;
import okhttp3.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * HttpClient工具类，简化第三方接口调用
 */
public class HttpClientUtil {

    private static final OkHttpClient client = new OkHttpClient();

    /**
     * 有参POST请求
     * @param url 请求的URL
     * @param params 请求参数
     * @return 响应字符串
     * @throws IOException 请求异常
     */
    public static Map<String, Object> post(String url, Map<String, Object> params) throws IOException {
        try {
            // 1. 提取headers（如果存在）
            Map<String, Object> headers = new HashMap<>();
            if (params.containsKey("_headers")) {
                Object headersObj = params.get("_headers");
                if (headersObj instanceof Map) {
                    headers = (Map<String, Object>) headersObj;
                }
                // 从params中移除headers，避免重复发送
                params.remove("_headers");
            }

            // 2. 将 Map 转换为 JSON 字符串
            String json = JSON.toJSONString(params);
            System.out.println(">>> 请求的 JSON 数据:\n" + json);

            // 3. 创建 RequestBody
            RequestBody requestBody = RequestBody.create(
                    json,
                    MediaType.parse("application/json; charset=utf-8")
            );

            // 4. 构建请求对象并添加headers
            Request.Builder requestBuilder = new Request.Builder()
                    .url(url)
                    .post(requestBody);

            // 添加从_headers提取的请求头
            headers.forEach((key, value) -> {
                if (value != null) {
                    requestBuilder.addHeader(key, value.toString());
                }
            });

            Request request = requestBuilder.build();

            // 5. 打印请求信息
            System.out.println(">>> 请求头:\n" + request.headers());

            // 6. 发送请求并处理响应
            try (Response response = client.newCall(request).execute()) {
                System.out.println("<<< HTTP 状态码: " + response.code());

                String responseBody = response.body().string();
                System.out.println("<<< 响应内容:\n" + responseBody);

                // 将 JSON 响应转换为 Map
                Map<String, Object> responseMap = JSON.parseObject(responseBody, Map.class);

                return responseMap;
            }
        } catch (IOException e) {
            System.err.println("!!! 请求失败: " + e.getMessage());
            throw e;
        }
    }

    public static Map<String, Object> postRawJsonLikeCurl(String url,
                                                          String rawJson,
                                                          Map<String, String> headers) throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(
                rawJson.getBytes(StandardCharsets.UTF_8),
                MediaType.parse("application/json")  // 不要加 charset=UTF-8
        );

        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(body);

        // ✅ 严格添加 header（不多不少）
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }

        // ❌ 不要加 Accept 头，和 curl 一样
        builder.removeHeader("Accept");

        Request request = builder.build();

        System.out.println(">>> 请求 URL: " + url);
        System.out.println(">>> 请求体: " + rawJson);
        headers.forEach((k, v) -> System.out.println(k + ": " + v));

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            System.out.println("<<< 响应:\n" + responseBody);
            return JSON.parseObject(responseBody, Map.class);
        }
    }
} 