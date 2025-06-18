package com.youlai.boot.index.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.index.model.entity.ActivityType;
import com.youlai.boot.index.model.form.ActivityTypeForm;
import com.youlai.boot.index.model.vo.ActivityTypeVO;

import java.util.List;

/**
 * 活动类型对象转换器
 *
 * @author MrZhang
 * @since 2025-06-06 20:45
 */
@Mapper(componentModel = "spring")
public interface ActivityTypeConverter{

    ActivityTypeForm toForm(ActivityType entity);

    ActivityType toEntity(ActivityTypeForm formData);

    List<ActivityTypeVO> toListEntity(List<ActivityType> entitys);
}