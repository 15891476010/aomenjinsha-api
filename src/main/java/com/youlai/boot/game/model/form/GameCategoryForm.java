package com.youlai.boot.game.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

/**
 * 游戏分类表单对象
 *
 * @author MrZhang
 * @since 2025-05-18 16:38
 */
@Getter
@Setter
@Schema(description = "游戏分类表单对象")
public class GameCategoryForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "游戏id")
    private Integer id;

    @Schema(description = "游戏分类名称")
    @Size(max=255, message="游戏分类名称长度不能超过255个字符")
    private String title;

    @Schema(description = "游戏分类图标")
    private String icon;
    @Schema(description = "未选中时游戏分类图标")
    private String noIcon;


    @Schema(description = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @Schema(description = "显示状态")
    private Boolean status;

    private Integer sort;
}
