package com.youlai.boot.recharge.controller;

import com.youlai.boot.recharge.service.RechargeListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.recharge.model.form.RechargeListForm;
import com.youlai.boot.recharge.model.query.RechargeListQuery;
import com.youlai.boot.recharge.model.vo.RechargeListVO;
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
 * 用户充值列表前端控制层
 *
 * @author MrZhang
 * @since 2025-06-01 19:49
 */
@Tag(name = "用户充值列表接口")
@RestController
@RequestMapping("/api/v1/recharge-list")
@RequiredArgsConstructor
public class RechargeListController  {

    private final RechargeListService rechargeListService;

    @Operation(summary = "用户充值列表分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-list:query')")
    public PageResult<RechargeListVO> getRechargeListPage(RechargeListQuery queryParams ) {
        IPage<RechargeListVO> result = rechargeListService.getRechargeListPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增用户充值列表")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('recharge:recharge-list:add')")
    public Result<Void> saveRechargeList(@RequestBody @Valid RechargeListForm formData ) {
        boolean result = rechargeListService.saveRechargeList(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取用户充值列表表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-list:edit')")
    public Result<RechargeListForm> getRechargeListForm(
            @Parameter(description = "用户充值列表ID") @PathVariable Long id
    ) {
        RechargeListForm formData = rechargeListService.getRechargeListFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改用户充值列表")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-list:edit')")
    public Result<Void> updateRechargeList(
            @Parameter(description = "用户充值列表ID") @PathVariable Long id,
            @RequestBody @Validated RechargeListForm formData
    ) {
        boolean result = rechargeListService.updateRechargeList(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除用户充值列表")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-list:delete')")
    public Result<Void> deleteRechargeLists(
            @Parameter(description = "用户充值列表ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = rechargeListService.deleteRechargeLists(ids);
        return Result.judge(result);
    }
}
