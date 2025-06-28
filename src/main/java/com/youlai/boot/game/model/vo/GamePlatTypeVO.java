package com.youlai.boot.game.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 游戏平台列表视图对象
 *
 * @author MrZhang
 * @since 2025-06-26 21:37
 */
@Getter
@Setter
@Schema( description = "游戏平台列表视图对象")
public class GamePlatTypeVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Integer id;
    @Schema(description = "平台名称")
    private String platTypeName;
    @Schema(description = "平台参数")
    private String platType;
    @Schema(description = "游戏类型")
    private Integer gameType;
    @Schema(description = "游戏类型汉字")
    private String gameTypeHanZi;
    @Schema(description = "游戏代码")
    private String gameCode;
    @Schema(description = "副标题")
    private String subName;
    @Schema(description = "小图标")
    private String smallIcon;
    @Schema(description = "手机图标")
    private String icon;
    @Schema(description = "状态")
    private Boolean status;
    @Schema(description = "是否显示标题")
    private Boolean isShowTitle;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
