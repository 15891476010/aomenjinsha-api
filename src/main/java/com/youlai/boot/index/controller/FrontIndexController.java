package com.youlai.boot.index.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.common.annotation.AesEncrypt;
import com.youlai.boot.common.constant.SysGroupConstants;
import com.youlai.boot.common.result.PageResult;
import com.youlai.boot.common.result.Result;
import com.youlai.boot.game.model.entity.GameCategory;
import com.youlai.boot.game.model.query.GameCategoryDataFrontQuery;
import com.youlai.boot.game.model.vo.GameCategoryDataVO;
import com.youlai.boot.game.model.vo.GameCategoryFrontVO;
import com.youlai.boot.game.model.vo.GameCategoryResultVO;
import com.youlai.boot.game.model.vo.GamePlatTypeFrontVO;
import com.youlai.boot.game.service.GameCategoryDataService;
import com.youlai.boot.game.service.GameCategoryService;
import com.youlai.boot.game.service.GamePlatTypeService;
import com.youlai.boot.index.model.FrontIndexResultVo;
import com.youlai.boot.index.model.PageQuerys;
import com.youlai.boot.index.model.form.ActiviteForm;
import com.youlai.boot.index.model.query.ActiviteQuery;
import com.youlai.boot.index.model.vo.ActiviteVO;
import com.youlai.boot.index.service.ActiviteService;
import com.youlai.boot.index.service.ActivityTypeService;
import com.youlai.boot.index.service.IndexService;
import com.youlai.boot.recharge.model.vo.RechargeCategoryVO;
import com.youlai.boot.recharge.service.RechargeCategoryService;
import com.youlai.boot.system.model.vo.DictItemOptionVO;
import com.youlai.boot.system.service.DictItemService;
import com.youlai.boot.system.service.SysGroupDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "0、管理端全局配置")
@RestController
@RequestMapping("/api/v2/front")
@RequiredArgsConstructor
public class FrontIndexController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private GameCategoryService gameCategoryService;
    @Autowired
    private RechargeCategoryService rechargeCategoryService;
    private final ActivityTypeService activityTypeService;
    private final ActiviteService activiteService;
    private final GamePlatTypeService gamePlatTypeService;
    @Autowired
    private GameCategoryDataService gameCategoryDataService;
    private final DictItemService dictItemService;
    private final SysGroupDataService sysGroupDataService;

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

    @Operation(summary = "前端查询充值配置")
    @GetMapping("/recharge")
    @AesEncrypt
    public Result<List<RechargeCategoryVO>> getRecharge() {
        List<RechargeCategoryVO> rechargeCategoryList = rechargeCategoryService.getRechargeCategoryList();
        return Result.success(rechargeCategoryList);
    }

    @Operation(summary = "Options")
    @GetMapping("/getActivityTypeOptions")
    @AesEncrypt
    public Result<List<Map<String, Object>>> getOptions() {
        return Result.success(activityTypeService.getOptions());
    }

    @Operation(summary = "活动表分页列表")
    @GetMapping("/getActiviteList")
    @AesEncrypt
    public Result<List<ActiviteVO>> getActivitePage(@RequestParam("pid") Integer pid) {
        ActiviteQuery queryParams = new ActiviteQuery();
        queryParams.setPid(pid);
        List<ActiviteVO> activiteList = activiteService.getActiviteList(queryParams);
        return Result.success(activiteList);
    }

    @Operation(summary = "获取活动表表单数据")
    @GetMapping("/getActivite/{id}")
    @AesEncrypt
    public Result<ActiviteForm> getActiviteForm(@PathVariable Long id) {
        ActiviteForm formData = activiteService.getActiviteFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "前端根据id获取游戏平台")
    @PostMapping("/getGameCategoryById")
    @AesEncrypt
    public Result<GameCategoryFrontVO> getGameCategoryById(@RequestBody Long id) {
        return Result.success(gameCategoryService.getGameCategoryById(id));
    }

    @Operation(summary = "前端根据平台类型获取游戏列表")
    @PostMapping("/getGamePlatTypeList")
    @AesEncrypt
    public Result<Page<GameCategoryDataVO>> getGamePlatTypeList(@RequestBody GameCategoryDataFrontQuery queryParams, HttpServletRequest request) {
        // 获取User-Agent
        String userAgent = request.getHeader("User-Agent");
        System.out.println(userAgent);
        // 判断是否为手机端访问
        boolean isMobile = isMobileDevice(userAgent);

        // 根据判断结果处理逻辑
        if (isMobile) {
            // 手机端的处理逻辑
            queryParams.setTerminal(2);
        } else {
            // 电脑端的处理逻辑
            queryParams.setTerminal(1);
        }
        return Result.success(gameCategoryDataService.getGameCategoryDataPageByPlatType(queryParams));
    }

    private boolean isMobileDevice(String userAgent) {
        return userAgent != null && (
                userAgent.contains("Android") ||
                        userAgent.contains("iPhone") ||
                        userAgent.contains("Windows Phone") ||
                        userAgent.contains("Mobile") ||
                        userAgent.contains("wv")  // WebView 特征
        );
    }

    @Operation(summary = "获取游戏平台列表")
    @PostMapping("/getGamePlatTypeByCaId")
    @AesEncrypt
    public Result<List<GamePlatTypeFrontVO>> getGamePlatType(@RequestBody Long id) {
        List<GamePlatTypeFrontVO> gamePlatTypeList = gamePlatTypeService.getGamePlatTypeList(id);
        return Result.success(gamePlatTypeList);
    }

    @Operation(summary = "获取字典列表")
    @GetMapping("/getDictItems")
    public Result<List<DictItemOptionVO>> getDictItems(@Parameter(description = "字典编码") String dictCode) {
        List<DictItemOptionVO> dictItems = dictItemService.getDictItems(dictCode);
        return Result.success(dictItems);
    }

    @Operation(summary = "获取我的页面跳转列表")
    @GetMapping("/getMinePagesList")
    @AesEncrypt
    public Result<List<HashMap<String, Object>>> getMinePagesList() {
        List<HashMap<String, Object>> listMapByGid = sysGroupDataService.getListMapByGid(SysGroupConstants.GROUP_ID_INDEX_MINE_PAGES_LIST);
        return Result.success(listMapByGid);
    }
    @Operation(summary = "获取我的页面底部跳转列表")
    @GetMapping("/getMinePagesBottomList")
    @AesEncrypt
    public Result<List<HashMap<String, Object>>> getMinePagesBottomList() {
        List<HashMap<String, Object>> listMapByGid = sysGroupDataService.getListMapByGid(SysGroupConstants.GROUP_ID_INDEX_MINE_BUTTON_PAGES_LIST);
        return Result.success(listMapByGid);
    }
}
