package com.youlai.boot.system.converter;

import com.youlai.boot.system.model.entity.Category;
import com.youlai.boot.system.model.query.CategoryRequest;
import com.youlai.boot.system.model.vo.CategoryTreeVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryConverter {
    Category categoryRequestToCategory(CategoryRequest categoryRequest);
    List<CategoryTreeVo> toTreeVo(List<Category> categories);
}
