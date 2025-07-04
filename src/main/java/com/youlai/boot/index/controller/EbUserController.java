package com.youlai.boot.index.controller;

import com.youlai.boot.common.annotation.Log;
import com.youlai.boot.common.enums.LogModuleEnum;
import com.youlai.boot.index.model.query.EbUserGameBalanceQuery;
import com.youlai.boot.index.model.query.EbUserGameTransferQuery;
import com.youlai.boot.index.model.query.EbUserGameTransferQueryVo;
import com.youlai.boot.index.model.vo.EbUserFrontVO;
import com.youlai.boot.index.service.EbUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.index.model.form.EbUserForm;
import com.youlai.boot.index.model.query.EbUserQuery;
import com.youlai.boot.index.model.vo.EbUserVO;
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
import com.youlai.boot.common.annotation.AesEncrypt;

import java.util.Map;

/**
 * 前端用户前端控制层
 *
 * @author MrZhang
 * @since 2025-05-24 14:47
 */
@Tag(name = "前端用户接口")
@RestController
@RequestMapping("/api/v2/user")
@RequiredArgsConstructor
public class EbUserController  {

    private final EbUserService ebUserService;

    @Operation(summary = "前端用户分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('index:eb-user:query')")
    public PageResult<EbUserVO> getEbUserPage(EbUserQuery queryParams ) {
        IPage<EbUserVO> result = ebUserService.getEbUserPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增前端用户")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('index:eb-user:add')")
    public Result<Void> saveEbUser(HttpServletRequest request, @RequestBody @Valid EbUserForm formData ) {
        boolean result = ebUserService.saveEbUser(request, formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取前端用户表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('index:eb-user:edit')")
    public Result<EbUserForm> getEbUserForm(
            @Parameter(description = "前端用户ID") @PathVariable Long id
    ) {
        EbUserForm formData = ebUserService.getEbUserFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改前端用户")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('index:eb-user:edit')")
    public Result<Void> updateEbUser(
            @Parameter(description = "前端用户ID") @PathVariable Long id,
            @RequestBody @Validated EbUserForm formData
    ) {
        boolean result = ebUserService.updateEbUser(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除前端用户")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('index:eb-user:delete')")
    public Result<Void> deleteEbUsers(
            @Parameter(description = "前端用户ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = ebUserService.deleteEbUsers(ids);
        return Result.judge(result);
    }

    @Operation(summary = "获取当前登录用户信息")
    @GetMapping("/me")
    @AesEncrypt
    @Log(value = "获取当前登录用户信息", module = LogModuleEnum.USER)
    public Result<EbUserFrontVO> getCurrentUser() {
        EbUserFrontVO currentUserInfo = ebUserService.getCurrentUserInfo();
        return Result.success(currentUserInfo);
    }


    @Operation(summary = "获取用户余额")
    @PostMapping("/balance")
    public Map<String, Object> balance(EbUserGameBalanceQuery queryParams) {
        return ebUserService.getUserBalance(queryParams);
    }

    @Operation(summary = "免转钱包下注")
    @PostMapping("/transfer")
    public Map<String, Object> transfer(EbUserGameTransferQueryVo ebUserGameTransferQuery) {
        EbUserGameTransferQuery queryParams = new EbUserGameTransferQuery();
        queryParams.setBetAmount(ebUserGameTransferQuery.getBet_amount());
        queryParams.setWinAmount(ebUserGameTransferQuery.getWin_amount());
        queryParams.setNetAmount(ebUserGameTransferQuery.getNet_amount());
        queryParams.setPlayerId(ebUserGameTransferQuery.getPlayer_id());
        queryParams.setCurrency(ebUserGameTransferQuery.getCurrency());
        queryParams.setTransactionid(ebUserGameTransferQuery.getTransactionid());
        queryParams.setParentTransactionid(ebUserGameTransferQuery.getParent_transactionid());
        queryParams.setIsEndRound(ebUserGameTransferQuery.getIs_end_round());
        queryParams.setGid(ebUserGameTransferQuery.getGid());
        queryParams.setTimestamp(ebUserGameTransferQuery.getTimestamp());
        queryParams.setSign(ebUserGameTransferQuery.getSign());
        return ebUserService.transfer(queryParams);
    }

    @Operation(summary = "检测用户是否登录")
    @PostMapping("/checkLogin")
    @AesEncrypt
    public Result<Boolean> checkLogin() {
        return Result.success(ebUserService.checkLogin());
    }

}
