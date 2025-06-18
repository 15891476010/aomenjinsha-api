package com.youlai.boot.recharge.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 充值分类分页查询对象
 *
 * @author MrZhang
 * @since 2025-05-29 00:00
 */
@Schema(description ="充值分类查询对象")
@Getter
@Setter
public class RechargeCategoryQuery extends BasePageQuery {

    @Schema(description = "充值方式名称")
    private String name;
    @Schema(description = "当前充值方式是否在前端显示")
    private Boolean status;
}
