package com.youlai.boot.game.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 游戏分类视图对象
 *
 * @author MrZhang
 * @since 2025-05-18 16:38
 */
@Getter
@Setter
@Schema( description = "游戏分类视图对象")
public class GameCategoryVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "游戏id")
    private Integer id;
    @Schema(description = "游戏分类名称")
    private String title;
    @Schema(description = "游戏分类图标")
    private String icon;
    @Schema(description = "未选中时游戏分类图标")
    private String noIcon;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
    @Schema(description = "显示状态")
    private Boolean status;
    private Integer sort;
}
