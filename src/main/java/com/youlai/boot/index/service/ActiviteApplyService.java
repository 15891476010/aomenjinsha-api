package com.youlai.boot.index.service;

import com.youlai.boot.index.model.entity.ActiviteApply;
import com.youlai.boot.index.model.form.ActiviteApplyForm;
import com.youlai.boot.index.model.query.ActiviteApplyQuery;
import com.youlai.boot.index.model.vo.ActiviteApplyVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户活动申请服务类
 *
 * @author MrZhang
 * @since 2025-06-07 15:34
 */
public interface ActiviteApplyService extends IService<ActiviteApply> {

    /**
     *用户活动申请分页列表
     *
     * @return {@link Page<ActiviteApplyVO>} 用户活动申请分页列表
     */
    Page<ActiviteApplyVO> getActiviteApplyPage(ActiviteApplyQuery queryParams);

    /**
     * 获取用户活动申请表单数据
     *
     * @param id 用户活动申请ID
     * @return 用户活动申请表单数据
     */
    ActiviteApplyForm getActiviteApplyFormData(Long id);

    /**
     * 新增用户活动申请
     *
     * @param formData 用户活动申请表单对象
     * @return 是否新增成功
     */
    boolean saveActiviteApply(ActiviteApplyForm formData);

    /**
     * 修改用户活动申请
     *
     * @param id   用户活动申请ID
     * @param formData 用户活动申请表单对象
     * @return 是否修改成功
     */
    boolean updateActiviteApply(Long id, ActiviteApplyForm formData);

    /**
     * 删除用户活动申请
     *
     * @param ids 用户活动申请ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteActiviteApplys(String ids);

    /**
     * 用户申请活动
     */
    boolean applyActivite(Integer activiteId);

}
