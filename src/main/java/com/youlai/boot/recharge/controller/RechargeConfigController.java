package com.youlai.boot.recharge.controller;

import com.youlai.boot.recharge.service.RechargeConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.recharge.model.form.RechargeConfigForm;
import com.youlai.boot.recharge.model.query.RechargeConfigQuery;
import com.youlai.boot.recharge.model.vo.RechargeConfigVO;
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
 * @since 2025-05-29 00:36
 */
@Tag(name = "充值分类子配置接口")
@RestController
@RequestMapping("/api/v1/recharge-config")
@RequiredArgsConstructor
public class RechargeConfigController  {

    private final RechargeConfigService rechargeConfigService;

    @Operation(summary = "充值分类子配置分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-config:query')")
    public PageResult<RechargeConfigVO> getRechargeConfigPage(RechargeConfigQuery queryParams ) {
        IPage<RechargeConfigVO> result = rechargeConfigService.getRechargeConfigPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增充值分类子配置")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('recharge:recharge-config:add')")
    public Result<Void> saveRechargeConfig(@RequestBody @Valid RechargeConfigForm formData ) {
        boolean result = rechargeConfigService.saveRechargeConfig(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取充值分类子配置表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-config:edit')")
    public Result<RechargeConfigForm> getRechargeConfigForm(
            @Parameter(description = "充值分类子配置ID") @PathVariable Long id
    ) {
        RechargeConfigForm formData = rechargeConfigService.getRechargeConfigFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改充值分类子配置")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-config:edit')")
    public Result<Void> updateRechargeConfig(
            @Parameter(description = "充值分类子配置ID") @PathVariable Long id,
            @RequestBody @Validated RechargeConfigForm formData
    ) {
        boolean result = rechargeConfigService.updateRechargeConfig(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除充值分类子配置")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-config:delete')")
    public Result<Void> deleteRechargeConfigs(
            @Parameter(description = "充值分类子配置ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = rechargeConfigService.deleteRechargeConfigs(ids);
        return Result.judge(result);
    }

    @Operation(summary = "Options")
    @GetMapping("/options")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-category:query')")
    public Result<List<Map<String, Object>>> getOptions() {
        return Result.success(rechargeConfigService.getOptions());
    }
}
