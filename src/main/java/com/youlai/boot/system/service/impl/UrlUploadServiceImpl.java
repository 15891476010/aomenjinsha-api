package com.youlai.boot.system.service.impl;

import com.youlai.boot.common.result.Result;
import com.youlai.boot.system.model.vo.FileResultVo;
import com.youlai.boot.system.service.UploadService;
import com.youlai.boot.system.service.UrlUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UrlUploadServiceImpl implements UrlUploadService {

    @Autowired
    private UploadService uploadService;

    @Override
    public FileResultVo imageUrlUpload(String url, String model, Integer pid) throws Exception {
        HttpURLConnection connection = null;
        try {
            // 创建URL连接
            URL imageUrl = new URL(url);
            connection = (HttpURLConnection) imageUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);  // 5秒连接超时
            connection.setReadTimeout(30000);    // 30秒读取超时
            connection.setInstanceFollowRedirects(true); // 允许重定向

            // 校验HTTP状态码
            int status = connection.getResponseCode();
            if (status < 200 || status >= 300) {
                throw new IOException("文件下载失败，HTTP状态码: " + status);
            }

            // 构建自定义MultipartFile
            MultipartFile multipartFile = buildCustomMultipartFile(connection, url, null);

            // 调用上传服务
            return uploadService.imageUpload(multipartFile, model, pid);

        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("无效的URL格式: " + url, e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    @Override
    public FileResultVo urlUploadName(String url, String model, Integer pid, String name) throws Exception {
        HttpURLConnection connection = null;
        try {
            // 创建URL连接
            URL imageUrl = new URL(url);
            connection = (HttpURLConnection) imageUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);  // 5秒连接超时
            connection.setReadTimeout(30000);    // 30秒读取超时
            connection.setInstanceFollowRedirects(true); // 允许重定向

            // 校验HTTP状态码
            int status = connection.getResponseCode();
            if (status < 200 || status >= 300) {
                throw new IOException("文件下载失败，HTTP状态码: " + status);
            }

            // 构建自定义MultipartFile
            MultipartFile multipartFile = buildCustomMultipartFile(connection, url, name);

            // 调用上传服务
            return uploadService.imageUpload(multipartFile, model, pid);

        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("无效的URL格式: " + url, e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * 构建自定义MultipartFile实现
     */
    private MultipartFile buildCustomMultipartFile(HttpURLConnection connection, String url, String name) throws IOException {
        // 获取文件名
        String fileName = name != null ? name : resolveFileName(connection, url);

        // 获取内容类型
        String contentType = Optional.ofNullable(connection.getContentType())
                .orElseGet(() -> URLConnection.guessContentTypeFromName(fileName));

        // 读取文件内容到字节数组
        byte[] fileContent;
        try (InputStream is = connection.getInputStream();
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            fileContent = os.toByteArray();
        }

        return new MultipartFile() {
            @Override public String getName() { return "file"; }
            @Override public String getOriginalFilename() { return fileName; }
            @Override public String getContentType() { return contentType; }
            @Override public boolean isEmpty() { return fileContent.length == 0; }
            @Override public long getSize() { return fileContent.length; }
            @Override public byte[] getBytes() { return fileContent; }
            @Override public InputStream getInputStream() { return new ByteArrayInputStream(fileContent); }
            @Override public void transferTo(File dest) throws IOException {
                Files.write(dest.toPath(), fileContent);
            }
        };
    }

    /**
     * 解析文件名（支持UTF-8编码格式）
     */
    private String resolveFileName(HttpURLConnection connection, String url) {
        try {
            // 从Content-Disposition头解析
            String disposition = connection.getHeaderField("Content-Disposition");
            if (disposition != null) {
                Matcher matcher = Pattern.compile("filename\\*?=([^;]+)").matcher(disposition);
                if (matcher.find()) {
                    String encodedName = matcher.group(1)
                            .replace("UTF-8''", "")
                            .replaceAll("\"", "");
                    return URLDecoder.decode(encodedName, StandardCharsets.UTF_8.name());
                }
            }

            // 从URL路径解析
            URI uri = new URI(url);
            String path = uri.getPath();
            if (path != null && path.contains("/")) {
                return path.substring(path.lastIndexOf('/') + 1);
            }
        } catch (Exception e) {
            // 忽略解析异常
        }

        // 生成随机文件名
        return "file_" + System.currentTimeMillis();
    }
}
