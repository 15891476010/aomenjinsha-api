package com.youlai.boot.system.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 组合分类数据分页查询对象
 *
 * @author MrZhang
 * @since 2025-05-15 00:48
 */
@Schema(description ="组合分类数据查询对象")
@Getter
@Setter
public class SysGroupDataQuery extends BasePageQuery {
    private Integer gid;
    private Boolean status;
}
