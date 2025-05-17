package com.youlai.boot.index.controller;

import com.youlai.boot.common.result.Result;
import com.youlai.boot.index.model.FrontIndexResultVo;
import com.youlai.boot.index.service.IndexService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "0、管理端全局配置")
@RestController
@RequestMapping("/api/v1/front")
@RequiredArgsConstructor
public class FrontIndexController {
    @Autowired
    private IndexService indexService;

    @Operation(summary = "全局配置请求")
    @GetMapping("/index")
    private Result<FrontIndexResultVo> getIndexAdminData() {
        return Result.success(indexService.getIndexFrontData());
    }
}
