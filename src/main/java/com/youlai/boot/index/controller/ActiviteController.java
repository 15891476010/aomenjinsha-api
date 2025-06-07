package com.youlai.boot.index.controller;

import com.youlai.boot.index.service.ActiviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.index.model.form.ActiviteForm;
import com.youlai.boot.index.model.query.ActiviteQuery;
import com.youlai.boot.index.model.vo.ActiviteVO;
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

/**
 * 活动表前端控制层
 *
 * @author MrZhang
 * @since 2025-06-06 21:09
 */
@Tag(name = "活动表接口")
@RestController
@RequestMapping("/api/v1/activite")
@RequiredArgsConstructor
public class ActiviteController  {

    private final ActiviteService activiteService;

    @Operation(summary = "活动表分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('index:activite:query')")
    public PageResult<ActiviteVO> getActivitePage(ActiviteQuery queryParams ) {
        IPage<ActiviteVO> result = activiteService.getActivitePage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增活动表")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('index:activite:add')")
    public Result<Void> saveActivite(@RequestBody @Valid ActiviteForm formData ) {
        boolean result = activiteService.saveActivite(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取活动表表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('index:activite:edit')")
    public Result<ActiviteForm> getActiviteForm(
            @Parameter(description = "活动表ID") @PathVariable Long id
    ) {
        ActiviteForm formData = activiteService.getActiviteFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改活动表")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('index:activite:edit')")
    public Result<Void> updateActivite(
            @Parameter(description = "活动表ID") @PathVariable Long id,
            @RequestBody @Validated ActiviteForm formData
    ) {
        boolean result = activiteService.updateActivite(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除活动表")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('index:activite:delete')")
    public Result<Void> deleteActivites(
            @Parameter(description = "活动表ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = activiteService.deleteActivites(ids);
        return Result.judge(result);
    }
}
