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
import com.youlai.boot.recharge.mapper.RechargeListMapper;
import com.youlai.boot.recharge.service.RechargeListService;
import com.youlai.boot.recharge.model.entity.RechargeList;
import com.youlai.boot.recharge.model.form.RechargeListForm;
import com.youlai.boot.recharge.model.query.RechargeListQuery;
import com.youlai.boot.recharge.model.vo.RechargeListVO;
import com.youlai.boot.recharge.converter.RechargeListConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 用户充值列表服务实现类
 *
 * @author MrZhang
 * @since 2025-06-01 19:49
 */
@Service
@RequiredArgsConstructor
public class RechargeListServiceImpl extends ServiceImpl<RechargeListMapper, RechargeList> implements RechargeListService {

    private final RechargeListConverter rechargeListConverter;

    /**
     * 获取用户充值列表分页列表
     *
     * @param queryParams 查询参数
     * @return {@link Page<RechargeListVO>} 用户充值列表分页列表
     */
    @Override
    public Page<RechargeListVO> getRechargeListPage(RechargeListQuery queryParams) {
        Page<RechargeList> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<RechargeList> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(RechargeList::getSort);
        if (ObjectUtil.isNotEmpty(queryParams.getStatus())) {
            wrapper.eq(RechargeList::getStatus, queryParams.getStatus());
        }

        if (ObjectUtil.isNotEmpty(queryParams.getCurrency())) {
             wrapper.eq(RechargeList::getCurrency, queryParams.getCurrency());
        }
         if (ObjectUtil.isNotEmpty(queryParams.getName())) {
              wrapper.like(RechargeList::getName, queryParams.getName());
        }
        Page<RechargeList> result = baseMapper.selectPage(page, wrapper);
        return CommonPage.copyPageInfo(result, rechargeListConverter.toListEntity(result.getRecords()));
    }

    /**
     * 获取用户充值列表表单数据
     *
     * @param id 用户充值列表ID
     * @return 用户充值列表表单数据
     */
    @Override
    public RechargeListForm getRechargeListFormData(Long id) {
        RechargeList entity = this.getById(id);
        return rechargeListConverter.toForm(entity);
    }

    /**
     * 新增用户充值列表
     *
     * @param formData 用户充值列表表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveRechargeList(RechargeListForm formData) {
        RechargeList entity = rechargeListConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新用户充值列表
     *
     * @param id   用户充值列表ID
     * @param formData 用户充值列表表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateRechargeList(Long id,RechargeListForm formData) {
        RechargeList entity = rechargeListConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除用户充值列表
     *
     * @param ids 用户充值列表ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteRechargeLists(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的用户充值列表数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
