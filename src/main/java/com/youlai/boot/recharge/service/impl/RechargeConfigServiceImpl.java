package com.youlai.boot.recharge.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.base.CommonPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.recharge.mapper.RechargeConfigMapper;
import com.youlai.boot.recharge.service.RechargeConfigService;
import com.youlai.boot.recharge.model.entity.RechargeConfig;
import com.youlai.boot.recharge.model.form.RechargeConfigForm;
import com.youlai.boot.recharge.model.query.RechargeConfigQuery;
import com.youlai.boot.recharge.model.vo.RechargeConfigVO;
import com.youlai.boot.recharge.converter.RechargeConfigConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 充值分类子配置服务实现类
 *
 * @author MrZhang
 * @since 2025-05-29 00:36
 */
@Service
@RequiredArgsConstructor
public class RechargeConfigServiceImpl extends ServiceImpl<RechargeConfigMapper, RechargeConfig> implements RechargeConfigService {

    private final RechargeConfigConverter rechargeConfigConverter;

    /**
     * 获取充值分类子配置分页列表
     *
     * @param queryParams 查询参数
     * @return {@link Page<RechargeConfigVO>} 充值分类子配置分页列表
     */
    @Override
    public Page<RechargeConfigVO> getRechargeConfigPage(RechargeConfigQuery queryParams) {
        Page<RechargeConfig> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<RechargeConfig> wrapper = new LambdaQueryWrapper<>();
        if (ObjectUtil.isNotEmpty(queryParams.getName())) {
            wrapper.like(RechargeConfig::getName, queryParams.getName());
        }
        if (ObjectUtil.isNotEmpty(queryParams.getStatus())) {
            wrapper.eq(RechargeConfig::getStatus, queryParams.getStatus());
        }
        if (ObjectUtil.isNotEmpty(queryParams.getPid())) {
            wrapper.eq(RechargeConfig::getPid, queryParams.getPid());
        }
        if (ObjectUtil.isNotEmpty(queryParams.getIsHot())) {
            wrapper.eq(RechargeConfig::getIsHot, queryParams.getIsHot());
        }
        wrapper.orderByAsc(RechargeConfig::getSort);
        Page<RechargeConfig> pageVO = baseMapper.selectPage(page, wrapper);
        return CommonPage.copyPageInfo(pageVO, rechargeConfigConverter.toVOList(pageVO.getRecords()));
    }

    /**
     * 获取充值分类子配置表单数据
     *
     * @param id 充值分类子配置ID
     * @return 充值分类子配置表单数据
     */
    @Override
    public RechargeConfigForm getRechargeConfigFormData(Long id) {
        RechargeConfig entity = this.getById(id);
        return rechargeConfigConverter.toForm(entity);
    }

    /**
     * 新增充值分类子配置
     *
     * @param formData 充值分类子配置表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveRechargeConfig(RechargeConfigForm formData) {
        RechargeConfig entity = rechargeConfigConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新充值分类子配置
     *
     * @param id   充值分类子配置ID
     * @param formData 充值分类子配置表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateRechargeConfig(Long id,RechargeConfigForm formData) {
        RechargeConfig entity = rechargeConfigConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除充值分类子配置
     *
     * @param ids 充值分类子配置ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteRechargeConfigs(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的充值分类子配置数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
