package com.youlai.boot.recharge.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

/**
 * 充值分类子配置视图对象
 *
 * @author MrZhang
 * @since 2025-05-29 00:36
 */
@Getter
@Setter
@Schema( description = "充值分类子配置视图对象")
public class RechargeConfigVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Integer id;
    @Schema(description = "充值分类id")
    private Integer pid;
    @Schema(description = "充值方式名称")
    private String name;
    @Schema(description = "充值方式图标")
    private String icon;
    @Schema(description = "充值送多少，单位%")
    private Integer tag;
    @Schema(description = "是否推荐")
    private Boolean isHot;
    @Schema(description = "当前充值方式是否在前端显示")
    private Boolean status;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
    private List<RechargeSecondVO> second;
}
