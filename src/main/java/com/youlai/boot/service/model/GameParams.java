package com.youlai.boot.service.model;

import lombok.Data;

@Data
public class GameParams {
    /**
     * 游戏商户
     */
    private String merchant;
    /**
     * 游戏商户密钥
     */
    private String merchantSecret;
    /**
     * 游戏API
     */
    private String apiUrl;
    /**
     * 商户id
     */
    private String merchantId;
    /**
     * 商户前缀
     */
    private String merchantPrefix;
}
