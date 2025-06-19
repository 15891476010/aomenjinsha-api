package com.youlai.boot.game.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 游戏平台列表实体对象
 *
 * @author MrZhang
 * @since 2025-06-15 18:49
 */
@Getter
@Setter
@TableName(value = "game_plat_type", autoResultMap = true)
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
     * 支持的币种
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> currencys;
    /**
     * 支持的游戏类型
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Integer> gameType;
    /**
     * 游戏代码
     */
    private String gameCode;
    /**
     * 游戏素材
     */
    private String gameMaterial;
    /**
     * 游戏素材账号
     */
    private String materialAccount;
    /**
     * 游戏素材密码
     */
    private String materialPwd;
    /**
     * 平台图标
     */
    private String icon;
    /**
     * 状态(是否维修)
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
    /**
     * 小图标
     */
    private String smallIcon;
}
