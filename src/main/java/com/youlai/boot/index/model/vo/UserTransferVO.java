package com.youlai.boot.index.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 玩家投注表视图对象
 *
 * @author MrZhang
 * @since 2025-05-30 12:33
 */
@Getter
@Setter
@Schema( description = "玩家投注表视图对象")
public class UserTransferVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    @Schema(description = "用户id")
    private String playerId;
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "游戏名称")
    private String gameName;
    @Schema(description = "游戏id")
    private String gid;
    @Schema(description = "投注金额")
    private String betAmount;
    @Schema(description = "盈利金额")
    private String winAmount;
    @Schema(description = "盈利差值")
    private String netAmount;
    @Schema(description = "币种")
    private String currency;
    @Schema(description = "唯一订单号")
    private String transactionid;
    @Schema(description = "母订单号")
    private String parentTransactionid;
    @Schema(description = "订单是否已经结束")
    private Integer isEndRound;
    @Schema(description = "当前订单10位时间戳")
    private String timestamp;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
