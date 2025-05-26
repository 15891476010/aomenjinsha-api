package com.youlai.boot.utils;

import com.alibaba.fastjson.JSON;
import okhttp3.MediaType;
import org.springframework.http.*;
import okhttp3.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
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
        // 1. 将 Map 转换为 JSON 字符串
        String json = JSON.toJSONString(params);
        System.out.println(">>> 请求的 JSON 数据:\n" + json);

        // 2. 创建 RequestBody
        RequestBody requestBody = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );

        // 3. 构建请求对象
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .addHeader("Accept", "application/json")
                .build();

        // 4. 打印请求信息
        System.out.println(">>> 请求头:\n" + request.headers());

        // 5. 发送请求并处理响应
        try (Response response = client.newCall(request).execute()) {
            System.out.println("<<< HTTP 状态码: " + response.code());

            String responseBody = response.body().string();
            System.out.println("<<< 响应内容:\n" + responseBody);

            // 将 JSON 响应转换为 Map
            Map<String, Object> responseMap = JSON.parseObject(responseBody, Map.class);

            // 提取 data 字段的内容
            if (responseMap != null && responseMap.containsKey("data")) {
                Object data = responseMap.get("data");
                if (data instanceof Map) {
                    return (Map<String, Object>) data;
                } else {
                    // 如果 data 不是 Map 类型，可以抛异常或返回包含 data 的 Map
                    Map<String, Object> result = new HashMap<>();
                    result.put("data", data);
                    return result;
                }
            } else {
                // 如果没有 data 字段，返回整个响应
                return responseMap;
            }
        } catch (IOException e) {
            System.err.println("!!! 请求失败: " + e.getMessage());
            throw e;
        }
    }
} 