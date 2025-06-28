package com.youlai.boot.game.service.impl;

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
import com.youlai.boot.system.service.SysGroupDataService;
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
            String credit = gameService.getCredit(item.getPlatType());
            item.setMerchantQuota(credit);
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
        // 最终返回结果（只包含处理结果统计）
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
            result.put("total", rawGameList != null ? rawGameList.size() : 0);

            if (rawGameList == null || rawGameList.isEmpty()) {
                result.put("message", "无有效游戏数据");
                return result;
            }

            // 2. 准备批量操作数据
            List<GameCategoryData> toAdd = new ArrayList<>();
            List<GameCategoryData> toUpdate = new ArrayList<>();
            List<String> errorGames = new ArrayList<>();

            for (Map<String, Object> game : rawGameList) {
                try {
                    // 字段校验
                    if (game.get("gameType") == null || game.get("code") == null || game.get("name") == null) {
                        throw new RuntimeException("缺少必要字段");
                    }

                    // 查询分类
                    GameCategory category = gameCategoryMapper.selectOne(
                            new LambdaQueryWrapper<GameCategory>()
                                    .eq(GameCategory::getGameType, game.get("gameType"))
                    );
                    if (category == null) {
                        throw new RuntimeException("分类不存在");
                    }

                    // 构建查询条件
                    LambdaQueryWrapper<GameCategoryData> wrapper = new LambdaQueryWrapper<>(GameCategoryData.class)
                            .eq(GameCategoryData::getGameCode, game.get("gameCode").toString())
                            .eq(GameCategoryData::getProvider, game.get("id").toString());

                    // 检查是否存在
                    GameCategoryData existing = gameCategoryDataService.getOne(wrapper);

                    // 构建数据对象
                    GameCategoryData gameData = existing != null ? existing : new GameCategoryData();
                    gameData.setPid(Math.toIntExact(category.getId()));
                    gameData.setTitle(game.get("name").toString());
                    gameData.setIcon(game.get("img") != null ? game.get("img").toString() : "");
                    gameData.setGameCode(game.get("gameCode") != null ? game.get("gameCode").toString() : "");
                    gameData.setZhHans(game.get("name").toString());
                    gameData.setEn(game.get("en_name") != null ? game.get("en_name").toString() : "");
                    gameData.setIngress(game.get("terminal") != null ? Integer.parseInt(game.get("terminal").toString()) : 0);
                    gameData.setStatus("1".equals(game.get("status")));
                    gameData.setTag(game.get("code").toString());
                    gameData.setProvider(game.get("id").toString());

                    // 添加到对应批次
                    if (existing != null) {
                        toUpdate.add(gameData);
                    } else {
                        toAdd.add(gameData);
                    }

                } catch (Exception e) {
                    errorGames.add(game.get("code") + ":" + e.getMessage());
                    result.put("errors", (int) result.get("errors") + 1);
                }
            }

            // 3. 执行批量操作
            if (!toAdd.isEmpty()) {
                boolean addSuccess = gameCategoryDataService.saveBatch(toAdd);
                result.put("added", addSuccess ? toAdd.size() : 0);
                if (!addSuccess) {
                    errorGames.add("批量新增失败");
                    result.put("errors", (int) result.get("errors") + 1);
                }
            }

            if (!toUpdate.isEmpty()) {
                boolean updateSuccess = gameCategoryDataService.updateBatchById(toUpdate);
                result.put("updated", updateSuccess ? toUpdate.size() : 0);
                if (!updateSuccess) {
                    errorGames.add("批量更新失败");
                    result.put("errors", (int) result.get("errors") + 1);
                }
            }

            // 4. 处理错误信息
            if (!errorGames.isEmpty()) {
                result.put("errorDetails", errorGames);
            }

            result.put("message", String.format("处理完成: 新增%d/更新%d/错误%d",
                    result.get("added"), result.get("updated"), result.get("errors")));

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
