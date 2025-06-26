package com.youlai.boot.game.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 游戏平台列表实体对象
 *
 * @author MrZhang
 * @since 2025-06-26 21:37
 */
@Getter
@Setter
@TableName("game_plat_type")
public class GamePlatType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 平台名称
     */
    private String platTypeName;
    /**
     * 平台参数
     */
    private String platType;
    /**
     * 游戏类型
     */
    private Integer gameType;
    /**
     * 游戏代码
     */
    private String gameCode;
    /**
     * 副标题
     */
    private String subName;
    /**
     * 小图标
     */
    private String smallIcon;
    /**
     * 手机图标
     */
    private String icon;
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
