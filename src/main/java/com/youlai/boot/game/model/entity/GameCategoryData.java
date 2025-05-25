package com.youlai.boot.game.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 游戏列实体对象
 *
 * @author MrZhang
 * @since 2025-05-18 19:33
 */
@Getter
@Setter
@TableName("game_category_data")
public class GameCategoryData extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 游戏分类id
     */
    private Integer pid;
    /**
     * 游戏标题
     */
    private String title;
    /**
     * 游戏图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态
     */
    private Boolean status;
    /**
     * 跳转链接
     */
    private String targetUrl;
    /**
     * 是否删除
     */
    private Boolean isDeleted;
    /**
     * 描述标签
     */
    private String tag;
}
