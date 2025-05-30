package com.youlai.boot.index.controller;

import com.youlai.boot.index.service.UserTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.index.model.query.UserTransferQuery;
import com.youlai.boot.index.model.vo.UserTransferVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.youlai.boot.common.result.PageResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 玩家投注表前端控制层
 *
 * @author MrZhang
 * @since 2025-05-30 12:33
 */
@Tag(name = "玩家投注表接口")
@RestController
@RequestMapping("/api/v1/user-transfer")
@RequiredArgsConstructor
public class UserTransferController  {

    private final UserTransferService userTransferService;

    @Operation(summary = "玩家投注表分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('index:user-transfer:query')")
    public PageResult<UserTransferVO> getUserTransferPage(UserTransferQuery queryParams ) {
        IPage<UserTransferVO> result = userTransferService.getUserTransferPage(queryParams);
        return PageResult.success(result);
    }
}
