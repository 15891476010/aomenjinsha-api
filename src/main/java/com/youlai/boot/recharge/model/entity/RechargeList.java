package com.youlai.boot.recharge.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 用户充值列表实体对象
 *
 * @author MrZhang
 * @since 2025-06-01 19:49
 */
@Getter
@Setter
@TableName("eb_recharge_list")
public class RechargeList extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 充值用户id
     */
    private Integer userId;
    /**
     * 收款码图片
     */
    private String img;
    /**
     * 充值金额
     */
    private BigDecimal price;
    /**
     * 收款人姓名
     */
    private String name;
    /**
     * 当收款方式为usdt时这里填写usdt地址，当是银行卡时则填写银行卡号
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
     * 当前充值币种
     */
    private String currency;
    /**
     * 当前充值状态
     */
    private Integer status;
    /**
     * 是否删除
     */
    private Boolean isDeleted;
    /**
     * 排序
     */
    private Integer sort;
}
