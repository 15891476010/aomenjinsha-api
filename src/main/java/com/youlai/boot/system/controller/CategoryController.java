package com.youlai.boot.system.controller;

import com.youlai.boot.common.annotation.Log;
import com.youlai.boot.common.enums.LogModuleEnum;
import com.youlai.boot.common.result.Result;
import com.youlai.boot.system.model.query.CategoryRequest;
import com.youlai.boot.system.model.vo.CategoryTreeVo;
import com.youlai.boot.system.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "12.配置分类")
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "新增配置分类")
    @PostMapping("/add")
    @PreAuthorize("@ss.hasPerm('sys:config:add')")
    @Log( value = "新增配置分类",module = LogModuleEnum.CATEGORY)
    public Result<?> save(@RequestBody CategoryRequest categoryRequest) {
        return Result.judge(categoryService.create(categoryRequest));
    }

    @Operation(summary = "获取tree结构的列表")
    @GetMapping("/tree")
    @PreAuthorize("@ss.hasPerm('sys:config:list')")
    public Result<List<CategoryTreeVo>> getListTree(@RequestParam(name = "type", required = false) Integer type,
                                                    @RequestParam(name = "status", required = false) Boolean status,
                                                    @RequestParam(name = "name", required = false) String name) {
        return Result.success(categoryService.getListTree(type, status, name));
    }

    /**
     * 修改
     */
    @Operation(summary = "修改配置分类")
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPerm('sys:config:update')")
    @Log( value = "修改配置分类",module = LogModuleEnum.CATEGORY)
    public Result<?> update(@RequestBody CategoryRequest categoryRequest) {
        System.out.println("修改配置分类");
        System.out.println(categoryRequest);
        return Result.judge(categoryService.updateCategory(categoryRequest) > 0);
    }

    @Operation(summary = "删除配置分类")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("@ss.hasPerm('sys:config:delete')")
    @Log( value = "删除配置分类",module = LogModuleEnum.CATEGORY)
    public Result<?> delete(@PathVariable Integer id) {
        return Result.judge(categoryService.deleteCategory(id));
    }

    @Operation(summary = "绑定表单")
    @GetMapping("/bindForm")
    @PreAuthorize("@ss.hasPerm('sys:config:bind-form')")
    @Log( value = "绑定表单",module = LogModuleEnum.CATEGORY)
    public Result<?> bindForm(@RequestParam Integer categoryId,
                              @RequestParam(value = "formId", required = false) String formId) {
        return Result.judge(categoryService.bindForm(categoryId, formId));
    }
}
