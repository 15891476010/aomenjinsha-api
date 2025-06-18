package com.youlai.boot.index.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.index.model.entity.ActiviteApply;
import com.youlai.boot.index.model.form.ActiviteApplyForm;
import com.youlai.boot.index.model.vo.ActiviteApplyVO;

import java.util.List;

/**
 * 用户活动申请对象转换器
 *
 * @author MrZhang
 * @since 2025-06-07 15:34
 */
@Mapper(componentModel = "spring")
public interface ActiviteApplyConverter{

    ActiviteApplyForm toForm(ActiviteApply entity);

    ActiviteApply toEntity(ActiviteApplyForm formData);

    List<ActiviteApplyVO> toListEntity(List<ActiviteApply> entitys);
}