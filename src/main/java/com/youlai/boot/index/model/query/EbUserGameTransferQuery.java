package com.youlai.boot.index.model.query;

import lombok.Data;

@Data
public class EbUserGameTransferQuery {
    /**
     * 投注金额
     */
    private String betAmount;

    /**
     * 盈利金额
     */
    private String winAmount;

    /**
     * 盈利差值
     */
    private String netAmount;

    /**
     * 玩家账号
     */
    private String playerId;

    /**
     * 币种
     */
    private String currency;

    /**
     * 唯一订单
     */
    private String transactionid;

    /**
     * 母订单ID
     */
    private String parentTransactionid;

    /**
     * 订单是否已结束：1结束，0未结束
     */
    private Integer isEndRound;

    /**
     * 游戏ID
     */
    private String gid;

    /**
     * 时间戳10位，如1714382093
     */
    private String timestamp;

    /**
     * md5($merchant_id . $player_id .$transactionid . $net_amount . $timestamp. $merchant_secret)
     */
    private String sign;
}
