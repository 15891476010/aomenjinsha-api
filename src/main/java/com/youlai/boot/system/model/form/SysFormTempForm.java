package com.youlai.boot.system.model.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Schema(description = "表单模板表单对象")
public class SysFormTempForm implements Serializable {
    @Schema(description = "表单模板id")
    private Integer id;

    @Schema(description = "表单名称")
    @NotBlank(message = "表单名称不能为空")
    @Size(max=500, message="表单名称长度不能超过500个字符")
    private String name;

    @Schema(description = "表单简介")
    @NotBlank(message = "表单简介不能为空")
    @Size(max=500, message="表单简介长度不能超过500个字符")
    private String info;

    @Schema(description = "表单内容")
    @NotBlank(message = "表单内容不能为空")
    @Size(max=65535, message="表单内容长度不能超过65535个字符")
    private String content;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updateTime;
}
