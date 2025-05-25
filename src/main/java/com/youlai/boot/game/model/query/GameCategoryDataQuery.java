package com.youlai.boot.game.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 游戏列分页查询对象
 *
 * @author MrZhang
 * @since 2025-05-18 19:33
 */
@Schema(description ="游戏列查询对象")
@Getter
@Setter
public class GameCategoryDataQuery extends BasePageQuery {

    @Schema(description = "游戏分类id")
    private Integer pid;
    @Schema(description = "游戏标题")
    private String title;
    @Schema(description = "状态")
    private Boolean status;
    @Schema(description = "描述标签")
    private String tag;
}
