package com.youlai.boot.game.service;


import java.util.List;
import java.util.Map;

public interface GameService {
    /**
     * 获取游戏地址
     */
    Map<String, Object> getGameUrl(Long id);

    /**
     * 获取游戏提供商列表
     */
    List<Map<String, String>> getGameProviderList();

    /**
     * 获取商户 余额
     */
    String getCredit(String apiCode);
    /**
     * 额度转出
     */
    Map<String, Object> userTransfer(String gamePlate);
}
