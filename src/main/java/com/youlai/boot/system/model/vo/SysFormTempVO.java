package com.youlai.boot.system.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 表单模板视图对象
 *
 * @author MrZhang
 * @since 2025-05-07 15:40
 */
@Getter
@Setter
@Schema( description = "表单模板视图对象")
public class SysFormTempVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "表单模板id")
    private Integer id;
    @Schema(description = "表单名称")
    private String name;
    @Schema(description = "表单简介")
    private String info;
    @Schema(description = "表单内容")
    private String content;
    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updateTime;
}
