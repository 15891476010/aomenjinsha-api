package com.youlai.boot.index.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 活动表分页查询对象
 *
 * @author MrZhang
 * @since 2025-06-06 21:09
 */
@Schema(description ="活动表查询对象")
@Getter
@Setter
public class ActiviteQuery extends BasePageQuery {

    @Schema(description = "活动类型")
    private Integer pid;
    @Schema(description = "标题")
    private String title;
    @Schema(description = "是否可以申请")
    private Boolean canApply;
    @Schema(description = "状态")
    private Boolean status;
}
