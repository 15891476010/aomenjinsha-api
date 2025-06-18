package com.youlai.boot.game.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 游戏分类分页查询对象
 *
 * @author MrZhang
 * @since 2025-05-18 16:38
 */
@Schema(description ="游戏分类查询对象")
@Getter
@Setter
public class GameCategoryQuery extends BasePageQuery {
    private Boolean status;
}
