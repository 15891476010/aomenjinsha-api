package com.youlai.boot.recharge.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;

/**
 * 用户充值列表视图对象
 *
 * @author MrZhang
 * @since 2025-06-01 19:49
 */
@Getter
@Setter
@Schema( description = "用户充值列表视图对象")
public class RechargeListVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "充值方式id")
    private Integer id;
    @Schema(description = "收款码图片")
    private String img;
    @Schema(description = "充值金额")
    private BigDecimal price;
    @Schema(description = "收款人姓名")
    private String name;
    @Schema(description = "当收款方式为usdt时这里填写usdt地址，当是银行卡时则填写银行卡号")
    private String address;
    @Schema(description = "所属银行")
    private String bank;
    @Schema(description = "银行卡开户地")
    private String bankAddress;
    @Schema(description = "当前充值币种")
    private String currency;
    @Schema(description = "当前充值状态")
    private Integer status;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
