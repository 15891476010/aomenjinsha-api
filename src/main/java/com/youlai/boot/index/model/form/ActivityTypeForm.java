package com.youlai.boot.index.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Size;

/**
 * 活动类型表单对象
 *
 * @author MrZhang
 * @since 2025-06-06 20:42
 */
@Getter
@Setter
@Schema(description = "活动类型表单对象")
public class ActivityTypeForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "活动类型id")
    private Integer id;

    @Schema(description = "活动类型名称")
    @Size(max=255, message="活动类型名称长度不能超过255个字符")
    private String name;

    @Schema(description = "类型状态")
    private Boolean status;

    @Schema(description = "排序")
    private Integer sort;


}
