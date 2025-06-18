package com.youlai.boot.index.model.form;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

/**
 * 前端用户表单对象
 *
 * @author MrZhang
 * @since 2025-05-24 14:47
 */
@Getter
@Setter
@Schema(description = "前端用户表单对象")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EbUserForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "前端用户表")
    private Integer id;

    @Schema(description = "用户名")
    @NotBlank(message = "用户名不能为空")
    @Size(max=255, message="用户名长度不能超过255个字符")
    private String username;

    @Schema(description = "密码")
    @NotBlank(message = "密码不能为空")
    @Size(max=255, message="密码长度不能超过255个字符")
    private String password;

    @Schema(description = "昵称")
    @Size(max=255, message="昵称长度不能超过255个字符")
    private String nickName;

    @Schema(description = "真实姓名")
    @NotBlank(message = "真实姓名不能为空")
    @Size(max=255, message="真实姓名长度不能超过255个字符")
    private String realName;

    @Schema(description = "手机号")
    @NotBlank(message = "手机号不能为空")
    @Size(max=11, message="手机号不符合规范")
    private String phone;

    @Schema(description = "邮箱")
    @Size(max=255, message="邮箱长度不能超过255个字符")
    private String email;

    @Schema(description = "验证码")
    @Size(max=255, message="验证码长度不能超过255个字符")
    private String captchaCode;

    @Schema(description = "验证码Key")
    private String captchaKey;

    @Schema(description = "余额")
    private BigDecimal balance;

    /**
     * vip等级
     */
    @Schema(description = "vip等级")
    private Integer vipLevel;
}
