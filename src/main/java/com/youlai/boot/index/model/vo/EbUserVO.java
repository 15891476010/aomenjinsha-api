package com.youlai.boot.index.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 前端用户视图对象
 *
 * @author MrZhang
 * @since 2025-05-24 14:47
 */
@Getter
@Setter
@Schema( description = "前端用户视图对象")
public class EbUserVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "前端用户表")
    private Integer id;
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
    @Schema(description = "最后一次登录ip")
    private String ip;
    @Schema(description = "余额")
    private BigDecimal balance;
    @Schema(description = "vip等级")
    private Integer vipLevel;
    @Schema(description = "账号状态")
    private Boolean status;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
