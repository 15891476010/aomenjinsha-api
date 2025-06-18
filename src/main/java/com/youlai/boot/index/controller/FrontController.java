package com.youlai.boot.index.controller;

import com.youlai.boot.common.result.Result;
import com.youlai.boot.index.service.ActiviteApplyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "前端需要校验接口")
@RestController
@RequestMapping("/api/v2/auth/front")
@RequiredArgsConstructor
public class FrontController {
    private final ActiviteApplyService activiteApplyService;

    @Operation(summary = "前端申请活动")
    @PostMapping("/apply/{activiteId}")
    public Result<Boolean> applyActivite(@PathVariable("activiteId") Integer activiteId) {
        return Result.success(activiteApplyService.applyActivite(activiteId));
    }
}
