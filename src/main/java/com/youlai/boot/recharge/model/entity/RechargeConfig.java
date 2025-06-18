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
 * @since 2025-05-29 00:35
 */
@Getter
@Setter
@TableName("eb_recharge_config")
public class RechargeConfig extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 充值分类id
     */
    private Integer pid;
    /**
     * 充值方式名称
     */
    private String name;
    /**
     * 充值方式图标
     */
    private String icon;
    /**
     * 充值送多少，单位%
     */
    private Integer tag;
    /**
     * 是否推荐
     */
    private Boolean isHot;
    /**
     * 当前充值方式是否在前端显示
     */
    private Boolean status;
    /**
     * 是否删除
     */
    private Integer isDeleted;
    /**
     * 排序
     */
    private Integer sort;
}
