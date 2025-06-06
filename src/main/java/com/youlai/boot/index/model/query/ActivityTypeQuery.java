package com.youlai.boot.index.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 活动类型分页查询对象
 *
 * @author MrZhang
 * @since 2025-06-06 20:45
 */
@Schema(description ="活动类型查询对象")
@Getter
@Setter
public class ActivityTypeQuery extends BasePageQuery {

    @Schema(description = "活动类型名称")
    private String name;
    @Schema(description = "类型状态")
    private Boolean status;
}
