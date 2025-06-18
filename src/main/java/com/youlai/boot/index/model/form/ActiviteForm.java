package com.youlai.boot.index.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

/**
 * 活动表表单对象
 *
 * @author MrZhang
 * @since 2025-06-06 21:09
 */
@Getter
@Setter
@Schema(description = "活动表表单对象")
public class ActiviteForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Integer id;

    @Schema(description = "活动类型")
    @NotNull(message = "活动类型不能为空")
    private Integer pid;

    @Schema(description = "标题")
    @Size(max=255, message="标题长度不能超过255个字符")
    private String title;

    @Schema(description = "内容")
    @NotNull(message = "内容不能为空")
    private String content;

    @Schema(description = "活动图片")
    @Size(max=255, message="活动图片长度不能超过255个字符")
    private String image;

    @Schema(description = "是否可以申请")
    private Boolean canApply;

    @Schema(description = "状态")
    private Boolean status;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;


}
