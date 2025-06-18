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
 * 用户活动申请表单对象
 *
 * @author MrZhang
 * @since 2025-06-07 15:34
 */
@Getter
@Setter
@Schema(description = "用户活动申请表单对象")
public class ActiviteApplyForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Integer id;

    @Schema(description = "活动id")
    private Integer activiteId;

    @Schema(description = "用户id")
    private Integer userId;

    @Schema(description = "申请状态")
    private Integer status;

    @Schema(description = "排序")
    private Integer sort;


}
