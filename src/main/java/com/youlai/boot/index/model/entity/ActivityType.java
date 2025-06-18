package com.youlai.boot.index.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 活动类型实体对象
 *
 * @author MrZhang
 * @since 2025-06-06 20:42
 */
@Getter
@Setter
@TableName("activity_type")
public class ActivityType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 活动类型名称
     */
    private String name;
    /**
     * 类型状态
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
