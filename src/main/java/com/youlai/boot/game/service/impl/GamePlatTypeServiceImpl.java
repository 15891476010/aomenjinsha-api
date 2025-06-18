package com.youlai.boot.game.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.youlai.boot.common.base.CommonPage;
import com.youlai.boot.common.constant.SysGroupConstants;
import com.youlai.boot.game.mapper.GameCategoryMapper;
import com.youlai.boot.game.model.entity.GameCategory;
import com.youlai.boot.game.model.entity.GameCategoryData;
import com.youlai.boot.game.model.vo.GamePlatTypeFrontVO;
import com.youlai.boot.game.service.GameCategoryDataService;
import com.youlai.boot.game.service.GameCategoryService;
import com.youlai.boot.service.NewNgApiService;
import com.youlai.boot.system.service.SysGroupDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
    private final NewNgApiService newNgApiService;
    private final GameCategoryDataService gameCategoryDataService;
    private final GameCategoryMapper gameCategoryMapper;
    private final SysGroupDataService sysGroupDataService;

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

        if (ObjectUtil.isNotEmpty(queryParams.getCurrencys())) {
            wrapper.like(GamePlatType::getCurrencys, queryParams.getCurrencys());
        }
        if (ObjectUtil.isNotEmpty(queryParams.getGameType())) {
            wrapper.like(GamePlatType::getGameType, queryParams.getGameType());
        }
        Page<GamePlatType> result = baseMapper.selectPage(page, wrapper);
        return CommonPage.copyPageInfo(result, gamePlatTypeConverter.toListEntity(result.getRecords()));
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
        Map<String, Object> response = newNgApiService.gamecode(platType);
        // 2. 解析响应数据
        if (response == null || (Integer) response.get("code") != 10000) {
            return new HashMap<String, Object>();
        }

        List<Map<String, Object>> gameList = (List<Map<String, Object>>) response.get("data");
        if (CollectionUtils.isEmpty(gameList)) {
            return new HashMap<String, Object>();
        }

        // 查询游戏分类列表
        List<GameCategory> gameCategoryList = gameCategoryMapper.selectList(new LambdaQueryWrapper<>());

        List<HashMap<String, Object>> listMapByGid = sysGroupDataService.getListMapByGid(SysGroupConstants.GROUP_ID_ADMIN_PROVIDER_LIST);

        // 3. 转换为实体列表
        List<GameCategoryData> entities = new ArrayList<>();
        listMapByGid.forEach(map -> {
            if (map.get("provider").toString().contains("NG")) {
                for (Map<String, Object> game : gameList) {
                    String currentPlatType = (String) game.get("platType");
                    String currentGameCode = (String) game.get("gameCode");

                    // 根据platType和gameCode查询是否已存在记录
                    LambdaQueryWrapper<GameCategoryData> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.eq(GameCategoryData::getPlatType, currentPlatType)
                            .eq(GameCategoryData::getGameCode, currentGameCode);
                    GameCategoryData existingEntity = gameCategoryDataService.getOne(queryWrapper);

                    // 如果记录已存在，则更新；否则新建
                    GameCategoryData entity = existingEntity != null ? existingEntity : new GameCategoryData();

                    // 设置平台类型
                    entity.setPlatType(currentPlatType);
                    entity.setTag(currentPlatType.toUpperCase());
                    entity.setGameCode(currentGameCode);
                    entity.setIngress(Integer.parseInt((String) game.get("ingress")));

                    // 设置多语言名称
                    Map<String, String> nameMap = (Map<String, String>) game.get("gameName");
                    if (nameMap != null) {
                        if (ObjectUtil.isNotEmpty(nameMap.get("zh-hans"))) {
                            entity.setTitle(nameMap.get("zh-hans"));
                        }
                        if (ObjectUtil.isNotEmpty(nameMap.get("en"))) {
                            entity.setEn(nameMap.get("en"));
                        }
                        if (ObjectUtil.isNotEmpty(nameMap.get("zh-hant"))) {
                            entity.setZhHant(nameMap.get("zh-hant"));
                        }
                    }

                    gameCategoryList.forEach(gameCategory -> {
                        if (gameCategory.getGameType().equals(game.get("gameType"))) {
                            entity.setPid(Math.toIntExact(gameCategory.getId()));
                        }
                    });

                    entity.setProvider(map.get("MerchantID").toString());
                    entities.add(entity);
                }
            }
        });

        // 批量保存或更新
        gameCategoryDataService.saveOrUpdateBatch(entities);
        return null;
    }

    @Override
    public List<GamePlatTypeFrontVO> getGamePlatTypeList(Long id) {
        GameCategory gameCategory = gameCategoryMapper.selectById(id);
        if (gameCategory == null) {
            return Collections.emptyList();
        }

        LambdaQueryWrapper<GamePlatType> wrapper = new LambdaQueryWrapper<>();
        // 使用MyBatis-Plus的JSON查询条件
        wrapper.apply("JSON_CONTAINS(game_type, CAST({0} AS JSON))", gameCategory.getId());

        List<GamePlatType> gamePlatTypes = baseMapper.selectList(wrapper);
        List<GamePlatTypeFrontVO> frontListEntity = gamePlatTypeConverter.toFrontListEntity(gamePlatTypes);
        frontListEntity.forEach(front -> {
            front.setCategoryName(gameCategory.getTitle());
        });
        return frontListEntity;
    }

}
