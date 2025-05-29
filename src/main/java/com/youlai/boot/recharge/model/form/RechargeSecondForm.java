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
 * 充值分类子配置表单对象
 *
 * @author MrZhang
 * @since 2025-05-29 13:32
 */
@Getter
@Setter
@Schema(description = "充值分类子配置表单对象")
public class RechargeSecondForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Integer id;

    @Schema(description = "分类id")
    @NotNull(message = "分类id不能为空")
    private Integer pid;

    @Schema(description = "名称")
    @NotBlank(message = "名称不能为空")
    @Size(max=255, message="名称长度不能超过255个字符")
    private String name;

    @Schema(description = "图标")
    @Size(max=255, message="图标长度不能超过255个字符")
    private String icon;

    @Schema(description = "充值送(%)")
    private Integer tag;

    @Schema(description = "自定义充值")
    private Boolean isOnlySetting;

    @Schema(description = "币种")
    @NotBlank(message = "币种不能为空")
    @Size(max=255, message="币种长度不能超过255个字符")
    private String currency;

    @Schema(description = "币种汇率")
    @NotNull(message = "币种汇率不能为空")
    private Float rate;

    @Schema(description = "最小充值")
    @NotNull(message = "最小充值不能为空")
    private BigDecimal minPrice;

    @Schema(description = "最大充值")
    @NotNull(message = "最大充值不能为空")
    private BigDecimal maxPrice;

    @Schema(description = "是否推荐")
    private Boolean isHot;

    @Schema(description = "备注")
    @Size(max=255, message="备注长度不能超过255个字符")
    private String common;

    @Schema(description = "状态")
    @NotNull(message = "状态不能为空")
    private Boolean status;

    @Schema(description = "排序")
    @NotNull(message = "排序不能为空")
    private Integer sort;


}
