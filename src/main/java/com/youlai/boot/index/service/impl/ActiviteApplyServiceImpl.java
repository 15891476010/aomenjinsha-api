package com.youlai.boot.index.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.common.base.CommonPage;
import com.youlai.boot.common.exception.UsdtException;
import com.youlai.boot.core.security.util.SecurityUtils;
import com.youlai.boot.index.service.ActiviteService;
import com.youlai.boot.index.service.EbUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.index.mapper.ActiviteApplyMapper;
import com.youlai.boot.index.service.ActiviteApplyService;
import com.youlai.boot.index.model.entity.ActiviteApply;
import com.youlai.boot.index.model.form.ActiviteApplyForm;
import com.youlai.boot.index.model.query.ActiviteApplyQuery;
import com.youlai.boot.index.model.vo.ActiviteApplyVO;
import com.youlai.boot.index.converter.ActiviteApplyConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 用户活动申请服务实现类
 *
 * @author MrZhang
 * @since 2025-06-07 15:34
 */
@Service
@RequiredArgsConstructor
public class ActiviteApplyServiceImpl extends ServiceImpl<ActiviteApplyMapper, ActiviteApply> implements ActiviteApplyService {

    private final ActiviteApplyConverter activiteApplyConverter;
    private final EbUserService ebUserService;
    private final ActiviteService activiteService;

    /**
     * 获取用户活动申请分页列表
     *
     * @param queryParams 查询参数
     * @return {@link Page<ActiviteApplyVO>} 用户活动申请分页列表
     */
    @Override
    public Page<ActiviteApplyVO> getActiviteApplyPage(ActiviteApplyQuery queryParams) {
        Page<ActiviteApply> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<ActiviteApply> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(ActiviteApply::getSort);
        if (ObjectUtil.isNotEmpty(queryParams.getStatus())) {
            wrapper.eq(ActiviteApply::getStatus, queryParams.getStatus());
        }
        Page<ActiviteApply> result = baseMapper.selectPage(page, wrapper);
        List<ActiviteApplyVO> listEntity = activiteApplyConverter.toListEntity(result.getRecords());
        listEntity.forEach(item -> {
            item.setUsername(ebUserService.getById(item.getUserId()).getUsername());
            item.setActiviteName(activiteService.getById(item.getActiviteId()).getTitle());
        });
        return CommonPage.copyPageInfo(result, listEntity);
    }

    /**
     * 获取用户活动申请表单数据
     *
     * @param id 用户活动申请ID
     * @return 用户活动申请表单数据
     */
    @Override
    public ActiviteApplyForm getActiviteApplyFormData(Long id) {
        ActiviteApply entity = this.getById(id);
        return activiteApplyConverter.toForm(entity);
    }

    /**
     * 新增用户活动申请
     *
     * @param formData 用户活动申请表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveActiviteApply(ActiviteApplyForm formData) {
        ActiviteApply entity = activiteApplyConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新用户活动申请
     *
     * @param id   用户活动申请ID
     * @param formData 用户活动申请表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateActiviteApply(Long id,ActiviteApplyForm formData) {
        ActiviteApply entity = activiteApplyConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除用户活动申请
     *
     * @param ids 用户活动申请ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteActiviteApplys(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的用户活动申请数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public boolean applyActivite(Integer activiteId) {
        Long frontUserId = SecurityUtils.getFrontUserId();
        LambdaQueryWrapper<ActiviteApply> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ActiviteApply::getActiviteId, activiteId);
        wrapper.eq(ActiviteApply::getUserId, frontUserId);
        if (this.count(wrapper) > 0) {
            throw new UsdtException("您已申请过该活动");
        }
        ActiviteApply activiteApply = new ActiviteApply();
        activiteApply.setActiviteId(activiteId);
        activiteApply.setUserId(Math.toIntExact(frontUserId));
        return this.save(activiteApply);
    }

}
