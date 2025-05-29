package com.youlai.boot.recharge.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.math.BigDecimal;

/**
 * 充值分类子配置分页查询对象
 *
 * @author MrZhang
 * @since 2025-05-29 00:36
 */
@Schema(description ="充值分类子配置查询对象")
@Getter
@Setter
public class RechargeConfigQuery extends BasePageQuery {

    @Schema(description = "充值分类id")
    private Integer pid;
    @Schema(description = "充值方式名称")
    private String name;
    @Schema(description = "是否推荐")
    private Boolean isHot;
    @Schema(description = "当前充值方式是否在前端显示")
    private Boolean status;
}
