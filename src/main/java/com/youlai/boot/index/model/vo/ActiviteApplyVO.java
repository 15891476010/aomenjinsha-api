package com.youlai.boot.index.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 用户活动申请视图对象
 *
 * @author MrZhang
 * @since 2025-06-07 15:34
 */
@Getter
@Setter
@Schema( description = "用户活动申请视图对象")
public class ActiviteApplyVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Integer id;
    @Schema(description = "活动id")
    private Integer activiteId;
    @Schema(description = "活动名称")
    private String activiteName;
    @Schema(description = "用户id")
    private Integer userId;
    @Schema(description = "用户名称")
    private String username;
    @Schema(description = "申请状态")
    private Integer status;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
