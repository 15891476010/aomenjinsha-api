package com.youlai.boot.index.model.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 前端用户表单对象
 *
 * @author MrZhang
 * @since 2025-05-24 14:47
 */
@Getter
@Setter
@Schema(description = "登录表单")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EbUserLoginRequest implements Serializable {

    @Schema(description = "用户名")
    @NotBlank(message = "用户名不能为空")
    @Size(max=255, message="用户名长度不能超过255个字符")
    private String username;

    @Schema(description = "密码")
    @NotBlank(message = "密码不能为空")
    @Size(max=255, message="密码长度不能超过255个字符")
    private String password;

    @Schema(description = "真实姓名")
    @Size(max=255, message="真实姓名长度不能超过255个字符")
    private String realName;

    @Schema(description = "验证码")
    @Size(max=255, message="验证码长度不能超过255个字符")
    private String captchaCode;

    @Schema(description = "验证码Key")
    private String captchaKey;
}
