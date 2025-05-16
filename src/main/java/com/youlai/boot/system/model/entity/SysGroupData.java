package com.youlai.boot.system.model.entity;

import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 组合分类数据实体对象
 *
 * @author MrZhang
 * @since 2025-05-15 00:48
 */
@Getter
@Setter
@TableName("sys_group_data")
public class SysGroupData extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 对应的数据组id
     */
    private Integer gid;
    /**
     * 数据组对应的数据值（json数据）
     */
    private String value;
    /**
     * 数据排序
     */
    private Integer sort;
    /**
     * 状态（1：开启；2：关闭；）
     */
    private Boolean status;
}
