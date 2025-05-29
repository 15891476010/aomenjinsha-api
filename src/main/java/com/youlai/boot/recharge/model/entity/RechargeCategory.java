package com.youlai.boot.recharge.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 充值分类实体对象
 *
 * @author MrZhang
 * @since 2025-05-29 00:00
 */
@Getter
@Setter
@TableName("eb_recharge_category")
public class RechargeCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 充值方式名称
     */
    private String name;
    /**
     * 当前充值方式是否在前端显示
     */
    private Boolean status;
    /**
     * 是否删除
     */
    private Integer isDeleted;
    /**
     * 充值方式图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer sort;
}
