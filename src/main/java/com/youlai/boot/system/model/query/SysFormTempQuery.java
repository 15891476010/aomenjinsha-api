package com.youlai.boot.system.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 表单模板分页查询对象
 *
 * @author MrZhang
 * @since 2025-05-07 15:40
 */
@EqualsAndHashCode(callSuper = true)
@Schema(description ="表单模板查询对象")
@Data
public class SysFormTempQuery extends BasePageQuery {

    @Schema(description = "表单模板id")
    private Integer id;
    @Schema(description = "表单名称")
    private String name;
}
