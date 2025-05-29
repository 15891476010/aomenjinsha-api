package com.youlai.boot.recharge.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.base.CommonPage;
import com.youlai.boot.recharge.converter.RechargeConfigConverter;
import com.youlai.boot.recharge.converter.RechargeSecondConverter;
import com.youlai.boot.recharge.converter.RechargeThreeConverter;
import com.youlai.boot.recharge.mapper.RechargeConfigMapper;
import com.youlai.boot.recharge.mapper.RechargeSecondMapper;
import com.youlai.boot.recharge.mapper.RechargeThreeMapper;
import com.youlai.boot.recharge.model.entity.RechargeConfig;
import com.youlai.boot.recharge.model.entity.RechargeSecond;
import com.youlai.boot.recharge.model.entity.RechargeThree;
import com.youlai.boot.recharge.model.vo.RechargeConfigVO;
import com.youlai.boot.recharge.model.vo.RechargeSecondVO;
import com.youlai.boot.recharge.model.vo.RechargeThreeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.recharge.mapper.RechargeCategoryMapper;
import com.youlai.boot.recharge.service.RechargeCategoryService;
import com.youlai.boot.recharge.model.entity.RechargeCategory;
import com.youlai.boot.recharge.model.form.RechargeCategoryForm;
import com.youlai.boot.recharge.model.query.RechargeCategoryQuery;
import com.youlai.boot.recharge.model.vo.RechargeCategoryVO;
import com.youlai.boot.recharge.converter.RechargeCategoryConverter;

import java.util.*;


import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 充值分类服务实现类
 *
 * @author MrZhang
 * @since 2025-05-29 00:00
 */
@Service
@RequiredArgsConstructor
public class RechargeCategoryServiceImpl extends ServiceImpl<RechargeCategoryMapper, RechargeCategory> implements RechargeCategoryService {

    private final RechargeCategoryConverter rechargeCategoryConverter;

    @Autowired
    private RechargeConfigMapper RechargeConfigMapper;
    @Autowired
    private RechargeConfigConverter rechargeConfigConverter;

    @Autowired
    private RechargeSecondMapper RechargeSecondMapper;
    @Autowired
    private RechargeSecondConverter rechargeSecondConverter;

    @Autowired
    private RechargeThreeMapper RechargeThreeMapper;
    private final RechargeThreeConverter rechargeThreeConverter;

    /**
     * 获取充值分类分页列表
     *
     * @param queryParams 查询参数
     * @return {@link Page<RechargeCategoryVO>} 充值分类分页列表
     */
    @Override
    public Page<RechargeCategoryVO> getRechargeCategoryPage(RechargeCategoryQuery queryParams) {
        Page<RechargeCategory> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<RechargeCategory> wrapper = new LambdaQueryWrapper<>();
        if (ObjectUtil.isNotEmpty(queryParams.getName())) {
            wrapper.like(RechargeCategory::getName, queryParams.getName());
        }
        if (ObjectUtil.isNotEmpty(queryParams.getStatus())) {
            wrapper.eq(RechargeCategory::getStatus, queryParams.getStatus());
        }
        wrapper.orderByAsc(RechargeCategory::getSort);
        Page<RechargeCategory> pageVO = baseMapper.selectPage(page, wrapper);
        return CommonPage.copyPageInfo(pageVO, rechargeCategoryConverter.toVOList(pageVO.getRecords()));
    }

    /**
     * 获取充值分类表单数据
     *
     * @param id 充值分类ID
     * @return 充值分类表单数据
     */
    @Override
    public RechargeCategoryForm getRechargeCategoryFormData(Long id) {
        RechargeCategory entity = this.getById(id);
        return rechargeCategoryConverter.toForm(entity);
    }

    /**
     * 新增充值分类
     *
     * @param formData 充值分类表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveRechargeCategory(RechargeCategoryForm formData) {
        RechargeCategory entity = rechargeCategoryConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新充值分类
     *
     * @param id   充值分类ID
     * @param formData 充值分类表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateRechargeCategory(Long id,RechargeCategoryForm formData) {
        RechargeCategory entity = rechargeCategoryConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除充值分类
     *
     * @param ids 充值分类ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteRechargeCategorys(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的充值分类数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<Map<String, Object>> getRechargeCategoryOptions() {
        LambdaQueryWrapper<RechargeCategory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RechargeCategory::getStatus, 1);
        List<RechargeCategory> list = baseMapper.selectList(wrapper);
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

    @Override
    public List<RechargeCategoryVO> getRechargeCategoryList() {
        // 查询一级分类
        LambdaQueryWrapper<RechargeCategory> categoryWrapper = new LambdaQueryWrapper<>();
        categoryWrapper.eq(RechargeCategory::getStatus, true)
                      .orderByAsc(RechargeCategory::getSort);
        List<RechargeCategory> rechargeCategories = baseMapper.selectList(categoryWrapper);
        List<RechargeCategoryVO> voList = rechargeCategoryConverter.toVOList(rechargeCategories);

        for (RechargeCategoryVO categoryVO : voList) {
            // 查询二级配置
            LambdaQueryWrapper<RechargeConfig> configWrapper = new LambdaQueryWrapper<>();
            configWrapper.eq(RechargeConfig::getPid, categoryVO.getId())
                         .eq(RechargeConfig::getStatus, true)
                         .orderByAsc(RechargeConfig::getSort);
            List<RechargeConfig> rechargeConfigs = RechargeConfigMapper.selectList(configWrapper);
            List<RechargeConfigVO> configVOList = rechargeConfigConverter.toVOList(rechargeConfigs);
            categoryVO.setConfig(configVOList);

            for (RechargeConfigVO configVO : configVOList) {
                // 查询三级配置
                LambdaQueryWrapper<RechargeSecond> secondWrapper = new LambdaQueryWrapper<>();
                secondWrapper.eq(RechargeSecond::getPid, configVO.getId())
                             .eq(RechargeSecond::getStatus, true)
                             .orderByAsc(RechargeSecond::getSort);
                List<RechargeSecond> rechargeSeconds = RechargeSecondMapper.selectList(secondWrapper);
                List<RechargeSecondVO> secondVOList = rechargeSecondConverter.toListEntity(rechargeSeconds);
                configVO.setSecond(secondVOList);

                for (RechargeSecondVO secondVO : secondVOList) {
                    // 查询四级配置
                    LambdaQueryWrapper<RechargeThree> threeWrapper = new LambdaQueryWrapper<>();
                    threeWrapper.eq(RechargeThree::getPid, secondVO.getId())
                                .eq(RechargeThree::getStatus, true)
                                .orderByAsc(RechargeThree::getSort);
                    List<RechargeThree> rechargeThrees = RechargeThreeMapper.selectList(threeWrapper);
                    List<RechargeThreeVO> threeVOList = rechargeThreeConverter.toListEntity(rechargeThrees);
                    secondVO.setThree(threeVOList);
                }
            }
        }
        return voList;
    }

}
