package com.youlai.boot.system.converter;

import com.youlai.boot.system.model.vo.SysGroupVO;
import org.mapstruct.Mapper;
import com.youlai.boot.system.model.entity.SysGroup;
import com.youlai.boot.system.model.form.SysGroupForm;

import java.util.List;

/**
 * 组合数据分类对象转换器
 *
 * @author MrZhang
 * @since 2025-05-15 00:13
 */
@Mapper(componentModel = "spring")
public interface SysGroupConverter{

    SysGroupForm toForm(SysGroup entity);

    SysGroup toEntity(SysGroupForm formData);

    List<SysGroupVO> toVoList(List<SysGroup> entityList);
}