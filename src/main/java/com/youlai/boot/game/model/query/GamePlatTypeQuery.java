package com.youlai.boot.game.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 游戏平台列表分页查询对象
 *
 * @author MrZhang
 * @since 2025-06-15 18:49
 */
@Schema(description ="游戏平台列表查询对象")
@Getter
@Setter
public class GamePlatTypeQuery extends BasePageQuery {

    @Schema(description = "平台名称")
    private String platTypeName;
    @Schema(description = "平台参数")
    private String platType;
    @Schema(description = "支持的币种")
    private List<String> currencys;
    @Schema(description = "支持的游戏类型")
    private List<Integer> gameType;
    @Schema(description = "状态")
    private Boolean status;
}
