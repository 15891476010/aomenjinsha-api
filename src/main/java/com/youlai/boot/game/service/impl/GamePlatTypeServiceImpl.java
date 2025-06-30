package com.youlai.boot.game.service.impl;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.base.CommonPage;
import com.youlai.boot.game.mapper.GameCategoryMapper;
import com.youlai.boot.game.model.entity.GameCategory;
import com.youlai.boot.game.model.entity.GameCategoryData;
import com.youlai.boot.game.model.vo.GamePlatTypeFrontVO;
import com.youlai.boot.game.service.GameCategoryDataService;
import com.youlai.boot.game.service.GameService;
import com.youlai.boot.service.MsGameApiService;
import com.youlai.boot.system.model.vo.FileResultVo;
import com.youlai.boot.system.service.AttachmentService;
import com.youlai.boot.system.service.SysGroupDataService;
import com.youlai.boot.system.service.UrlUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.game.mapper.GamePlatTypeMapper;
import com.youlai.boot.game.service.GamePlatTypeService;
import com.youlai.boot.game.model.entity.GamePlatType;
import com.youlai.boot.game.model.form.GamePlatTypeForm;
import com.youlai.boot.game.model.query.GamePlatTypeQuery;
import com.youlai.boot.game.model.vo.GamePlatTypeVO;
import com.youlai.boot.game.converter.GamePlatTypeConverter;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 游戏平台列表服务实现类
 *
 * @author MrZhang
 * @since 2025-06-15 18:49
 */
@Service
@RequiredArgsConstructor
public class GamePlatTypeServiceImpl extends ServiceImpl<GamePlatTypeMapper, GamePlatType> implements GamePlatTypeService {

    private final GamePlatTypeConverter gamePlatTypeConverter;
    private final MsGameApiService msGameApiService;
    private final GameCategoryDataService gameCategoryDataService;
    private final GameCategoryMapper gameCategoryMapper;
    private final SysGroupDataService sysGroupDataService;
    private final GameService gameService;
    private final UrlUploadService urlUploadService;
    private final AttachmentService attachmentService;

    /**
     * 获取游戏平台列表分页列表
     *
     * @param queryParams 查询参数
     * @return {@link Page<GamePlatTypeVO>} 游戏平台列表分页列表
     */
    @Override
    public Page<GamePlatTypeVO> getGamePlatTypePage(GamePlatTypeQuery queryParams) {
        Page<GamePlatType> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<GamePlatType> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(GamePlatType::getSort);
        wrapper.orderByDesc(GamePlatType::getId);
        if (ObjectUtil.isNotEmpty(queryParams.getStatus())) {
            wrapper.eq(GamePlatType::getStatus, queryParams.getStatus());
        }
        if (ObjectUtil.isNotEmpty(queryParams.getPlatTypeName())) {
            wrapper.like(GamePlatType::getPlatTypeName, queryParams.getPlatTypeName());
        }

        if (ObjectUtil.isNotEmpty(queryParams.getPlatType())) {
            wrapper.like(GamePlatType::getPlatType, queryParams.getPlatType());
        }

        if (ObjectUtil.isNotEmpty(queryParams.getIsShowTitle())) {
            wrapper.eq(GamePlatType::getIsShowTitle, queryParams.getIsShowTitle());
        }

        if (ObjectUtil.isNotEmpty(queryParams.getGameType())) {
            wrapper.eq(GamePlatType::getGameType, queryParams.getGameType());
        }
        Page<GamePlatType> result = baseMapper.selectPage(page, wrapper);
        List<GamePlatTypeVO> listEntity = gamePlatTypeConverter.toListEntity(result.getRecords());
        listEntity.forEach(item -> {
            GameCategory gameCategory = gameCategoryMapper.selectById(item.getGameType());
            item.setGameTypeHanZi(gameCategory.getTitle());
//            String credit = gameService.getCredit(item.getPlatType());
//            item.setMerchantQuota(credit);
        });
        return CommonPage.copyPageInfo(result, listEntity);
    }

    /**
     * 获取游戏平台列表表单数据
     *
     * @param id 游戏平台列表ID
     * @return 游戏平台列表表单数据
     */
    @Override
    public GamePlatTypeForm getGamePlatTypeFormData(Long id) {
        GamePlatType entity = this.getById(id);
        return gamePlatTypeConverter.toForm(entity);
    }

    /**
     * 新增游戏平台列表
     *
     * @param formData 游戏平台列表表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveGamePlatType(GamePlatTypeForm formData) {
        GamePlatType entity = gamePlatTypeConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新游戏平台列表
     *
     * @param id   游戏平台列表ID
     * @param formData 游戏平台列表表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateGamePlatType(Long id,GamePlatTypeForm formData) {
        GamePlatType entity = gamePlatTypeConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除游戏平台列表
     *
     * @param ids 游戏平台列表ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteGamePlatTypes(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的游戏平台列表数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public Map<String, Object> getGamePlatType(String platType) {
        Map<String, Object> result = new HashMap<>();
        result.put("platType", platType);
        result.put("total", 0);
        result.put("added", 0);
        result.put("updated", 0);
        result.put("errors", 0);

        try {
            // 1. 获取原始数据
            Map<String, Object> apiResponse = msGameApiService.getGameList(platType);
            if ((int) apiResponse.get("Code") != 0) {
                throw new RuntimeException("API错误码: " + apiResponse.get("Code"));
            }

            Map<String, Object> responseData = (Map<String, Object>) apiResponse.get("Data");
            List<Map<String, Object>> rawGameList = (List<Map<String, Object>>) responseData.get("gamelist");
            int total = rawGameList != null ? rawGameList.size() : 0;
            result.put("total", total);

            if (rawGameList == null || rawGameList.isEmpty()) {
                result.put("message", "无有效游戏数据");
                return result;
            }

            // 2. 预加载数据
            Set<String> gameTypes = new HashSet<>();
            List<Map<String, Object>> validGames = new ArrayList<>();
            List<String> errorGames = new ArrayList<>();

            // 数据校验和收集gameType
            for (Map<String, Object> game : rawGameList) {
                try {
                    if (game.get("gameType") == null || game.get("code") == null ||
                            game.get("name") == null || game.get("gameCode") == null ||
                            game.get("id") == null) {
                        throw new RuntimeException("缺少必要字段");
                    }
                    gameTypes.add(game.get("gameType").toString());
                    validGames.add(game);
                } catch (Exception e) {
                    errorGames.add(game.getOrDefault("code", "未知游戏") + ":" + e.getMessage());
                }
            }

            // 批量查询分类
            Map<String, GameCategory> categoryMap = gameCategoryMapper.selectList(
                    new LambdaQueryWrapper<GameCategory>().in(GameCategory::getGameType, gameTypes)
            ).stream().collect(Collectors.toMap(GameCategory::getGameType, Function.identity()));

            // 批量查询现有游戏数据
            List<Pair<String, String>> gameKeys = validGames.stream()
                    .map(game -> Pair.of(
                            game.get("gameCode").toString(),
                            game.get("id").toString()
                    ))
                    .collect(Collectors.toList());

            Map<Pair<String, String>, GameCategoryData> existingMap = new HashMap<>();
            if (!gameKeys.isEmpty()) {
                LambdaQueryWrapper<GameCategoryData> wrapper = new LambdaQueryWrapper<>();
                wrapper.and(wp -> {
                    for (Pair<String, String> key : gameKeys) {
                        wp.or(w -> w.eq(GameCategoryData::getGameCode, key.getKey())
                                .eq(GameCategoryData::getProvider, key.getValue()));
                    }
                });
                gameCategoryDataService.list(wrapper).forEach(data ->
                        existingMap.put(Pair.of(data.getGameCode(), data.getProvider()), data)
                );
            }

            // 3. 准备批量操作数据
            List<GameCategoryData> toAdd = new ArrayList<>();
            List<GameCategoryData> toUpdate = new ArrayList<>();

            for (Map<String, Object> game : validGames) {
                try {
                    String gameType = game.get("gameType").toString();
                    GameCategory category = categoryMap.get(gameType);
                    if (category == null) {
                        throw new RuntimeException("分类不存在: " + gameType);
                    }

                    Pair<String, String> gameKey = Pair.of(
                            game.get("gameCode").toString(),
                            game.get("id").toString()
                    );
                    GameCategoryData existing = existingMap.get(gameKey);
                    GameCategoryData gameData = existing != null ? existing : new GameCategoryData();

                    // 直接使用img字段作为图标URL
                    gameData.setIcon(game.get("img") != null ?
                            game.get("img").toString() : "");

                    // 设置其他字段
                    gameData.setPid(Math.toIntExact(category.getId()));
                    gameData.setTitle(game.get("name").toString());
                    gameData.setGameCode(game.get("gameCode").toString());
                    gameData.setZhHans(game.get("name").toString());
                    gameData.setEn(game.get("en_name") != null ? game.get("en_name").toString() : "");
                    gameData.setIngress(game.get("terminal") != null ?
                            Integer.parseInt(game.get("terminal").toString()) : 0);
                    gameData.setStatus("1".equals(game.get("status")));
                    gameData.setTag(game.get("code").toString());
                    gameData.setProvider(game.get("id").toString());

                    // 分类到新增/更新列表
                    if (existing != null) {
                        toUpdate.add(gameData);
                    } else {
                        toAdd.add(gameData);
                    }
                } catch (Exception e) {
                    errorGames.add(game.get("code") + ":" + e.getMessage());
                }
            }

            // 4. 批量操作数据库
            if (!toAdd.isEmpty()) {
                boolean addSuccess = gameCategoryDataService.saveBatch(toAdd);
                result.put("added", addSuccess ? toAdd.size() : 0);
                if (!addSuccess) errorGames.add("批量新增失败");
            }

            if (!toUpdate.isEmpty()) {
                boolean updateSuccess = gameCategoryDataService.updateBatchById(toUpdate);
                result.put("updated", updateSuccess ? toUpdate.size() : 0);
                if (!updateSuccess) errorGames.add("批量更新失败");
            }

            // 5. 错误处理
            int errors = errorGames.size();
            result.put("errors", errors);
            if (!errorGames.isEmpty()) {
                result.put("errorDetails", errorGames);
            }
            result.put("message", String.format("处理完成: 新增%d/更新%d/错误%d",
                    toAdd.size(), toUpdate.size(), errors));

        } catch (Exception e) {
            result.put("errors", result.get("total"));
            result.put("message", "系统异常: " + e.getMessage());
        }

        return result;
    }

    @Override
    public List<GamePlatTypeFrontVO> getGamePlatTypeList(Long id) {
        GameCategory gameCategory = gameCategoryMapper.selectById(id);
        if (gameCategory == null) {
            return Collections.emptyList();
        }

        LambdaQueryWrapper<GamePlatType> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GamePlatType::getGameType, gameCategory.getId());
        wrapper.orderByAsc(GamePlatType::getSort);

        List<GamePlatType> gamePlatTypes = baseMapper.selectList(wrapper);
        List<GamePlatTypeFrontVO> frontListEntity = gamePlatTypeConverter.toFrontListEntity(gamePlatTypes);
        frontListEntity.forEach(front -> {
            front.setCategoryName(gameCategory.getTitle());
        });
        return frontListEntity;
    }

}
