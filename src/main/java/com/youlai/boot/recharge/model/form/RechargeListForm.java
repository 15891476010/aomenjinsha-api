package com.youlai.boot.recharge.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

/**
 * 用户充值列表表单对象
 *
 * @author MrZhang
 * @since 2025-06-01 19:49
 */
@Getter
@Setter
@Schema(description = "用户充值列表表单对象")
public class RechargeListForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "充值用户id")
    private Integer userId;

    @Schema(description = "收款码图片")
    @Size(max=255, message="收款码图片长度不能超过255个字符")
    private String img;

    @Schema(description = "充值金额")
    @NotNull(message = "充值金额不能为空")
    private BigDecimal price;

    @Schema(description = "收款人姓名")
    @NotBlank(message = "收款人姓名不能为空")
    @Size(max=255, message="收款人姓名长度不能超过255个字符")
    private String name;

    @Schema(description = "当收款方式为usdt时这里填写usdt地址，当是银行卡时则填写银行卡号")
    @NotBlank(message = "当收款方式为usdt时这里填写usdt地址，当是银行卡时则填写银行卡号不能为空")
    @Size(max=255, message="当收款方式为usdt时这里填写usdt地址，当是银行卡时则填写银行卡号长度不能超过255个字符")
    private String address;

    @Schema(description = "所属银行")
    @Size(max=255, message="所属银行长度不能超过255个字符")
    private String bank;

    @Schema(description = "银行卡开户地")
    @Size(max=255, message="银行卡开户地长度不能超过255个字符")
    private String bankAddress;

    @Schema(description = "当前充值币种")
    @Size(max=255, message="当前充值币种长度不能超过255个字符")
    private String currency;

    @Schema(description = "当前充值状态")
    private Integer status;


}
