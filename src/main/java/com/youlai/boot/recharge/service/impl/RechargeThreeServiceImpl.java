package com.youlai.boot.recharge.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.common.base.CommonPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.recharge.mapper.RechargeThreeMapper;
import com.youlai.boot.recharge.service.RechargeThreeService;
import com.youlai.boot.recharge.model.entity.RechargeThree;
import com.youlai.boot.recharge.model.form.RechargeThreeForm;
import com.youlai.boot.recharge.model.query.RechargeThreeQuery;
import com.youlai.boot.recharge.model.vo.RechargeThreeVO;
import com.youlai.boot.recharge.converter.RechargeThreeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 充值三级配置服务实现类
 *
 * @author MrZhang
 * @since 2025-05-29 18:59
 */
@Service
@RequiredArgsConstructor
public class RechargeThreeServiceImpl extends ServiceImpl<RechargeThreeMapper, RechargeThree> implements RechargeThreeService {

    private final RechargeThreeConverter rechargeThreeConverter;

    /**
     * 获取充值三级配置分页列表
     *
     * @param queryParams 查询参数
     * @return {@link Page<RechargeThreeVO>} 充值三级配置分页列表
     */
    @Override
    public Page<RechargeThreeVO> getRechargeThreePage(RechargeThreeQuery queryParams) {
        Page<RechargeThree> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<RechargeThree> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(RechargeThree::getSort);
        if (ObjectUtil.isNotEmpty(queryParams.getStatus())) {
            wrapper.eq(RechargeThree::getStatus, queryParams.getStatus());
        }

        if (ObjectUtil.isNotEmpty(queryParams.getName())) {
            wrapper.like(RechargeThree::getName, queryParams.getName());
        }

        if (ObjectUtil.isNotEmpty(queryParams.getIsHot())) {
            wrapper.eq(RechargeThree::getIsHot, queryParams.getIsHot());
        }

        if (ObjectUtil.isNotEmpty(queryParams.getPid())) {
            wrapper.eq(RechargeThree::getPid, queryParams.getPid());
        }

        if (ObjectUtil.isNotEmpty(queryParams.getAddress())) {
            wrapper.like(RechargeThree::getAddress, queryParams.getAddress());
        }

        if (ObjectUtil.isNotEmpty(queryParams.getBank())) {
            wrapper.like(RechargeThree::getBank, queryParams.getBank());
        }

        if (ObjectUtil.isNotEmpty(queryParams.getCurrency())) {
            wrapper.like(RechargeThree::getCurrency, queryParams.getCurrency());
        }
        Page<RechargeThree> result = baseMapper.selectPage(page, wrapper);
        return CommonPage.copyPageInfo(result, rechargeThreeConverter.toListEntity(result.getRecords()));
    }

    /**
     * 获取充值三级配置表单数据
     *
     * @param id 充值三级配置ID
     * @return 充值三级配置表单数据
     */
    @Override
    public RechargeThreeForm getRechargeThreeFormData(Long id) {
        RechargeThree entity = this.getById(id);
        return rechargeThreeConverter.toForm(entity);
    }

    /**
     * 新增充值三级配置
     *
     * @param formData 充值三级配置表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveRechargeThree(RechargeThreeForm formData) {
        RechargeThree entity = rechargeThreeConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新充值三级配置
     *
     * @param id   充值三级配置ID
     * @param formData 充值三级配置表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateRechargeThree(Long id,RechargeThreeForm formData) {
        RechargeThree entity = rechargeThreeConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除充值三级配置
     *
     * @param ids 充值三级配置ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteRechargeThrees(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的充值三级配置数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
