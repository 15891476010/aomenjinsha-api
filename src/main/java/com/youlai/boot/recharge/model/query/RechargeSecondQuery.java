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
 * @since 2025-05-29 13:32
 */
@Schema(description ="充值分类子配置查询对象")
@Getter
@Setter
public class RechargeSecondQuery extends BasePageQuery {

    @Schema(description = "分类id")
    private Integer pid;
    @Schema(description = "名称")
    private String name;
    @Schema(description = "币种")
    private String currency;
    @Schema(description = "是否推荐")
    private Boolean isHot;
    @Schema(description = "状态")
    private Boolean status;
}
