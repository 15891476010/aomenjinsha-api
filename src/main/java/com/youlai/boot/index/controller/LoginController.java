package com.youlai.boot.index.controller;

import com.youlai.boot.common.result.Result;
import com.youlai.boot.core.security.model.AuthenticationToken;
import com.youlai.boot.index.model.form.EbUserForm;
import com.youlai.boot.index.model.form.EbUserLoginRequest;
import com.youlai.boot.index.service.EbUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 前端用户前端控制层
 *
 * @author MrZhang
 * @since 2025-05-24 14:47
 */
@Tag(name = "前端用户接口")
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class LoginController {

    private final EbUserService ebUserService;

    @Operation(summary = "登录")
    @PostMapping("/login")
    public Result<AuthenticationToken> login(HttpServletRequest request, @RequestBody EbUserLoginRequest loginRequest) {
        AuthenticationToken login = ebUserService.login(request, loginRequest);
        return Result.success(login);
    }

    @Operation(summary = "注册")
    @PostMapping("/register")
    public Result<Void> register(HttpServletRequest request, @RequestBody @Valid EbUserForm formData ) {
        boolean result = ebUserService.saveEbUser(request, formData);
        return Result.judge(result);
    }
}
