package com.youlai.boot.index.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 玩家投注表实体对象
 *
 * @author MrZhang
 * @since 2025-05-30 12:33
 */
@Getter
@Setter
@TableName("eb_user_transfer")
public class UserTransfer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 用户id */
    private String playerId;
    /** 游戏id */
    private String gid;
    /** 投注金额 */
    private String betAmount;
    /** 盈利金额 */
    private String winAmount;
    /** 盈利差值 */
    private String netAmount;
    /** 币种 */
    private String currency;
    /** 唯一订单号 */
    private String transactionid;
    /** 母订单号 */
    private String parentTransactionid;
    /** 订单是否已经结束 */
    private Integer isEndRound;
    /** 当前订单10位时间戳 */
    private String timestamp;
    /** 是否删除 */
    private Boolean isDeleted;
}
