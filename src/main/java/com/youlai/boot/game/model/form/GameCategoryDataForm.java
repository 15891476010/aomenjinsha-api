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
 * 游戏列表单对象
 *
 * @author MrZhang
 * @since 2025-05-18 19:33
 */
@Getter
@Setter
@Schema(description = "游戏列表单对象")
public class GameCategoryDataForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "游戏id")
    private Integer id;

    @Schema(description = "游戏分类id")
    @NotNull(message = "游戏分类id不能为空")
    private Integer pid;

    @Schema(description = "游戏标题")
    @Size(max=255, message="游戏标题长度不能超过255个字符")
    private String title;

    @Schema(description = "游戏图标")
    @Size(max=255, message="游戏图标长度不能超过255个字符")
    private String icon;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "状态")
    private Boolean status;

    @Schema(description = "跳转链接")
    @Size(max=255, message="跳转链接长度不能超过255个字符")
    private String targetUrl;

    @Schema(description = "描述标签")
    private String tag;

    private Boolean isHot;

    /**
     * 供应商id
     */
    private String provider;
}
