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
 * @since 2025-05-29 00:36
 */
@Getter
@Setter
@Schema(description = "充值分类子配置表单对象")
public class RechargeConfigForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Integer id;

    @Schema(description = "充值分类id")
    private Integer pid;

    @Schema(description = "充值方式名称")
    @Size(max=255, message="充值方式名称长度不能超过255个字符")
    private String name;

    @Schema(description = "充值方式图标")
    @Size(max=255, message="充值方式图标长度不能超过255个字符")
    private String icon;

    @Schema(description = "充值送多少，单位%")
    private Integer tag;

    @Schema(description = "是否推荐")
    @NotNull(message = "是否推荐不能为空")
    private Boolean isHot;

    @Schema(description = "当前充值方式是否在前端显示")
    @NotNull(message = "当前充值方式是否在前端显示不能为空")
    private Boolean status;

    @Schema(description = "排序")
    private Integer sort;
}
