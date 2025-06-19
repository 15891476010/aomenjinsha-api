package com.youlai.boot.game.model.form;

import java.io.Serial;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

/**
 * 游戏平台列表表单对象
 *
 * @author MrZhang
 * @since 2025-06-15 18:49
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

    @Schema(description = "支持的币种")
    @NotEmpty(message = "支持的币种不能为空")
    private List<String> currencys;

    @Schema(description = "支持的游戏类型")
    @NotEmpty(message = "支持的游戏类型不能为空")
    private List<Integer> gameType;

    @Schema(description = "游戏代码")
    @Size(max=255, message="游戏代码长度不能超过255个字符")
    private String gameCode;

    @Schema(description = "游戏素材")
    @Size(max=255, message="游戏素材长度不能超过255个字符")
    private String gameMaterial;

    @Schema(description = "游戏素材账号")
    @Size(max=255, message="游戏素材账号长度不能超过255个字符")
    private String materialAccount;

    @Schema(description = "游戏素材密码")
    @Size(max=255, message="游戏素材密码长度不能超过255个字符")
    private String materialPwd;

    @Schema(description = "平台图标")
    @Size(max=255, message="平台图标长度不能超过255个字符")
    private String icon;

    @Schema(description = "状态(是否维修)")
    private Boolean status;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "平台图标")
    private String smallIcon;

}
