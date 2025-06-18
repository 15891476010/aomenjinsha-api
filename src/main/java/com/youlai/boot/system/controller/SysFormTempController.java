package com.youlai.boot.system.controller;

import com.youlai.boot.system.model.entity.SysFormTemp;
import com.youlai.boot.system.service.SysFormTempService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.system.model.form.SysFormTempForm;
import com.youlai.boot.system.model.query.SysFormTempQuery;
import com.youlai.boot.system.model.vo.SysFormTempVO;
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
 * 表单模板前端控制层
 *
 * @author MrZhang
 * @since 2025-05-07 15:40
 */
@Tag(name = "表单模板接口")
@RestController
@RequestMapping("/api/v1/sys-form-temp")
@RequiredArgsConstructor
public class SysFormTempController  {

    private final SysFormTempService sysFormTempService;

    @Operation(summary = "表单模板分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('system:sys-form-temp:query')")
    public PageResult<SysFormTempVO> getSysFormTempPage(SysFormTempQuery queryParams ) {
        IPage<SysFormTempVO> result = sysFormTempService.getSysFormTempPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增表单模板")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('system:sys-form-temp:add')")
    public Result<Void> saveSysFormTemp(@RequestBody @Valid SysFormTempForm formData ) {
        boolean result = sysFormTempService.saveSysFormTemp(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取表单模板表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('system:sys-form-temp:edit')")
    public Result<SysFormTempVO> getSysFormTempForm(
            @Parameter(description = "表单模板ID") @PathVariable Long id
    ) {
        SysFormTempVO sysFormTempFormData = sysFormTempService.getSysFormTempFormData(id);
        return Result.success(sysFormTempFormData);
    }

    @Operation(summary = "修改表单模板")
    @PutMapping(value = "/update")
    @PreAuthorize("@ss.hasPerm('system:sys-form-temp:edit')")
    public Result<Void> updateSysFormTemp(
            @RequestBody @Validated SysFormTempForm formData
    ) {
        boolean result = sysFormTempService.updateSysFormTemp(formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除表单模板")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('system:sys-form-temp:delete')")
    public Result<Void> deleteSysFormTemps(
            @Parameter(description = "表单模板ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = sysFormTempService.deleteSysFormTemps(ids);
        return Result.judge(result);
    }
}
