package com.youlai.boot.config;

import cn.hutool.core.util.ObjectUtil;
import com.youlai.boot.common.constant.SysConfigConstant;
import com.youlai.boot.system.service.ConfigService;
import io.minio.MinioClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    private static final Logger logger = LoggerFactory.getLogger(MinioConfig.class);

    @Autowired
    private ConfigService configService;

    @Bean
    public MinioClient minioClient() {
        try {
            String endpoint = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MINIO_UPLOAD_DOMAIN);
            String accessKey = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MINIO_UPLOAD_ACCESS_KEY);
            String secretKey = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MINIO_UPLOAD_SECRET_KEY);

            // 参数验证
            if (ObjectUtil.isEmpty(endpoint)) {
                throw new IllegalArgumentException("MinIO endpoint cannot be null or empty");
            }
            if (ObjectUtil.isEmpty(accessKey)) {
                throw new IllegalArgumentException("MinIO accessKey cannot be null or empty");
            }
            if (ObjectUtil.isEmpty(secretKey)) {
                throw new IllegalArgumentException("MinIO secretKey cannot be null or empty");
            }

            logger.info("Initializing MinioClient with endpoint: {}", endpoint);

            // 创建并返回 MinioClient 实例
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(endpoint)
                    .credentials(accessKey, secretKey)
                    .build();

            logger.info("MinioClient initialized successfully");
            return minioClient;

        } catch (Exception e) {
            logger.error("Failed to initialize MinioClient: {}", e.getMessage(), e);
            throw new RuntimeException("MinIO configuration error: " + e.getMessage(), e);
        }
    }
}
