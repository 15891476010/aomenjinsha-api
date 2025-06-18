package com.youlai.boot.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.boot.system.model.entity.Category;
import com.youlai.boot.system.model.query.CategoryRequest;
import com.youlai.boot.system.model.vo.CategoryTreeVo;

import java.util.List;

public interface CategoryService extends IService<Category> {
    /**
     * 新增分类
     * @param categoryRequest
     * @return
     */
    Boolean create(CategoryRequest categoryRequest);

    /**
     * 带结构的无限分类
     */
    List<CategoryTreeVo> getTree(Integer type, Boolean status,String name, List<Integer> categoryIdList);

    List<CategoryTreeVo> getListTree(Integer type, Boolean status,String name);

    /**
     * 修改分类
     */
    Integer updateCategory(CategoryRequest categoryRequest);

    Boolean deleteCategory(Integer id);

    /**
     * 关联表单
     */
    Boolean bindForm(Integer categoryId, String formId);
}
