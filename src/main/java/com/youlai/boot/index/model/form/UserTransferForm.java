package com.youlai.boot.index.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

/**
 * 玩家投注表表单对象
 *
 * @author MrZhang
 * @since 2025-05-30 12:33
 */
@Getter
@Setter
@Schema(description = "玩家投注表表单对象")
public class UserTransferForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户id")
    @NotBlank(message = "用户id不能为空")
    @Size(max=255, message="用户id长度不能超过255个字符")
    private String playerId;

    @Schema(description = "游戏id")
    @NotBlank(message = "游戏id不能为空")
    @Size(max=255, message="游戏id长度不能超过255个字符")
    private String gid;

    @Schema(description = "投注金额")
    @Size(max=255, message="投注金额长度不能超过255个字符")
    private String betAmount;

    @Schema(description = "盈利金额")
    @Size(max=255, message="盈利金额长度不能超过255个字符")
    private String winAmount;

    @Schema(description = "盈利差值")
    @Size(max=255, message="盈利差值长度不能超过255个字符")
    private String netAmount;

    @Schema(description = "币种")
    @Size(max=255, message="币种长度不能超过255个字符")
    private String currency;

    @Schema(description = "唯一订单号")
    @Size(max=255, message="唯一订单号长度不能超过255个字符")
    private String transactionid;

    @Schema(description = "母订单号")
    @Size(max=255, message="母订单号长度不能超过255个字符")
    private String parentTransactionid;

    @Schema(description = "订单是否已经结束")
    private Integer isEndRound;

    @Schema(description = "当前订单10位时间戳")
    @Size(max=255, message="当前订单10位时间戳长度不能超过255个字符")
    private String timestamp;


}
