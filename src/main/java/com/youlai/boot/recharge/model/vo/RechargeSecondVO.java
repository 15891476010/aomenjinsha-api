package com.youlai.boot.recharge.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

/**
 * 充值分类子配置视图对象
 *
 * @author MrZhang
 * @since 2025-05-29 13:32
 */
@Getter
@Setter
@Schema( description = "充值分类子配置视图对象")
public class RechargeSecondVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Integer id;
    @Schema(description = "分类id")
    private Integer pid;
    @Schema(description = "名称")
    private String name;
    @Schema(description = "图标")
    private String icon;
    @Schema(description = "充值送(%)")
    private Integer tag;
    @Schema(description = "自定义充值")
    private Boolean isOnlySetting;
    @Schema(description = "币种")
    private String currency;
    @Schema(description = "币种汇率")
    private Float rate;
    @Schema(description = "最小充值")
    private BigDecimal minPrice;
    @Schema(description = "最大充值")
    private BigDecimal maxPrice;
    @Schema(description = "是否推荐")
    private Boolean isHot;
    @Schema(description = "备注")
    private String common;
    @Schema(description = "状态")
    private Boolean status;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
    private List<RechargeThreeVO> three;
}
