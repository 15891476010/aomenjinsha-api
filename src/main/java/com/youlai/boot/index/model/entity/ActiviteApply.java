package com.youlai.boot.index.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 用户活动申请实体对象
 *
 * @author MrZhang
 * @since 2025-06-07 15:34
 */
@Getter
@Setter
@TableName("activite_apply")
public class ActiviteApply extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 活动id
     */
    private Integer activiteId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 申请状态
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
