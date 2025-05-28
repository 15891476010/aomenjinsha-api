package com.youlai.boot.index.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.common.annotation.AesEncrypt;
import com.youlai.boot.common.result.PageResult;
import com.youlai.boot.common.result.Result;
import com.youlai.boot.game.model.vo.GameCategoryResultVO;
import com.youlai.boot.game.service.GameCategoryService;
import com.youlai.boot.index.model.FrontIndexResultVo;
import com.youlai.boot.index.model.PageQuerys;
import com.youlai.boot.index.service.IndexService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "0、管理端全局配置")
@RestController
@RequestMapping("/api/v1/front")
@RequiredArgsConstructor
public class FrontIndexController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private GameCategoryService gameCategoryService;

    @Operation(summary = "全局配置请求")
    @GetMapping("/index")
    @AesEncrypt
    private Result<FrontIndexResultVo> getIndexAdminData() {
        return Result.success(indexService.getIndexFrontData());
    }

    @Operation(summary = "游戏分页列表")
    @PostMapping("/page")
    @AesEncrypt
    public PageResult<GameCategoryResultVO> getGameCategoryPage(@RequestBody PageQuerys pageQuerys) {
        Page<GameCategoryResultVO> gameCategoryResultList = gameCategoryService.getGameCategoryResultList(pageQuerys.getOne(), pageQuerys.getTwo());
        return PageResult.success(gameCategoryResultList);
    }
}
