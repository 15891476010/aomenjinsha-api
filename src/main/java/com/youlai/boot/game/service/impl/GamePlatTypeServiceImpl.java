package com.youlai.boot.game.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.base.CommonPage;
import com.youlai.boot.game.mapper.GameCategoryMapper;
import com.youlai.boot.game.model.entity.GameCategory;
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
        Map<String, Object> gameList = msGameApiService.getGameList(platType);
        if ((int) gameList.get("Code") == 0) {
            Map<String, Object> data = (Map<String, Object>) gameList.get("Data");
            System.out.println(data);
        }
        return null;
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
