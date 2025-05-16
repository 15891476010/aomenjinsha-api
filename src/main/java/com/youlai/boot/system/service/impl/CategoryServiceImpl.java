package com.youlai.boot.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.common.exception.UsdtException;
import com.youlai.boot.system.converter.CategoryConverter;
import com.youlai.boot.system.mapper.CategoryMapper;
import com.youlai.boot.system.model.entity.Category;
import com.youlai.boot.system.model.query.CategoryRequest;
import com.youlai.boot.system.model.vo.CategoryTreeVo;
import com.youlai.boot.system.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryConverter categoryConverter;
    @Override
    public Boolean create(CategoryRequest categoryRequest) {
        //检测标题是否存在
        if(checkName(categoryRequest.getName()) > 0){
            throw new UsdtException("此分类已存在");
        }
        Category category = categoryConverter.categoryRequestToCategory(categoryRequest);
        category.setPath(getPathByPId(category.getPid()));
        return save(category);
    }

    @Override
    public List<CategoryTreeVo> getTree(Integer type, Boolean status, String name, List<Integer> categoryIdList) {
        // 构建查询条件
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ObjectUtil.isNotNull(type), Category::getType, type)
                .in(CollectionUtil.isNotEmpty(categoryIdList), Category::getId, categoryIdList)
                .eq(ObjectUtil.isNotNull(status), Category::getStatus, status)
                .like(ObjectUtil.isNotEmpty(name), Category::getName, name)
                .orderByAsc(Category::getSort);

        // 查询分类列表
        List<Category> categories = baseMapper.selectList(wrapper);
        if (CollectionUtil.isEmpty(categories)) {
            return Collections.emptyList();
        }

        // 处理名称搜索时的父级分类
        if (ObjectUtil.isNotEmpty(name)) {
            Set<Integer> existingIds = categories.stream()
                    .map(Category::getId)
                    .collect(Collectors.toSet());

            List<Integer> parentIds = categories.stream()
                    .filter(c -> c.getPid() > 0 && !existingIds.contains(c.getPid()))
                    .map(Category::getPid)
                    .distinct()
                    .collect(Collectors.toList());

            if (CollectionUtil.isNotEmpty(parentIds)) {
                List<Category> parents = baseMapper.selectBatchIds(parentIds);
                categories.addAll(parents);
            }
        }

        // 转换为树形结构
        List<CategoryTreeVo> treeVos = categoryConverter.toTreeVo(categories);
        Map<Integer, CategoryTreeVo> voMap = treeVos.stream()
                .collect(Collectors.toMap(CategoryTreeVo::getId, Function.identity()));

        treeVos.forEach(vo -> {
            if (vo.getPid() > 0) {
                CategoryTreeVo parent = voMap.get(vo.getPid());
                if (parent != null) {
                    parent.getChild().add(vo);
                }
            }
        });

        // 返回顶级节点
        return treeVos.stream()
                .filter(vo -> vo.getPid() <= 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryTreeVo> getListTree(Integer type, Boolean status, String name) {
        return getTree(type, status, name, null);
    }

    @Override
    public Integer updateCategory(CategoryRequest categoryRequest) {
        Category category = categoryConverter.categoryRequestToCategory(categoryRequest);
        category.setPath(getPathByPId(category.getPid()));
        return baseMapper.updateById(category);
    }

    @Override
    public Boolean deleteCategory(Integer id) {
        return removeById(id);
    }

    @Override
    public Boolean bindForm(Integer categoryId, String formId) {
        if (!formId.isEmpty()) {
            LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Category::getExtra, formId);
            List<Category> categories = baseMapper.selectList(wrapper);
            if (CollectionUtil.isNotEmpty(categories)) {
                throw new UsdtException("该表单已被'" + categories.get(0).getName() + "'分类关联,请先在关联表单中取消关联");
            }
        }
        Category category = new Category();
        category.setExtra(formId);
        category.setId(categoryId);
        return updateById(category);
    }

    private int checkName(String name) {
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Category::getName, name);
        return Math.toIntExact(baseMapper.selectCount(lambdaQueryWrapper));
    }

    private String getPathByPId(Integer pid) {
        Category category = getById(pid);
        if(null != category){
            return category.getPath() + pid + "/";
        }
        return null;
    }
}
