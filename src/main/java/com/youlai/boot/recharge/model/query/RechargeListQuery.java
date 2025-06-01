package com.youlai.boot.recharge.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.math.BigDecimal;

/**
 * 用户充值列表分页查询对象
 *
 * @author MrZhang
 * @since 2025-06-01 19:49
 */
@Schema(description ="用户充值列表查询对象")
@Getter
@Setter
public class RechargeListQuery extends BasePageQuery {

    @Schema(description = "充值金额")
    private BigDecimal price;
    @Schema(description = "收款人姓名")
    private String name;
    @Schema(description = "当前充值币种")
    private String currency;
    @Schema(description = "当前充值状态")
    private Integer status;
    @Schema(description = "创建时间")
    private List<String> createTime;
    @Schema(description = "更新时间")
    private List<String> updateTime;
}
