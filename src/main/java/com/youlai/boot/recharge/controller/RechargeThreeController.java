package com.youlai.boot.recharge.controller;

import com.youlai.boot.recharge.service.RechargeThreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.recharge.model.form.RechargeThreeForm;
import com.youlai.boot.recharge.model.query.RechargeThreeQuery;
import com.youlai.boot.recharge.model.vo.RechargeThreeVO;
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
 * 充值三级配置前端控制层
 *
 * @author MrZhang
 * @since 2025-05-29 18:59
 */
@Tag(name = "充值三级配置接口")
@RestController
@RequestMapping("/api/v1/recharge-three")
@RequiredArgsConstructor
public class RechargeThreeController  {

    private final RechargeThreeService rechargeThreeService;

    @Operation(summary = "充值三级配置分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-three:query')")
    public PageResult<RechargeThreeVO> getRechargeThreePage(RechargeThreeQuery queryParams ) {
        IPage<RechargeThreeVO> result = rechargeThreeService.getRechargeThreePage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增充值三级配置")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('recharge:recharge-three:add')")
    public Result<Void> saveRechargeThree(@RequestBody @Valid RechargeThreeForm formData ) {
        boolean result = rechargeThreeService.saveRechargeThree(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取充值三级配置表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-three:edit')")
    public Result<RechargeThreeForm> getRechargeThreeForm(
            @Parameter(description = "充值三级配置ID") @PathVariable Long id
    ) {
        RechargeThreeForm formData = rechargeThreeService.getRechargeThreeFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改充值三级配置")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-three:edit')")
    public Result<Void> updateRechargeThree(
            @Parameter(description = "充值三级配置ID") @PathVariable Long id,
            @RequestBody @Validated RechargeThreeForm formData
    ) {
        boolean result = rechargeThreeService.updateRechargeThree(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除充值三级配置")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-three:delete')")
    public Result<Void> deleteRechargeThrees(
            @Parameter(description = "充值三级配置ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = rechargeThreeService.deleteRechargeThrees(ids);
        return Result.judge(result);
    }
}
