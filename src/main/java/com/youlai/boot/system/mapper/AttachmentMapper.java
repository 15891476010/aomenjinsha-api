package com.youlai.boot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.system.model.entity.Attachment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 附件管理Mapper接口
 *
 * @author MrZhang
 * @since 2025-05-13 13:06
 */
@Mapper
public interface AttachmentMapper extends BaseMapper<Attachment> {

}
