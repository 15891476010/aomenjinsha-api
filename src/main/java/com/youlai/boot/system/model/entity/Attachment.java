package com.youlai.boot.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 附件管理实体对象
 *
 * @author MrZhang
 * @since 2025-05-13 13:06
 */
@Getter
@Setter
@TableName("sys_attachment")
public class Attachment extends BaseEntity {
    /**
     * 附件名称
     */
    private String name;
    /**
     * 附件路径
     */
    private String attDir;
    /**
     * 压缩图片路径
     */
    private String sattDir;
    /**
     * 附件大小
     */
    private String attSize;
    /**
     * 附件类型
     */
    private String attType;
    /**
     * 分类ID
     */
    private Integer pid;
    /**
     * 图片上传类型
     */
    private Integer imageType;
}
