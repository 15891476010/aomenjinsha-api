package com.youlai.boot.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "encrypt")
@Data
public class EncryptProperties {
    /**
     * 加密密钥
     */
    private String secretKey;

    /**
     * 是否启用
     */
    private Boolean enabled;

    /**
     * 默认配置
     */
    private String algorithm;
}
