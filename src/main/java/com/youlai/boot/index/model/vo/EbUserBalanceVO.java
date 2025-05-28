package com.youlai.boot.index.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 前端用户视图对象
 *
 * @author MrZhang
 * @since 2025-05-24 14:47
 */
@Getter
@Setter
@Schema( description = "前端用户视图对象")
public class EbUserBalanceVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "前端用户表")
    private Integer id;
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "昵称")
    private String nickName;
    @Schema(description = "余额")
    private BigDecimal balance;
}
