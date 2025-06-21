package com.youlai.boot.game.controller;

import com.youlai.boot.common.result.Result;
import com.youlai.boot.game.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @PostMapping("/getUrl")
    public Result<Map<String, Object>> getUrl(@RequestBody Long id,
                                              @RequestBody(required = false) Boolean type) {
        Map<String, Object> gameUrl = gameService.getGameUrl(id, type);
        return Result.success(gameUrl);
    }

    @Operation(summary = "获取游戏供应商列表")
    @GetMapping("/getProviderList")
    public Result<List<Map<String, String>>> getProviderList() {
        return Result.success(gameService.getGameProviderList());
    }
}
