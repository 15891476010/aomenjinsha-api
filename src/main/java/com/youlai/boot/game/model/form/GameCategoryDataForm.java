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
 * @since 2025-06-18 18:11
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

    @Schema(description = "描述标签")
    @Size(max=255, message="描述标签长度不能超过255个字符")
    private String tag;

    @Schema(description = "是否热门")
    private Boolean isHot;

    @Schema(description = "游戏平台")
    @Size(max=255, message="游戏平台长度不能超过255个字符")
    private String platType;

    @Schema(description = "简体中文")
    @Size(max=255, message="简体中文长度不能超过255个字符")
    private String zhHans;

    @Schema(description = "繁体中文")
    @Size(max=255, message="繁体中文长度不能超过255个字符")
    private String zhHant;

    @Schema(description = "英语")
    @Size(max=255, message="英语长度不能超过255个字符")
    private String en;

    @Schema(description = "支持终端类型，1:电脑网页、2:手机网页、3:电脑/手机网页")
    private Integer ingress;

    @Schema(description = "跳转链接")
    @Size(max=255, message="跳转链接长度不能超过255个字符")
    private String gameCode;

    @Schema(description = "供应商")
    @Size(max=255, message="供应商长度不能超过255个字符")
    private String provider;


}
