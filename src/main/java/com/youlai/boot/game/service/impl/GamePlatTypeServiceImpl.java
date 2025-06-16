package com.youlai.boot.game.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.common.base.CommonPage;
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

import java.util.Arrays;
import java.util.List;
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

}
