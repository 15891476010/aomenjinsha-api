package com.youlai.boot.index.service;

import com.youlai.boot.index.model.entity.ActivityType;
import com.youlai.boot.index.model.form.ActivityTypeForm;
import com.youlai.boot.index.model.query.ActivityTypeQuery;
import com.youlai.boot.index.model.vo.ActivityTypeVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 活动类型服务类
 *
 * @author MrZhang
 * @since 2025-06-06 20:45
 */
public interface ActivityTypeService extends IService<ActivityType> {

    /**
     *活动类型分页列表
     *
     * @return {@link Page<ActivityTypeVO>} 活动类型分页列表
     */
    Page<ActivityTypeVO> getActivityTypePage(ActivityTypeQuery queryParams);

    /**
     * 获取活动类型表单数据
     *
     * @param id 活动类型ID
     * @return 活动类型表单数据
     */
    ActivityTypeForm getActivityTypeFormData(Long id);

    /**
     * 新增活动类型
     *
     * @param formData 活动类型表单对象
     * @return 是否新增成功
     */
    boolean saveActivityType(ActivityTypeForm formData);

    /**
     * 修改活动类型
     *
     * @param id   活动类型ID
     * @param formData 活动类型表单对象
     * @return 是否修改成功
     */
    boolean updateActivityType(Long id, ActivityTypeForm formData);

    /**
     * 删除活动类型
     *
     * @param ids 活动类型ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteActivityTypes(String ids);

    /**
     * 获取Options
     */
    List<Map<String, Object>> getOptions();

}
