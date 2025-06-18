package com.youlai.boot.game.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 游戏分类实体对象
 *
 * @author MrZhang
 * @since 2025-05-18 16:38
 */
@Getter
@Setter
@TableName("game_category")
public class GameCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 游戏分类名称
     */
    private String title;
    /**
     * 游戏分类图标
     */
    private String icon;
    private String noIcon;
    /**
     * 是否删除
     */
    private Boolean isDeleted;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 显示状态
     */
    private Boolean status;
    /**
     * 游戏类型
     */
    private String gameType;
}
