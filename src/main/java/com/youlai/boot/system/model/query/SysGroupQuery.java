package com.youlai.boot.system.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 组合数据分类分页查询对象
 *
 * @author MrZhang
 * @since 2025-05-15 00:13
 */
@Schema(description ="组合数据分类查询对象")
@Getter
@Setter
public class SysGroupQuery extends BasePageQuery {
}
