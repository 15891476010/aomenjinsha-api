package com.youlai.boot.recharge.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 充值三级配置实体对象
 *
 * @author MrZhang
 * @since 2025-05-29 18:59
 */
@Getter
@Setter
@TableName("eb_recharge_three")
public class RechargeThree extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父id
     */
    private Integer pid;
    /**
     * 收款码图片
     */
    private String img;
    /**
     * 充值金额
     */
    private BigDecimal amount;
    /**
     * 收款人姓名
     */
    private String name;
    /**
     * U地址或银行卡号
     */
    private String address;
    /**
     * 所属银行
     */
    private String bank;
    /**
     * 银行卡开户地
     */
    private String bankAddress;
    /**
     * 跳转地址
     */
    private String target;
    /**
     * 打开方式
     */
    private String openType;
    /**
     * 是否推荐
     */
    private Boolean isHot;
    /**
     * 币种
     */
    private String currency;
    /**
     * 状态
     */
    private Boolean status;
    /**
     * 是否删除
     */
    private Boolean isDeleted;
    /**
     * 排序
     */
    private Integer sort;
}
