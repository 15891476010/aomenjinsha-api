package com.youlai.boot.system.converter;

import org.mapstruct.Mapper;
import com.youlai.boot.system.model.entity.Attachment;
import com.youlai.boot.system.model.form.AttachmentForm;

/**
 * 附件管理对象转换器
 *
 * @author MrZhang
 * @since 2025-05-13 13:06
 */
@Mapper(componentModel = "spring")
public interface AttachmentConverter{

    AttachmentForm toForm(Attachment entity);

    Attachment toEntity(AttachmentForm formData);
}