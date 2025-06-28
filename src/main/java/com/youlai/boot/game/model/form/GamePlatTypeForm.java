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
 * 游戏平台列表表单对象
 *
 * @author MrZhang
 * @since 2025-06-27 14:55
 */
@Getter
@Setter
@Schema(description = "游戏平台列表表单对象")
public class GamePlatTypeForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Integer id;

    @Schema(description = "平台名称")
    @NotBlank(message = "平台名称不能为空")
    @Size(max=255, message="平台名称长度不能超过255个字符")
    private String platTypeName;

    @Schema(description = "平台参数")
    @NotBlank(message = "平台参数不能为空")
    @Size(max=255, message="平台参数长度不能超过255个字符")
    private String platType;

    @Schema(description = "游戏类型")
    @NotNull(message = "游戏类型不能为空")
    private Integer gameType;

    @Schema(description = "游戏代码")
    @Size(max=255, message="游戏代码长度不能超过255个字符")
    private String gameCode;

    @Schema(description = "副标题")
    @Size(max=255, message="副标题长度不能超过255个字符")
    private String subName;

    @Schema(description = "小图标")
    @Size(max=255, message="小图标长度不能超过255个字符")
    private String smallIcon;

    @Schema(description = "手机图标")
    @Size(max=255, message="手机图标长度不能超过255个字符")
    private String icon;

    @Schema(description = "是否显示标题")
    private Boolean isShowTitle;

    @Schema(description = "状态")
    private Boolean status;

    @Schema(description = "排序")
    private Integer sort;


}
