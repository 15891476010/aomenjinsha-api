package com.youlai.boot.game.model.vo;

import com.youlai.boot.game.model.entity.GamePlatType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 游戏分类视图对象
 *
 * @author MrZhang
 * @since 2025-05-18 16:38
 */
@Getter
@Setter
@Schema( description = "游戏分类视图对象")
public class GameCategoryResultVO implements Serializable {

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
    @Schema(description = "游戏列表数据")
    private List<GameCategoryDataVO> gameCategoryData;
    @Schema(description = "游戏平台数据")
    private List<GamePlatType> gamePlatType;
}
