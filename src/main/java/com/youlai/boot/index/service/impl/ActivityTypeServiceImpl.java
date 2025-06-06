package com.youlai.boot.index.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.common.base.CommonPage;
import com.youlai.boot.recharge.model.entity.RechargeSecond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.index.mapper.ActivityTypeMapper;
import com.youlai.boot.index.service.ActivityTypeService;
import com.youlai.boot.index.model.entity.ActivityType;
import com.youlai.boot.index.model.form.ActivityTypeForm;
import com.youlai.boot.index.model.query.ActivityTypeQuery;
import com.youlai.boot.index.model.vo.ActivityTypeVO;
import com.youlai.boot.index.converter.ActivityTypeConverter;

import java.util.*;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 活动类型服务实现类
 *
 * @author MrZhang
 * @since 2025-06-06 20:45
 */
@Service
@RequiredArgsConstructor
public class ActivityTypeServiceImpl extends ServiceImpl<ActivityTypeMapper, ActivityType> implements ActivityTypeService {

    private final ActivityTypeConverter activityTypeConverter;

    /**
     * 获取活动类型分页列表
     *
     * @param queryParams 查询参数
     * @return {@link Page<ActivityTypeVO>} 活动类型分页列表
     */
    @Override
    public Page<ActivityTypeVO> getActivityTypePage(ActivityTypeQuery queryParams) {
        Page<ActivityType> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<ActivityType> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(ActivityType::getSort);
        if (ObjectUtil.isNotEmpty(queryParams.getStatus())) {
            wrapper.eq(ActivityType::getStatus, queryParams.getStatus());
        }
        if (ObjectUtil.isNotEmpty(queryParams.getName())) {
            wrapper.like(ActivityType::getName, queryParams.getName());
        }
        if (ObjectUtil.isNotEmpty(queryParams.getStatus())) {
            wrapper.eq(ActivityType::getStatus, queryParams.getStatus());
        }
        Page<ActivityType> result = baseMapper.selectPage(page, wrapper);
        return CommonPage.copyPageInfo(result, activityTypeConverter.toListEntity(result.getRecords()));
    }

    /**
     * 获取活动类型表单数据
     *
     * @param id 活动类型ID
     * @return 活动类型表单数据
     */
    @Override
    public ActivityTypeForm getActivityTypeFormData(Long id) {
        ActivityType entity = this.getById(id);
        return activityTypeConverter.toForm(entity);
    }

    /**
     * 新增活动类型
     *
     * @param formData 活动类型表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveActivityType(ActivityTypeForm formData) {
        ActivityType entity = activityTypeConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新活动类型
     *
     * @param id   活动类型ID
     * @param formData 活动类型表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateActivityType(Long id,ActivityTypeForm formData) {
        ActivityType entity = activityTypeConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除活动类型
     *
     * @param ids 活动类型ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteActivityTypes(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的活动类型数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<Map<String, Object>> getOptions() {
        LambdaQueryWrapper<ActivityType> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ActivityType::getStatus, true);
        List<ActivityType> list = baseMapper.selectList(wrapper);
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
