package com.youlai.boot.index.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.index.model.entity.Activite;
import com.youlai.boot.index.model.form.ActiviteForm;
import com.youlai.boot.index.model.vo.ActiviteVO;

import java.util.List;

/**
 * 活动表对象转换器
 *
 * @author MrZhang
 * @since 2025-06-06 21:09
 */
@Mapper(componentModel = "spring")
public interface ActiviteConverter{

    ActiviteForm toForm(Activite entity);

    Activite toEntity(ActiviteForm formData);

    List<ActiviteVO> toListEntity(List<Activite> entitys);
}