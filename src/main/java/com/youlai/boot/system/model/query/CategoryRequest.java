package com.youlai.boot.system.model.query;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Category对象", description="分类表")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryRequest implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "父级ID")
    @NotNull(message = "请选择父级分类")
    @Min(value = 0, message = "请选择父级分类")
    private Integer pid;

    @ApiModelProperty(value = "分类名称")
    @NotBlank(message = "分类名称必须填写")
    @Length(max = 50, message = "分类名称不能超过50个字符")
    private String name;

    @ApiModelProperty(value = "类型，类型，1 产品分类，2 附件分类，3 文章分类， 4 设置分类， 5 菜单分类， 6 配置分类， 7 秒杀配置")
    @NotNull(message = "类型必须选择")
    @Range( message = "类型，1 产品分类，2 附件分类，3 文章分类， 4 设置分类， 5 菜单分类， 6 配置分类， 7 秒杀配置之间") //取值范围
    private Integer type;

    @ApiModelProperty(value = "地址")
//    @NotBlank(message = "地址名称必须填写")
    private String url;

    @ApiModelProperty(value = "扩展字段")
    private String extra;

    @ApiModelProperty(value = "状态, 0正常，1失效")
    @NotNull(message = "状态必须选择")
    private Boolean status;

    @ApiModelProperty(value = "排序")
    @NotNull(message = "排序数字为空")  //不可为空
    @Min(value = 0, message = "排序数字必须大于等于0") //数字最小值为0
    private Integer sort;

}
