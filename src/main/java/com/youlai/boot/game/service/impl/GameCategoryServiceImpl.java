package com.youlai.boot.game.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.base.BasePageQuery;
import com.youlai.boot.common.base.CommonPage;
import com.youlai.boot.game.converter.GameCategoryDataConverter;
import com.youlai.boot.game.model.entity.GameCategoryData;
import com.youlai.boot.game.model.entity.GamePlatType;
import com.youlai.boot.game.model.query.GameCategoryDataQuery;
import com.youlai.boot.game.model.vo.GameCategoryDataVO;
import com.youlai.boot.game.model.vo.GameCategoryFrontVO;
import com.youlai.boot.game.model.vo.GameCategoryResultVO;
import com.youlai.boot.game.service.GameCategoryDataService;
import com.youlai.boot.game.service.GamePlatTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.game.mapper.GameCategoryMapper;
import com.youlai.boot.game.service.GameCategoryService;
import com.youlai.boot.game.model.entity.GameCategory;
import com.youlai.boot.game.model.form.GameCategoryForm;
import com.youlai.boot.game.model.query.GameCategoryQuery;
import com.youlai.boot.game.model.vo.GameCategoryVO;
import com.youlai.boot.game.converter.GameCategoryConverter;

import java.util.*;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 游戏分类服务实现类
 *
 * @author MrZhang
 * @since 2025-05-18 16:38
 */
@Service
@RequiredArgsConstructor
public class GameCategoryServiceImpl extends ServiceImpl<GameCategoryMapper, GameCategory> implements GameCategoryService {

    private final GameCategoryConverter gameCategoryConverter;
    private final GameCategoryDataConverter gameCategoryDataConverter;

    @Autowired
    private GameCategoryDataService gameCategoryDataService;
    @Autowired
    private GamePlatTypeService gamePlatTypeService;

    /**
     * 获取游戏分类分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<GameCategoryVO>} 游戏分类分页列表
     */
    @Override
    public Page<GameCategoryVO> getGameCategoryPage(GameCategoryQuery queryParams) {
        LambdaQueryWrapper<GameCategory> wrapper = new LambdaQueryWrapper<>();
        Page<GameCategory> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        wrapper.orderByAsc(GameCategory::getSort);
        if (ObjectUtil.isNotEmpty(queryParams.getStatus())) {
            wrapper.eq(GameCategory::getStatus, queryParams.getStatus());
        }
        Page<GameCategory> gameCategoryPage = baseMapper.selectPage(page, wrapper);
        List<GameCategoryVO> gameCategoryVOList = gameCategoryConverter.toVoList(gameCategoryPage.getRecords());
        return CommonPage.copyPageInfo(page, gameCategoryVOList);
    }

    /**
     * 获取游戏分类表单数据
     *
     * @param id 游戏分类ID
     * @return 游戏分类表单数据
     */
    @Override
    public GameCategoryForm getGameCategoryFormData(Long id) {
        GameCategory entity = this.getById(id);
        return gameCategoryConverter.toForm(entity);
    }

    /**
     * 新增游戏分类
     *
     * @param formData 游戏分类表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveGameCategory(GameCategoryForm formData) {
        GameCategory entity = gameCategoryConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新游戏分类
     *
     * @param id   游戏分类ID
     * @param formData 游戏分类表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateGameCategory(Long id,GameCategoryForm formData) {
        GameCategory entity = gameCategoryConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除游戏分类
     *
     * @param ids 游戏分类ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteGameCategorys(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的游戏分类数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public Page<GameCategoryResultVO> getGameCategoryResultList(BasePageQuery one, BasePageQuery two) {
        // 1. 查询游戏分类页
        GameCategoryQuery gameCategoryQuery = new GameCategoryQuery();
        gameCategoryQuery.setPageNum(one.getPageNum());
        gameCategoryQuery.setPageSize(one.getPageSize());
        gameCategoryQuery.setStatus(true);
        Page<GameCategoryVO> gameCategoryPage = getGameCategoryPage(gameCategoryQuery);

        // 2. 批量预加载所有需要的数据，避免N+1查询问题
        // 预加载热门游戏数据
        List<GameCategoryData> hotGames = gameCategoryDataService.list(
                new LambdaQueryWrapper<GameCategoryData>().eq(GameCategoryData::getIsHot, true)
        );

        // 预加载所有游戏平台类型数据
        List<GamePlatType> allGamePlatTypes = gamePlatTypeService.list();

        // 3. 转换结果并处理数据
        List<GameCategoryResultVO> resultVoList = gameCategoryPage.getRecords().stream()
                .map(category -> {
                    GameCategoryResultVO vo = gameCategoryConverter.toResultVo(category);

                    if ("热门".equals(category.getTitle())) {
                        vo.setGameCategoryData(gameCategoryDataConverter.toVoList(hotGames));
                    } else {
                        // 使用预加载的数据进行过滤
                        List<GamePlatType> matchedTypes = allGamePlatTypes.stream()
                                .filter(type -> type.getGameType() != null && type.getGameType().equals(category.getId()))
                                .collect(Collectors.toList());
                        vo.setGamePlatType(matchedTypes);
                    }

                    return vo;
                })
                .collect(Collectors.toList());

        return CommonPage.copyPageInfo(gameCategoryPage, resultVoList);
    }

    @Override
    public List<Map<String, Object>> getOptions() {
        LambdaQueryWrapper<GameCategory> wrapper = new LambdaQueryWrapper<>();
        List<GameCategory> list = baseMapper.selectList(wrapper);
        ArrayList<Map<String, Object>> objects = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(list)) {
            list.forEach(rechargeCategory -> {
                HashMap<String, Object> map = new HashMap<>();
                map.put("label", rechargeCategory.getTitle());
                map.put("value", rechargeCategory.getId().intValue());
                objects.add(map);
            });
        }
        return objects;
    }

    @Override
    public GameCategoryFrontVO getGameCategoryById(Long id) {
        GameCategory gameCategory = baseMapper.selectById(id);
        LambdaQueryWrapper<GamePlatType> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GamePlatType::getGameType, gameCategory.getId());
        wrapper.orderByAsc(GamePlatType::getSort);
        List<GamePlatType> list = gamePlatTypeService.list(wrapper);
        GameCategoryFrontVO frontVo = gameCategoryConverter.toFrontVo(gameCategory);
        frontVo.setGamePlatTypes(list);
        return frontVo;
    }

}
