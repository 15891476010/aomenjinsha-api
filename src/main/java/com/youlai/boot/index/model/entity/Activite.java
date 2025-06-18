package com.youlai.boot.index.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 活动表实体对象
 *
 * @author MrZhang
 * @since 2025-06-06 21:09
 */
@Getter
@Setter
@TableName("activite")
public class Activite extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 活动类型
     */
    private Integer pid;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 活动图片
     */
    private String image;
    /**
     * 是否可以申请
     */
    private Boolean canApply;
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
