package com.youlai.boot.game.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 游戏列视图对象
 *
 * @author MrZhang
 * @since 2025-06-18 18:13
 */
@Getter
@Setter
@Schema( description = "游戏列视图对象")
public class GameCategoryDataVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "游戏id")
    private Integer id;
    @Schema(description = "游戏分类id")
    private Integer pid;
    @Schema(description = "游戏标题")
    private String title;
    @Schema(description = "游戏图标")
    private String icon;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "状态")
    private Boolean status;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
    @Schema(description = "描述标签")
    private String tag;
    @Schema(description = "是否热门")
    private Boolean isHot;
    @Schema(description = "游戏平台")
    private String platType;
    @Schema(description = "简体中文")
    private String zhHans;
    @Schema(description = "繁体中文")
    private String zhHant;
    @Schema(description = "英语")
    private String en;
    @Schema(description = "支持终端类型，1:电脑网页、2:手机网页、3:电脑/手机网页")
    private Integer ingress;
    @Schema(description = "跳转链接")
    private String gameCode;
    @Schema(description = "供应商")
    private String provider;
}
