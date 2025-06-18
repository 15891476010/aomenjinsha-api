package com.youlai.boot.system.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 附件管理视图对象
 *
 * @author MrZhang
 * @since 2025-05-13 13:06
 */
@Getter
@Setter
@Schema( description = "附件管理视图对象")
public class AttachmentVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer attId;
    @Schema(description = "附件名称")
    private String name;
    @Schema(description = "附件路径")
    private String attDir;
    @Schema(description = "压缩图片路径")
    private String sattDir;
    @Schema(description = "附件大小")
    private String attSize;
    @Schema(description = "附件类型")
    private String attType;
    @Schema(description = "分类ID")
    private Integer pid;
    @Schema(description = "图片上传类型")
    private Integer imageType;
    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
