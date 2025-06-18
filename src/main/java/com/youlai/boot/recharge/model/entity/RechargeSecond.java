package com.youlai.boot.recharge.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 充值分类子配置实体对象
 *
 * @author MrZhang
 * @since 2025-05-29 13:32
 */
@Getter
@Setter
@TableName("eb_recharge_second")
public class RechargeSecond extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    private Integer pid;
    /**
     * 名称
     */
    private String name;
    /**
     * 图标
     */
    private String icon;
    /**
     * 充值送(%)
     */
    private Integer tag;
    /**
     * 自定义充值
     */
    private Boolean isOnlySetting;
    /**
     * 币种
     */
    private String currency;
    /**
     * 币种汇率
     */
    private Float rate;
    /**
     * 最小充值
     */
    private BigDecimal minPrice;
    /**
     * 最大充值
     */
    private BigDecimal maxPrice;
    /**
     * 是否推荐
     */
    private Boolean isHot;
    /**
     * 备注
     */
    private String common;
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
