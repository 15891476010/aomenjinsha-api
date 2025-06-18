package com.youlai.boot.index.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.common.base.CommonPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.index.mapper.ActiviteMapper;
import com.youlai.boot.index.service.ActiviteService;
import com.youlai.boot.index.model.entity.Activite;
import com.youlai.boot.index.model.form.ActiviteForm;
import com.youlai.boot.index.model.query.ActiviteQuery;
import com.youlai.boot.index.model.vo.ActiviteVO;
import com.youlai.boot.index.converter.ActiviteConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 活动表服务实现类
 *
 * @author MrZhang
 * @since 2025-06-06 21:09
 */
@Service
@RequiredArgsConstructor
public class ActiviteServiceImpl extends ServiceImpl<ActiviteMapper, Activite> implements ActiviteService {

    private final ActiviteConverter activiteConverter;

    /**
     * 获取活动表分页列表
     *
     * @param queryParams 查询参数
     * @return {@link Page<ActiviteVO>} 活动表分页列表
     */
    @Override
    public Page<ActiviteVO> getActivitePage(ActiviteQuery queryParams) {
        Page<Activite> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<Activite> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(Activite::getSort);
        if (ObjectUtil.isNotEmpty(queryParams.getStatus())) {
            wrapper.eq(Activite::getStatus, queryParams.getStatus());
        }
        if (ObjectUtil.isNotEmpty(queryParams.getCanApply())) {
            wrapper.eq(Activite::getCanApply, queryParams.getCanApply());
        }
        if (ObjectUtil.isNotEmpty(queryParams.getTitle())) {
            wrapper.like(Activite::getTitle, queryParams.getTitle());
        }
        if (ObjectUtil.isNotEmpty(queryParams.getPid())) {
            wrapper.eq(Activite::getPid, queryParams.getPid());
        }
        Page<Activite> result = baseMapper.selectPage(page, wrapper);
        return CommonPage.copyPageInfo(result, activiteConverter.toListEntity(result.getRecords()));
    }

    /**
     * 获取活动表表单数据
     *
     * @param id 活动表ID
     * @return 活动表表单数据
     */
    @Override
    public ActiviteForm getActiviteFormData(Long id) {
        Activite entity = this.getById(id);
        return activiteConverter.toForm(entity);
    }

    /**
     * 新增活动表
     *
     * @param formData 活动表表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveActivite(ActiviteForm formData) {
        Activite entity = activiteConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新活动表
     *
     * @param id   活动表ID
     * @param formData 活动表表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateActivite(Long id,ActiviteForm formData) {
        Activite entity = activiteConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除活动表
     *
     * @param ids 活动表ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteActivites(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的活动表数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<ActiviteVO> getActiviteList(ActiviteQuery queryParams) {
        LambdaQueryWrapper<Activite> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(Activite::getSort);
        if (ObjectUtil.isNotEmpty(queryParams.getStatus())) {
            wrapper.eq(Activite::getStatus, true);
        }
        if (ObjectUtil.isNotEmpty(queryParams.getPid()) && queryParams.getPid() != 0) {
            wrapper.eq(Activite::getPid, queryParams.getPid());
        }
        List<Activite> activites = baseMapper.selectList(wrapper);
        return activiteConverter.toListEntity(activites);
    }

}
