package com.youlai.boot.index.controller;

import com.youlai.boot.index.service.ActivityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.index.model.form.ActivityTypeForm;
import com.youlai.boot.index.model.query.ActivityTypeQuery;
import com.youlai.boot.index.model.vo.ActivityTypeVO;
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
 * 活动类型前端控制层
 *
 * @author MrZhang
 * @since 2025-06-06 20:45
 */
@Tag(name = "活动类型接口")
@RestController
@RequestMapping("/api/v1/activity-type")
@RequiredArgsConstructor
public class ActivityTypeController  {

    private final ActivityTypeService activityTypeService;

    @Operation(summary = "活动类型分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('index:activity-type:query')")
    public PageResult<ActivityTypeVO> getActivityTypePage(ActivityTypeQuery queryParams ) {
        IPage<ActivityTypeVO> result = activityTypeService.getActivityTypePage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增活动类型")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('index:activity-type:add')")
    public Result<Void> saveActivityType(@RequestBody @Valid ActivityTypeForm formData ) {
        boolean result = activityTypeService.saveActivityType(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取活动类型表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('index:activity-type:edit')")
    public Result<ActivityTypeForm> getActivityTypeForm(
            @Parameter(description = "活动类型ID") @PathVariable Long id
    ) {
        ActivityTypeForm formData = activityTypeService.getActivityTypeFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改活动类型")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('index:activity-type:edit')")
    public Result<Void> updateActivityType(
            @Parameter(description = "活动类型ID") @PathVariable Long id,
            @RequestBody @Validated ActivityTypeForm formData
    ) {
        boolean result = activityTypeService.updateActivityType(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除活动类型")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('index:activity-type:delete')")
    public Result<Void> deleteActivityTypes(
            @Parameter(description = "活动类型ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = activityTypeService.deleteActivityTypes(ids);
        return Result.judge(result);
    }

    @Operation(summary = "Options")
    @GetMapping("/options")
    @PreAuthorize("@ss.hasPerm('recharge:recharge-category:query')")
    public Result<List<Map<String, Object>>> getOptions() {
        return Result.success(activityTypeService.getOptions());
    }
}
