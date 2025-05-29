package com.youlai.boot.recharge.controller;

import com.youlai.boot.recharge.service.RechargeSecondService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.recharge.model.form.RechargeSecondForm;
import com.youlai.boot.recharge.model.query.RechargeSecondQuery;
import com.youlai.boot.recharge.model.vo.RechargeSecondVO;
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
 * 充值分类子配置前端控制层
 *
 * @author MrZhang
 * @since 2025-05-29 13:32
 */
@Tag(name = "充值分类子配置接口")
@RestController
@RequestMapping("/api/v1/recharge-second")
@RequiredArgsConstructor
public class RechargeSecondController  {

    private final RechargeSecondService rechargeSecondService;

    @Operation(summary = "充值分类子配置分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-second:query')")
    public PageResult<RechargeSecondVO> getRechargeSecondPage(RechargeSecondQuery queryParams ) {
        IPage<RechargeSecondVO> result = rechargeSecondService.getRechargeSecondPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增充值分类子配置")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('recharge:recharge-second:add')")
    public Result<Void> saveRechargeSecond(@RequestBody @Valid RechargeSecondForm formData ) {
        boolean result = rechargeSecondService.saveRechargeSecond(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取充值分类子配置表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-second:edit')")
    public Result<RechargeSecondForm> getRechargeSecondForm(
            @Parameter(description = "充值分类子配置ID") @PathVariable Long id
    ) {
        RechargeSecondForm formData = rechargeSecondService.getRechargeSecondFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改充值分类子配置")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-second:edit')")
    public Result<Void> updateRechargeSecond(
            @Parameter(description = "充值分类子配置ID") @PathVariable Long id,
            @RequestBody @Validated RechargeSecondForm formData
    ) {
        boolean result = rechargeSecondService.updateRechargeSecond(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除充值分类子配置")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-second:delete')")
    public Result<Void> deleteRechargeSeconds(
            @Parameter(description = "充值分类子配置ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = rechargeSecondService.deleteRechargeSeconds(ids);
        return Result.judge(result);
    }

    @Operation(summary = "Options")
    @GetMapping("/options")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-category:query')")
    public Result<List<Map<String, Object>>> getOptions() {
        return Result.success(rechargeSecondService.getOptions());
    }
}
