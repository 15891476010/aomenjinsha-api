package com.youlai.boot.game.controller;

import com.youlai.boot.common.result.Result;
import com.youlai.boot.game.model.form.GameCategoryForm;
import com.youlai.boot.game.service.GameCategoryService;
import com.youlai.boot.game.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 游戏分类前端控制层
 *
 * @author MrZhang
 * @since 2025-05-18 16:38
 */
@Tag(name = "游戏接口")
@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @Operation(summary = "获取游戏地址")
    @GetMapping("/getUrl")
    public Result<Map<String, Object>> getUrl(@RequestParam("id") Long id) {
        Map<String, Object> gameUrl = gameService.getGameUrl(id);
        return Result.success(gameUrl);
    }
}
