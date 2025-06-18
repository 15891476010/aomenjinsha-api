package com.youlai.boot.game.model.vo;

import com.youlai.boot.game.model.entity.GamePlatType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
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
public class GameCategoryFrontVO extends GameCategoryVO implements Serializable {
    private List<GamePlatType> gamePlatTypes;
}
