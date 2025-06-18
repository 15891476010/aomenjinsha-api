package com.youlai.boot.recharge.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;

/**
 * 充值三级配置视图对象
 *
 * @author MrZhang
 * @since 2025-05-29 18:59
 */
@Getter
@Setter
@Schema( description = "充值三级配置视图对象")
public class RechargeThreeVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Integer id;
    @Schema(description = "父id")
    private Integer pid;
    @Schema(description = "收款码图片")
    private String img;
    @Schema(description = "充值金额")
    private BigDecimal amount;
    @Schema(description = "收款人姓名")
    private String name;
    @Schema(description = "U地址或银行卡号")
    private String address;
    @Schema(description = "所属银行")
    private String bank;
    @Schema(description = "银行卡开户地")
    private String bankAddress;
    @Schema(description = "跳转地址")
    private String target;
    @Schema(description = "打开方式")
    private String openType;
    @Schema(description = "是否推荐")
    private Boolean isHot;
    @Schema(description = "币种")
    private String currency;
    @Schema(description = "状态")
    private Boolean status;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
