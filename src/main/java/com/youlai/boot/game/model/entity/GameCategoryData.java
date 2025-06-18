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
 * @since 2025-06-18 18:11
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
     * 是否删除
     */
    private Boolean isDeleted;
    /**
     * 描述标签
     */
    private String tag;
    /**
     * 是否热门
     */
    private Boolean isHot;
    /**
     * 游戏平台
     */
    private String platType;
    /**
     * 简体中文
     */
    private String zhHans;
    /**
     * 繁体中文
     */
    private String zhHant;
    /**
     * 英语
     */
    private String en;
    /**
     * 支持终端类型，1:电脑网页、2:手机网页、3:电脑/手机网页
     */
    private Integer ingress;
    /**
     * 跳转链接
     */
    private String gameCode;
    /**
     * 供应商
     */
    private String provider;
}
