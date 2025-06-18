package com.youlai.boot.game.controller;

import com.youlai.boot.game.service.GameCategoryDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.game.model.form.GameCategoryDataForm;
import com.youlai.boot.game.model.query.GameCategoryDataQuery;
import com.youlai.boot.game.model.vo.GameCategoryDataVO;
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
 * 游戏列前端控制层
 *
 * @author MrZhang
 * @since 2025-05-18 19:33
 */
@Tag(name = "游戏列接口")
@RestController
@RequestMapping("/api/v1/game-category-data")
@RequiredArgsConstructor
public class GameCategoryDataController  {

    private final GameCategoryDataService gameCategoryDataService;

    @Operation(summary = "游戏列分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('game:game-category-data:query')")
    public PageResult<GameCategoryDataVO> getGameCategoryDataPage(GameCategoryDataQuery queryParams ) {
        IPage<GameCategoryDataVO> result = gameCategoryDataService.getGameCategoryDataPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增游戏列")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('game:game-category-data:add')")
    public Result<Void> saveGameCategoryData(@RequestBody @Valid GameCategoryDataForm formData ) {
        boolean result = gameCategoryDataService.saveGameCategoryData(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取游戏列表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('game:game-category-data:edit')")
    public Result<GameCategoryDataForm> getGameCategoryDataForm(
            @Parameter(description = "游戏列ID") @PathVariable Long id
    ) {
        GameCategoryDataForm formData = gameCategoryDataService.getGameCategoryDataFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改游戏列")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('game:game-category-data:edit')")
    public Result<Void> updateGameCategoryData(
            @Parameter(description = "游戏列ID") @PathVariable Long id,
            @RequestBody @Validated GameCategoryDataForm formData
    ) {
        boolean result = gameCategoryDataService.updateGameCategoryData(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除游戏列")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('game:game-category-data:delete')")
    public Result<Void> deleteGameCategoryDatas(
            @Parameter(description = "游戏列ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = gameCategoryDataService.deleteGameCategoryDatas(ids);
        return Result.judge(result);
    }
}
