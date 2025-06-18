package com.youlai.boot.recharge.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.math.BigDecimal;

/**
 * 充值三级配置分页查询对象
 *
 * @author MrZhang
 * @since 2025-05-29 18:59
 */
@Schema(description ="充值三级配置查询对象")
@Getter
@Setter
public class RechargeThreeQuery extends BasePageQuery {

    @Schema(description = "pid")
    private Long pid;
    @Schema(description = "收款人姓名")
    private String name;
    @Schema(description = "U地址或银行卡号")
    private String address;
    @Schema(description = "所属银行")
    private String bank;
    @Schema(description = "是否推荐")
    private Boolean isHot;
    @Schema(description = "币种")
    private String currency;
    @Schema(description = "状态")
    private Boolean status;
}
