package com.youlai.boot.common.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 基础分页请求对象
 *
 * @author haoxr
 * @since 2021/2/28
 */
@Data
@Schema
public class PageQueryParams<T> implements Serializable {

    @Schema(description = "页码", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private int pageNum = 1;

    @Schema(description = "每页记录数", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private int pageSize = 10;

    @Schema(description = "请求参数")
    private T data;
}
