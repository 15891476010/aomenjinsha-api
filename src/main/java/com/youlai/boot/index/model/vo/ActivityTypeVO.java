package com.youlai.boot.index.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 活动类型视图对象
 *
 * @author MrZhang
 * @since 2025-06-06 20:42
 */
@Getter
@Setter
@Schema( description = "活动类型视图对象")
public class ActivityTypeVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "活动类型id")
    private Integer id;
    @Schema(description = "活动类型名称")
    private String name;
    @Schema(description = "类型状态")
    private Boolean status;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
