package com.youlai.boot.system.converter;

import org.mapstruct.Mapper;
import com.youlai.boot.system.model.entity.SysGroupData;
import com.youlai.boot.system.model.form.SysGroupDataForm;
import com.youlai.boot.system.model.vo.SysGroupDataVO;

import java.util.List;

/**
 * 组合分类数据对象转换器
 *
 * @author MrZhang
 * @since 2025-05-15 00:48
 */
@Mapper(componentModel = "spring")
public interface SysGroupDataConverter{

    SysGroupDataForm toForm(SysGroupData entity);

    SysGroupData toEntity(SysGroupDataForm formData);

    List<SysGroupDataVO> toVoList(List<SysGroupData> entityList);
}