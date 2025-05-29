package com.youlai.boot.recharge.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.common.base.CommonPage;
import com.youlai.boot.recharge.model.entity.RechargeCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.recharge.mapper.RechargeSecondMapper;
import com.youlai.boot.recharge.service.RechargeSecondService;
import com.youlai.boot.recharge.model.entity.RechargeSecond;
import com.youlai.boot.recharge.model.form.RechargeSecondForm;
import com.youlai.boot.recharge.model.query.RechargeSecondQuery;
import com.youlai.boot.recharge.model.vo.RechargeSecondVO;
import com.youlai.boot.recharge.converter.RechargeSecondConverter;

import java.util.*;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 充值分类子配置服务实现类
 *
 * @author MrZhang
 * @since 2025-05-29 13:32
 */
@Service
@RequiredArgsConstructor
public class RechargeSecondServiceImpl extends ServiceImpl<RechargeSecondMapper, RechargeSecond> implements RechargeSecondService {

    private final RechargeSecondConverter rechargeSecondConverter;

    /**
     * 获取充值分类子配置分页列表
     *
     * @param queryParams 查询参数
     * @return {@link Page<RechargeSecondVO>} 充值分类子配置分页列表
     */
    @Override
    public Page<RechargeSecondVO> getRechargeSecondPage(RechargeSecondQuery queryParams) {
        Page<RechargeSecond> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<RechargeSecond> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(RechargeSecond::getSort);
        if (ObjectUtil.isNotEmpty(queryParams.getStatus())) {
            wrapper.eq(RechargeSecond::getStatus, queryParams.getStatus());
        }
        Page<RechargeSecond> result = baseMapper.selectPage(page, wrapper);
        return CommonPage.copyPageInfo(result, rechargeSecondConverter.toListEntity(result.getRecords()));
    }

    /**
     * 获取充值分类子配置表单数据
     *
     * @param id 充值分类子配置ID
     * @return 充值分类子配置表单数据
     */
    @Override
    public RechargeSecondForm getRechargeSecondFormData(Long id) {
        RechargeSecond entity = this.getById(id);
        return rechargeSecondConverter.toForm(entity);
    }

    /**
     * 新增充值分类子配置
     *
     * @param formData 充值分类子配置表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveRechargeSecond(RechargeSecondForm formData) {
        RechargeSecond entity = rechargeSecondConverter.toEntity(formData);
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
    public boolean updateRechargeSecond(Long id,RechargeSecondForm formData) {
        RechargeSecond entity = rechargeSecondConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除充值分类子配置
     *
     * @param ids 充值分类子配置ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteRechargeSeconds(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的充值分类子配置数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<Map<String, Object>> getOptions() {
        LambdaQueryWrapper<RechargeSecond> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RechargeSecond::getStatus, true);
        List<RechargeSecond> list = baseMapper.selectList(wrapper);
        ArrayList<Map<String, Object>> objects = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(list)) {
            list.forEach(rechargeCategory -> {
                HashMap<String, Object> map = new HashMap<>();
                map.put("label", rechargeCategory.getName());
                map.put("value", rechargeCategory.getId().intValue());
                objects.add(map);
            });
        }
        return objects;
    }

}
