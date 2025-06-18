package com.youlai.boot.index.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.common.base.CommonPage;
import com.youlai.boot.game.mapper.GameCategoryDataMapper;
import com.youlai.boot.game.model.entity.GameCategoryData;
import com.youlai.boot.game.service.GameCategoryDataService;
import com.youlai.boot.index.mapper.EbUserMapper;
import com.youlai.boot.index.model.entity.EbUser;
import com.youlai.boot.index.service.EbUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.index.mapper.UserTransferMapper;
import com.youlai.boot.index.service.UserTransferService;
import com.youlai.boot.index.model.entity.UserTransfer;
import com.youlai.boot.index.model.form.UserTransferForm;
import com.youlai.boot.index.model.query.UserTransferQuery;
import com.youlai.boot.index.model.vo.UserTransferVO;
import com.youlai.boot.index.converter.UserTransferConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 玩家投注表服务实现类
 *
 * @author MrZhang
 * @since 2025-05-30 12:33
 */
@Service
@RequiredArgsConstructor
public class UserTransferServiceImpl extends ServiceImpl<UserTransferMapper, UserTransfer> implements UserTransferService {

    private final UserTransferConverter userTransferConverter;

    @Autowired
    private EbUserMapper ebUserMapper;
    @Autowired
    private GameCategoryDataMapper gameCategoryDataMapper;

    /**
     * 获取玩家投注表分页列表
     *
     * @param queryParams 查询参数
     * @return {@link Page<UserTransferVO>} 玩家投注表分页列表
     */
    @Override
    public Page<UserTransferVO> getUserTransferPage(UserTransferQuery queryParams) {
        Page<UserTransfer> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<UserTransfer> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(UserTransfer::getId);
        Page<UserTransfer> result = baseMapper.selectPage(page, wrapper);
        List<UserTransferVO> listEntity = userTransferConverter.toListEntity(result.getRecords());
        LambdaQueryWrapper<GameCategoryData> wrapper1 = new LambdaQueryWrapper<>();
        listEntity.forEach(item -> {
            if  (ObjectUtil.isNull(item.getPlayerId())) {
                item.setUsername("未知");
            } else {
                EbUser user = ebUserMapper.selectById(item.getPlayerId());
                if  (ObjectUtil.isNull(user)) {
                    item.setUsername("未知");
                } else {
                    item.setUsername(user.getUsername());
                }
            }
            wrapper1.eq(GameCategoryData::getTargetUrl, item.getGid());
            List<GameCategoryData> gameCategoryData = gameCategoryDataMapper.selectList(wrapper1);
            // 取第一个作为游戏名称
            if (!gameCategoryData.isEmpty()) {
                 item.setGameName(gameCategoryData.get(0).getTitle());
            } else {
                 item.setGameName("未知");
            }
        });
        return CommonPage.copyPageInfo(result, listEntity);
    }

    /**
     * 新增玩家投注表
     *
     * @param formData 玩家投注表表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveUserTransfer(UserTransferForm formData) {
        UserTransfer entity = userTransferConverter.toEntity(formData);
        return this.save(entity);
    }


}
