package com.youlai.boot.system.model.form;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 组合数据分类表单对象
 *
 * @author MrZhang
 * @since 2025-05-15 00:13
 */
@Getter
@Setter
@Schema(description = "组合数据分类表单对象")
public class SysGroupForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "组合数据ID")
    private Integer id;

    @Schema(description = "数据组名称")
    @NotBlank(message = "数据组名称不能为空")
    @Size(max=50, message="数据组名称长度不能超过50个字符")
    private String name;

    @Schema(description = "简介")
    @Size(max=256, message="简介长度不能超过256个字符")
    private String info;

    @Schema(description = "form 表单 id")
    @NotNull(message = "form 表单 id不能为空")
    private Integer formId;
}
