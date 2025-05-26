package com.youlai.boot.index.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 前端用户视图对象
 *
 * @author MrZhang
 * @since 2025-05-24 14:47
 */
@Getter
@Setter
@Schema( description = "前端用户视图对象")
public class EbUserFrontVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户名")
    private String username;
    @Schema(description = "昵称")
    private String nickName;
    @Schema(description = "头像")
    private String avatar;
    @Schema(description = "真实姓名")
    private String realName;
    @Schema(description = "手机号")
    private String phone;
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "国家")
    private String county;
    @Schema(description = "余额")
    private BigDecimal balance;
}
