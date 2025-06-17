package com.youlai.boot.game.controller;

import com.youlai.boot.game.service.GamePlatTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.game.model.form.GamePlatTypeForm;
import com.youlai.boot.game.model.query.GamePlatTypeQuery;
import com.youlai.boot.game.model.vo.GamePlatTypeVO;
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

import java.util.Map;

/**
 * 游戏平台列表前端控制层
 *
 * @author MrZhang
 * @since 2025-06-15 18:49
 */
@Tag(name = "游戏平台列表接口")
@RestController
@RequestMapping("/api/v1/game-plat-type")
@RequiredArgsConstructor
public class GamePlatTypeController  {

    private final GamePlatTypeService gamePlatTypeService;

    @Operation(summary = "游戏平台列表分页列表")
    @PostMapping("/page")
    @PreAuthorize("@ss.hasPerm('game:game-plat-type:query')")
    public PageResult<GamePlatTypeVO> getGamePlatTypePage(@RequestBody GamePlatTypeQuery queryParams) {
        IPage<GamePlatTypeVO> result = gamePlatTypeService.getGamePlatTypePage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增游戏平台列表")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('game:game-plat-type:add')")
    public Result<Void> saveGamePlatType(@RequestBody @Valid GamePlatTypeForm formData ) {
        boolean result = gamePlatTypeService.saveGamePlatType(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取游戏平台列表表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('game:game-plat-type:edit')")
    public Result<GamePlatTypeForm> getGamePlatTypeForm(
            @Parameter(description = "游戏平台列表ID") @PathVariable Long id
    ) {
        GamePlatTypeForm formData = gamePlatTypeService.getGamePlatTypeFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改游戏平台列表")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('game:game-plat-type:edit')")
    public Result<Void> updateGamePlatType(
            @Parameter(description = "游戏平台列表ID") @PathVariable Long id,
            @RequestBody @Validated GamePlatTypeForm formData
    ) {
        boolean result = gamePlatTypeService.updateGamePlatType(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除游戏平台列表")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('game:game-plat-type:delete')")
    public Result<Void> deleteGamePlatTypes(
            @Parameter(description = "游戏平台列表ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = gamePlatTypeService.deleteGamePlatTypes(ids);
        return Result.judge(result);
    }

    @Operation(summary = "获取游戏平台列表")
    @GetMapping("/getGamePlatType")
    public Result<Map<String, Object>> getGamePlatType(@RequestParam("platType") String platType) {
        Map<String, Object> result = gamePlatTypeService.getGamePlatType(platType);
        return Result.success(result);
    }
}
