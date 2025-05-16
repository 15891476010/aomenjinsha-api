package com.youlai.boot.system.controller;

import com.youlai.boot.system.service.SysGroupDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.system.model.form.SysGroupDataForm;
import com.youlai.boot.system.model.query.SysGroupDataQuery;
import com.youlai.boot.system.model.vo.SysGroupDataVO;
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

import java.util.HashMap;
import java.util.List;

/**
 * 组合分类数据前端控制层
 *
 * @author MrZhang
 * @since 2025-05-15 00:48
 */
@Tag(name = "组合分类数据接口")
@RestController
@RequestMapping("/api/v1/sys-group-data")
@RequiredArgsConstructor
public class SysGroupDataController  {

    private final SysGroupDataService sysGroupDataService;

    @Operation(summary = "组合分类数据分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('system:sys-group-data:query')")
    public PageResult<SysGroupDataVO> getSysGroupDataPage(SysGroupDataQuery queryParams ) {
        IPage<SysGroupDataVO> result = sysGroupDataService.getSysGroupDataPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增组合分类数据")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('system:sys-group-data:add')")
    public Result<Void> saveSysGroupData(@RequestBody @Valid SysGroupDataForm formData ) {
        boolean result = sysGroupDataService.saveSysGroupData(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取组合分类数据表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('system:sys-group-data:edit')")
    public Result<SysGroupDataForm> getSysGroupDataForm(
            @Parameter(description = "组合分类数据ID") @PathVariable Long id
    ) {
        SysGroupDataForm formData = sysGroupDataService.getSysGroupDataFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改组合分类数据")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('system:sys-group-data:edit')")
    public Result<Void> updateSysGroupData(
            @Parameter(description = "组合分类数据ID") @PathVariable Long id,
            @RequestBody @Validated SysGroupDataForm formData
    ) {
        boolean result = sysGroupDataService.updateSysGroupData(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除组合分类数据")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('system:sys-group-data:delete')")
    public Result<Void> deleteSysGroupDatas(
            @Parameter(description = "组合分类数据ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = sysGroupDataService.deleteSysGroupDatas(ids);
        return Result.judge(result);
    }

    @Operation(summary = "根据gid分类数据")
    @GetMapping("/{id}")
    @PreAuthorize("@ss.hasPerm('system:sys-group-data:delete')")
    public Result<List<HashMap<String, Object>>> getSysGroupDataByGid(@PathVariable Integer id) {
        List<HashMap<String, Object>> listMapByGid = sysGroupDataService.getListMapByGid(id);
        return Result.success(listMapByGid);
    }
}
