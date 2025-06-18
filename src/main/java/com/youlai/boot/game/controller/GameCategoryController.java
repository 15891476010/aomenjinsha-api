package com.youlai.boot.game.controller;

import com.youlai.boot.game.service.GameCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.game.model.form.GameCategoryForm;
import com.youlai.boot.game.model.query.GameCategoryQuery;
import com.youlai.boot.game.model.vo.GameCategoryVO;
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
 * 游戏分类前端控制层
 *
 * @author MrZhang
 * @since 2025-05-18 16:38
 */
@Tag(name = "游戏分类接口")
@RestController
@RequestMapping("/api/v1/game-category")
@RequiredArgsConstructor
public class GameCategoryController  {

    private final GameCategoryService gameCategoryService;

    @Operation(summary = "游戏分类分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('game:game-category:query')")
    public PageResult<GameCategoryVO> getGameCategoryPage(GameCategoryQuery queryParams ) {
        IPage<GameCategoryVO> result = gameCategoryService.getGameCategoryPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增游戏分类")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('game:game-category:add')")
    public Result<Void> saveGameCategory(@RequestBody @Valid GameCategoryForm formData ) {
        boolean result = gameCategoryService.saveGameCategory(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取游戏分类表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('game:game-category:edit')")
    public Result<GameCategoryForm> getGameCategoryForm(
            @Parameter(description = "游戏分类ID") @PathVariable Long id
    ) {
        GameCategoryForm formData = gameCategoryService.getGameCategoryFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改游戏分类")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('game:game-category:edit')")
    public Result<Void> updateGameCategory(
            @Parameter(description = "游戏分类ID") @PathVariable Long id,
            @RequestBody @Validated GameCategoryForm formData
    ) {
        boolean result = gameCategoryService.updateGameCategory(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除游戏分类")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('game:game-category:delete')")
    public Result<Void> deleteGameCategorys(
            @Parameter(description = "游戏分类ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = gameCategoryService.deleteGameCategorys(ids);
        return Result.judge(result);
    }

    @Operation(summary = "Options")
    @GetMapping("/options")
    @PreAuthorize("@ss.hasPerm('game:game-category:query')")
    public Result<List<Map<String, Object>>> getOptions() {
        return Result.success(gameCategoryService.getOptions());
    }
}
