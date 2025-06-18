package com.youlai.boot.recharge.controller;

import com.youlai.boot.recharge.service.RechargeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.recharge.model.form.RechargeCategoryForm;
import com.youlai.boot.recharge.model.query.RechargeCategoryQuery;
import com.youlai.boot.recharge.model.vo.RechargeCategoryVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.youlai.boot.common.result.PageResult;
import com.youlai.boot.common.result.Result;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

/**
 * 充值分类前端控制层
 *
 * @author MrZhang
 * @since 2025-05-29 00:00
 */
@Tag(name = "充值分类接口")
@RestController
@RequestMapping("/api/v1/recharge-category")
@RequiredArgsConstructor
public class RechargeCategoryController  {

    private final RechargeCategoryService rechargeCategoryService;

    @Operation(summary = "充值分类分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-category:query')")
    public PageResult<RechargeCategoryVO> getRechargeCategoryPage(RechargeCategoryQuery queryParams ) {
        IPage<RechargeCategoryVO> result = rechargeCategoryService.getRechargeCategoryPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增充值分类")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('recharge:recharge-category:add')")
    public Result<Void> saveRechargeCategory(@RequestBody @Valid RechargeCategoryForm formData ) {
        boolean result = rechargeCategoryService.saveRechargeCategory(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取充值分类表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-category:edit')")
    public Result<RechargeCategoryForm> getRechargeCategoryForm(
            @Parameter(description = "充值分类ID") @PathVariable Long id
    ) {
        RechargeCategoryForm formData = rechargeCategoryService.getRechargeCategoryFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改充值分类")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-category:edit')")
    public Result<Void> updateRechargeCategory(
            @Parameter(description = "充值分类ID") @PathVariable Long id,
            @RequestBody @Validated RechargeCategoryForm formData
    ) {
        boolean result = rechargeCategoryService.updateRechargeCategory(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除充值分类")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-category:delete')")
    public Result<Void> deleteRechargeCategorys(
            @Parameter(description = "充值分类ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = rechargeCategoryService.deleteRechargeCategorys(ids);
        return Result.judge(result);
    }

    @Operation(summary = "充值分类Options")
    @GetMapping("/options")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-category:query')")
    public Result<List<Map<String, Object>>> getRechargeCategoryOptions() {
        return Result.success(rechargeCategoryService.getRechargeCategoryOptions());
    }
}
