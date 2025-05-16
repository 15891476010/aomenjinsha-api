package com.youlai.boot.system.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 组合分类数据视图对象
 *
 * @author MrZhang
 * @since 2025-05-15 00:48
 */
@Getter
@Setter
@Schema( description = "组合分类数据视图对象")
public class SysGroupDataVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "组合数据详情ID")
    private Integer id;
    @Schema(description = "对应的数据组id")
    private Integer gid;
    @Schema(description = "数据组对应的数据值（json数据）")
    private String value;
    @Schema(description = "数据排序")
    private Integer sort;
    @Schema(description = "状态（1：开启；2：关闭；）")
    private Boolean status;
    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
