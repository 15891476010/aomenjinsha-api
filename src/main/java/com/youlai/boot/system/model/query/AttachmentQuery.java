package com.youlai.boot.system.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 附件管理分页查询对象
 *
 * @author MrZhang
 * @since 2025-05-13 13:06
 */
@Schema(description ="附件管理查询对象")
@Getter
@Setter
public class AttachmentQuery extends BasePageQuery {
    @Schema(description = "分类ID")
    private Integer pid;

    @Schema(description = "文件名称")
    private String name;
}
