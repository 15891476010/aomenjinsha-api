package com.youlai.boot.system.model.form;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

/**
 * 附件管理表单对象
 *
 * @author MrZhang
 * @since 2025-05-13 13:06
 */
@Getter
@Setter
@Schema(description = "附件管理表单对象")
public class AttachmentForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "附件名称")
    @Size(max=100, message="附件名称长度不能超过100个字符")
    private String name;

    @Schema(description = "附件路径")
    @Size(max=200, message="附件路径长度不能超过200个字符")
    private String attDir;

    @Schema(description = "压缩图片路径")
    @Size(max=200, message="压缩图片路径长度不能超过200个字符")
    private String sattDir;

    @Schema(description = "附件大小")
    @Size(max=30, message="附件大小长度不能超过30个字符")
    private String attSize;

    @Schema(description = "附件类型")
    @Size(max=30, message="附件类型长度不能超过30个字符")
    private String attType;

    @Schema(description = "分类ID")
    private Integer pid;

    @Schema(description = "图片上传类型")
    private Integer imageType;
}
