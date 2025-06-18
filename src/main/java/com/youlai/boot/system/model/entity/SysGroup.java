package com.youlai.boot.system.model.entity;

import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 组合数据分类实体对象
 *
 * @author MrZhang
 * @since 2025-05-15 00:13
 */
@Getter
@Setter
@TableName("sys_group")
public class SysGroup extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 数据组名称
     */
    private String name;
    /**
     * 简介
     */
    private String info;
    /**
     * form 表单 id
     */
    private Integer formId;
}
