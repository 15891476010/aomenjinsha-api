package com.youlai.boot.index.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 活动表视图对象
 *
 * @author MrZhang
 * @since 2025-06-06 21:09
 */
@Getter
@Setter
@Schema( description = "活动表视图对象")
public class ActiviteVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Integer id;
    @Schema(description = "标题")
    private String title;
    @Schema(description = "活动图片")
    private String image;
    @Schema(description = "是否可以申请")
    private Boolean canApply;
    @Schema(description = "状态")
    private Boolean status;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "内容")
    private String content;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
