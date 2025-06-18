package com.youlai.boot.system.converter;

import com.youlai.boot.system.model.vo.SysFormTempVO;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.model.entity.SysFormTemp;
import com.youlai.boot.system.model.form.SysFormTempForm;

/**
 * 表单模板对象转换器
 *
 * @author MrZhang
 * @since 2025-05-07 15:40
 */
@Mapper(componentModel = "spring")
public interface SysFormTempConverter{

    SysFormTempForm toForm(SysFormTemp entity);

    SysFormTemp toEntity(SysFormTempForm formData);

    SysFormTempVO toVO(SysFormTemp entity);
}