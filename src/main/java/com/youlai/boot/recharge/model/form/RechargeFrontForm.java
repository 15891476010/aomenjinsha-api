package com.youlai.boot.recharge.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 创建订单信息表单对象
 *
 * @author MrZhang
 * @since 2025-06-01 19:49
 */
@Getter
@Setter
@Schema(description = "创建订单信息表单对象")
public class RechargeFrontForm implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long threeId;
    private BigDecimal amount;
}
