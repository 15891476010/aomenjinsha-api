package com.youlai.boot.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.service.SysGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.system.model.form.SysGroupForm;
import com.youlai.boot.system.model.query.SysGroupQuery;
import com.youlai.boot.system.model.vo.SysGroupVO;
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
 * 组合数据分类前端控制层
 *
 * @author MrZhang
 * @since 2025-05-15 00:13
 */
@Tag(name = "组合数据分类接口")
@RestController
@RequestMapping("/api/v1/sys-group")
@RequiredArgsConstructor
public class SysGroupController  {

    private final SysGroupService sysGroupService;

    @Operation(summary = "组合数据分类分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('system:sys-group:query')")
    public PageResult<SysGroupVO> getSysGroupPage(SysGroupQuery queryParams ) {
        Page<SysGroupVO> result = sysGroupService.getSysGroupPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增组合数据分类")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('system:sys-group:add')")
    public Result<Void> saveSysGroup(@RequestBody @Valid SysGroupForm formData ) {
        boolean result = sysGroupService.saveSysGroup(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取组合数据分类表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('system:sys-group:edit')")
    public Result<SysGroupForm> getSysGroupForm(
            @Parameter(description = "组合数据分类ID") @PathVariable Long id
    ) {
        SysGroupForm formData = sysGroupService.getSysGroupFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改组合数据分类")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('system:sys-group:edit')")
    public Result<Void> updateSysGroup(
            @Parameter(description = "组合数据分类ID") @PathVariable Long id,
            @RequestBody @Validated SysGroupForm formData
    ) {
        boolean result = sysGroupService.updateSysGroup(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除组合数据分类")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('system:sys-group:delete')")
    public Result<Void> deleteSysGroups(
            @Parameter(description = "组合数据分类ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = sysGroupService.deleteSysGroups(ids);
        return Result.judge(result);
    }
}
