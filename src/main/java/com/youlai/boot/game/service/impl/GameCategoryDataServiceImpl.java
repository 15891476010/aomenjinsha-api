package com.youlai.boot.game.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.base.CommonPage;
import com.youlai.boot.game.model.query.GameCategoryDataFrontQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.game.mapper.GameCategoryDataMapper;
import com.youlai.boot.game.service.GameCategoryDataService;
import com.youlai.boot.game.model.entity.GameCategoryData;
import com.youlai.boot.game.model.form.GameCategoryDataForm;
import com.youlai.boot.game.model.query.GameCategoryDataQuery;
import com.youlai.boot.game.model.vo.GameCategoryDataVO;
import com.youlai.boot.game.converter.GameCategoryDataConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 游戏列服务实现类
 *
 * @author MrZhang
 * @since 2025-05-18 19:33
 */
@Service
@RequiredArgsConstructor
public class GameCategoryDataServiceImpl extends ServiceImpl<GameCategoryDataMapper, GameCategoryData> implements GameCategoryDataService {

    private final GameCategoryDataConverter gameCategoryDataConverter;

    /**
     * 获取游戏列分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<GameCategoryDataVO>} 游戏列分页列表
     */
    @Override
    public Page<GameCategoryDataVO> getGameCategoryDataPage(GameCategoryDataQuery queryParams) {
        LambdaQueryWrapper<GameCategoryData> wrapper = new LambdaQueryWrapper<>();
        Page<GameCategoryData> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        wrapper.eq(GameCategoryData::getPid, queryParams.getPid());
        if (ObjectUtil.isNotEmpty(queryParams.getTitle())) {
            wrapper.like(GameCategoryData::getTitle, queryParams.getTitle());
        }
        wrapper.orderByAsc(GameCategoryData::getSort);
        if (ObjectUtil.isNotEmpty(queryParams.getStatus())) {
            wrapper.eq(GameCategoryData::getStatus, queryParams.getStatus());
        }

        if (ObjectUtil.isNotEmpty(queryParams.getProvider())) {
            wrapper.eq(GameCategoryData::getProvider, queryParams.getProvider());
        }
        Page<GameCategoryData> pageVO = baseMapper.selectPage(page, wrapper);
        List<GameCategoryDataVO> voList = gameCategoryDataConverter.toVoList(pageVO.getRecords());
        return CommonPage.copyPageInfo(pageVO, voList);
    }

    /**
     * 获取游戏列表单数据
     *
     * @param id 游戏列ID
     * @return 游戏列表单数据
     */
    @Override
    public GameCategoryDataForm getGameCategoryDataFormData(Long id) {
        GameCategoryData entity = this.getById(id);
        return gameCategoryDataConverter.toForm(entity);
    }

    /**
     * 新增游戏列
     *
     * @param formData 游戏列表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveGameCategoryData(GameCategoryDataForm formData) {
        GameCategoryData entity = gameCategoryDataConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新游戏列
     *
     * @param id   游戏列ID
     * @param formData 游戏列表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateGameCategoryData(Long id,GameCategoryDataForm formData) {
        GameCategoryData entity = gameCategoryDataConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除游戏列
     *
     * @param ids 游戏列ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteGameCategoryDatas(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的游戏列数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public Page<GameCategoryDataVO> getGameCategoryDataPageByPlatType(GameCategoryDataFrontQuery queryParams) {
        LambdaQueryWrapper<GameCategoryData> wrapper = new LambdaQueryWrapper<>();
        if (ObjectUtil.isNotEmpty(queryParams.getTitle())) {
            wrapper.like(GameCategoryData::getTitle, queryParams.getTitle());
        }
        wrapper.eq(GameCategoryData::getPid, queryParams.getCategoryId());
        if (ObjectUtil.isNotEmpty(queryParams.getPlatType())) {
            wrapper.eq(GameCategoryData::getPlatType, queryParams.getPlatType());
        }
        wrapper.eq(GameCategoryData::getStatus, true);
        wrapper.orderByAsc(GameCategoryData::getSort);
        Page<GameCategoryData> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        Page<GameCategoryData> pageVO = baseMapper.selectPage(page, wrapper);
        List<GameCategoryDataVO> voList = gameCategoryDataConverter.toVoList(pageVO.getRecords());
        return CommonPage.copyPageInfo(pageVO, voList);
    }

}
