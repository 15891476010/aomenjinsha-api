package com.youlai.boot.system.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 组合分类数据表单对象
 *
 * @author MrZhang
 * @since 2025-05-15 00:48
 */
@Getter
@Setter
@Schema(description = "组合分类数据表单对象")
public class SysGroupDataForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "组合数据详情ID")
    private Integer id;

    @Schema(description = "对应的数据组id")
    @NotNull(message = "对应的数据组id不能为空")
    private Integer gid;

    @Schema(description = "数据组对应的数据值（json数据）")
    @NotBlank(message = "数据组对应的数据值（json数据）不能为空")
    private String value;

    @Schema(description = "数据排序")
    @NotNull(message = "数据排序不能为空")
    private Integer sort;

    @Schema(description = "状态（1：开启；2：关闭；）")
    @NotNull(message = "状态（1：开启；2：关闭；）不能为空")
    private Boolean status;


}
