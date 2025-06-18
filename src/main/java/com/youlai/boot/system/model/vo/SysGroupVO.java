package com.youlai.boot.system.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 组合数据分类视图对象
 *
 * @author MrZhang
 * @since 2025-05-15 00:13
 */
@Getter
@Setter
@Schema( description = "组合数据分类视图对象")
public class SysGroupVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "组合数据ID")
    private Integer id;
    @Schema(description = "数据组名称")
    private String name;
    @Schema(description = "简介")
    private String info;
    @Schema(description = "form 表单 id")
    private Integer formId;
    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
