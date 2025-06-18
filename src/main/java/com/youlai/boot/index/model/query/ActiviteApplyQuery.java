package com.youlai.boot.index.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户活动申请分页查询对象
 *
 * @author MrZhang
 * @since 2025-06-07 15:34
 */
@Schema(description ="用户活动申请查询对象")
@Getter
@Setter
public class ActiviteApplyQuery extends BasePageQuery {

    @Schema(description = "申请状态")
    private Integer status;
}
