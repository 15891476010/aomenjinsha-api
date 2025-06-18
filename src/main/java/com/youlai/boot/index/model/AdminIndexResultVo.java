package com.youlai.boot.index.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "管理端全局配置字段返回对象")
public class AdminIndexResultVo {
    @Schema(description = "所有图片请求前缀")
    private String imagePrefix;
}
