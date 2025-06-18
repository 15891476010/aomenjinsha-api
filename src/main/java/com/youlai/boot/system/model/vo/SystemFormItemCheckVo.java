package com.youlai.boot.system.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SystemFormItemCheckRequest对象", description="表单字段明细")
public class SystemFormItemCheckVo {

    @ApiModelProperty(value = "字段名称", required = true)
    private String name;

    @ApiModelProperty(value = "字段值", required = true)
    private String value;

    @ApiModelProperty(value = "字段显示文字", required = true)
    private String title;
}
