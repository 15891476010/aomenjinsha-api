package com.youlai.boot.game.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 游戏列分页查询对象
 *
 * @author MrZhang
 * @since 2025-06-18 18:13
 */
@Schema(description ="游戏列查询对象")
@Getter
@Setter
public class GameCategoryDataFrontQuery extends BasePageQuery {

    @Schema(description = "游戏标题")
    private String title;
    @Schema(description = "平台类型")
    private String platType;
    @Schema(description = "游戏分类id")
    private Long categoryId;
}
