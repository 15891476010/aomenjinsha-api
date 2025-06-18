package com.youlai.boot.game.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 游戏平台列表视图对象
 *
 * @author MrZhang
 * @since 2025-06-15 18:49
 */
@Getter
@Setter
@Schema( description = "游戏平台列表视图对象")
public class GamePlatTypeFrontVO extends GamePlatTypeVO implements Serializable {
    private String categoryName;
}
