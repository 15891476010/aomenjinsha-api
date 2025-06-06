package com.youlai.boot.game.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.base.BasePageQuery;
import com.youlai.boot.common.base.CommonPage;
import com.youlai.boot.game.model.query.GameCategoryDataQuery;
import com.youlai.boot.game.model.vo.GameCategoryDataVO;
import com.youlai.boot.game.model.vo.GameCategoryResultVO;
import com.youlai.boot.game.service.GameCategoryDataService;
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

    @Autowired
    private GameCategoryDataService gameCategoryDataService;

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
        GameCategoryQuery gameCategoryQuery = new GameCategoryQuery();
        gameCategoryQuery.setPageNum(one.getPageNum());
        gameCategoryQuery.setPageSize(one.getPageSize());
        gameCategoryQuery.setStatus(true);
        Page<GameCategoryVO> gameCategoryPage = getGameCategoryPage(gameCategoryQuery);


        GameCategoryDataQuery gameCategoryDataQuery = new GameCategoryDataQuery();
        gameCategoryDataQuery.setPageNum(two.getPageNum());
        gameCategoryDataQuery.setPageSize(two.getPageSize());

        List<GameCategoryResultVO> resultVoList = gameCategoryConverter.toResultVoList(gameCategoryPage.getRecords());

        List<GameCategoryDataVO> objects = new ArrayList<>();
        resultVoList.forEach(item -> {
            gameCategoryDataQuery.setPid(item.getId());
            Page<GameCategoryDataVO> gameCategoryDataPage = gameCategoryDataService.getGameCategoryDataPage(gameCategoryDataQuery);
            item.setGameCategoryData(gameCategoryDataPage.getRecords());
            gameCategoryDataPage.getRecords().forEach(data -> {
                if (data.getIsHot()) {
                    objects.add(data);
                }
            });
        });
        for (GameCategoryResultVO gameCategoryResultVO : resultVoList) {
            if (Objects.equals(gameCategoryResultVO.getTitle(), "热门")) {
                Collections.reverse(objects);
                gameCategoryResultVO.setGameCategoryData(objects);
            }
        }
        return CommonPage.copyPageInfo(gameCategoryPage, resultVoList);
    }

}
