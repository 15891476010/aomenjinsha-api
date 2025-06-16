package com.youlai.boot.index.controller;

import com.youlai.boot.index.service.ActiviteApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.index.model.form.ActiviteApplyForm;
import com.youlai.boot.index.model.query.ActiviteApplyQuery;
import com.youlai.boot.index.model.vo.ActiviteApplyVO;
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
 * 用户活动申请前端控制层
 *
 * @author MrZhang
 * @since 2025-06-07 15:34
 */
@Tag(name = "用户活动申请接口")
@RestController
@RequestMapping("/api/v1/activite-apply")
@RequiredArgsConstructor
public class ActiviteApplyController  {

    private final ActiviteApplyService activiteApplyService;

    @Operation(summary = "用户活动申请分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('index:activite-apply:query')")
    public PageResult<ActiviteApplyVO> getActiviteApplyPage(ActiviteApplyQuery queryParams ) {
        IPage<ActiviteApplyVO> result = activiteApplyService.getActiviteApplyPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增用户活动申请")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('index:activite-apply:add')")
    public Result<Void> saveActiviteApply(@RequestBody @Valid ActiviteApplyForm formData ) {
        boolean result = activiteApplyService.saveActiviteApply(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取用户活动申请表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('index:activite-apply:edit')")
    public Result<ActiviteApplyForm> getActiviteApplyForm(
            @Parameter(description = "用户活动申请ID") @PathVariable Long id
    ) {
        ActiviteApplyForm formData = activiteApplyService.getActiviteApplyFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改用户活动申请")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('index:activite-apply:edit')")
    public Result<Void> updateActiviteApply(
            @Parameter(description = "用户活动申请ID") @PathVariable Long id,
            @RequestBody @Validated ActiviteApplyForm formData
    ) {
        boolean result = activiteApplyService.updateActiviteApply(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除用户活动申请")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('index:activite-apply:delete')")
    public Result<Void> deleteActiviteApplys(
            @Parameter(description = "用户活动申请ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = activiteApplyService.deleteActiviteApplys(ids);
        return Result.judge(result);
    }
}
