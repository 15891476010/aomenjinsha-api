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
 * 充值三级配置表单对象
 *
 * @author MrZhang
 * @since 2025-05-29 18:59
 */
@Getter
@Setter
@Schema(description = "充值三级配置表单对象")
public class RechargeThreeForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Integer id;

    @Schema(description = "父id")
    @NotNull(message = "父id不能为空")
    private Integer pid;

    @Schema(description = "收款码图片")
    @Size(max=255, message="收款码图片长度不能超过255个字符")
    private String img;

    @Schema(description = "充值金额")
    @NotNull(message = "充值金额不能为空")
    private BigDecimal amount;

    @Schema(description = "收款人姓名")
    @NotBlank(message = "收款人姓名不能为空")
    @Size(max=255, message="收款人姓名长度不能超过255个字符")
    private String name;

    @Schema(description = "U地址或银行卡号")
    @Size(max=255, message="U地址或银行卡号长度不能超过255个字符")
    private String address;

    @Schema(description = "所属银行")
    @Size(max=255, message="所属银行长度不能超过255个字符")
    private String bank;

    @Schema(description = "银行卡开户地")
    @Size(max=255, message="银行卡开户地长度不能超过255个字符")
    private String bankAddress;

    @Schema(description = "跳转地址")
    @Size(max=255, message="跳转地址长度不能超过255个字符")
    private String target;

    @Schema(description = "打开方式")
    @Size(max=255, message="打开方式长度不能超过255个字符")
    private String openType;

    @Schema(description = "是否推荐")
    @NotNull(message = "是否推荐不能为空")
    private Boolean isHot;

    @Schema(description = "币种")
    @NotBlank(message = "币种不能为空")
    @Size(max=255, message="币种长度不能超过255个字符")
    private String currency;

    @Schema(description = "状态")
    @NotNull(message = "状态不能为空")
    private Boolean status;

    @Schema(description = "排序")
    @NotNull(message = "排序不能为空")
    private Integer sort;
}
