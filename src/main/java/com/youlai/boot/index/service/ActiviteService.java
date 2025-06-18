package com.youlai.boot.index.service;

import com.youlai.boot.index.model.entity.Activite;
import com.youlai.boot.index.model.form.ActiviteForm;
import com.youlai.boot.index.model.query.ActiviteQuery;
import com.youlai.boot.index.model.vo.ActiviteVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 活动表服务类
 *
 * @author MrZhang
 * @since 2025-06-06 21:09
 */
public interface ActiviteService extends IService<Activite> {

    /**
     *活动表分页列表
     *
     * @return {@link Page<ActiviteVO>} 活动表分页列表
     */
    Page<ActiviteVO> getActivitePage(ActiviteQuery queryParams);

    /**
     * 获取活动表表单数据
     *
     * @param id 活动表ID
     * @return 活动表表单数据
     */
    ActiviteForm getActiviteFormData(Long id);

    /**
     * 新增活动表
     *
     * @param formData 活动表表单对象
     * @return 是否新增成功
     */
    boolean saveActivite(ActiviteForm formData);

    /**
     * 修改活动表
     *
     * @param id   活动表ID
     * @param formData 活动表表单对象
     * @return 是否修改成功
     */
    boolean updateActivite(Long id, ActiviteForm formData);

    /**
     * 删除活动表
     *
     * @param ids 活动表ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteActivites(String ids);

    /**
     * 获取活动列表
     */
    List<ActiviteVO> getActiviteList(ActiviteQuery queryParams);

}
