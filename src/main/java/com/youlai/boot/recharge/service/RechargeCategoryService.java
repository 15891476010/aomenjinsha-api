package com.youlai.boot.recharge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.recharge.model.entity.RechargeCategory;
import com.youlai.boot.recharge.model.form.RechargeCategoryForm;
import com.youlai.boot.recharge.model.query.RechargeCategoryQuery;
import com.youlai.boot.recharge.model.vo.RechargeCategoryVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 充值分类服务类
 *
 * @author MrZhang
 * @since 2025-05-29 00:00
 */
public interface RechargeCategoryService extends IService<RechargeCategory> {

    /**
     *充值分类分页列表
     *
     * @return {@link Page<RechargeCategoryVO>} 充值分类分页列表
     */
    Page<RechargeCategoryVO> getRechargeCategoryPage(RechargeCategoryQuery queryParams);

    /**
     * 获取充值分类表单数据
     *
     * @param id 充值分类ID
     * @return 充值分类表单数据
     */
    RechargeCategoryForm getRechargeCategoryFormData(Long id);

    /**
     * 新增充值分类
     *
     * @param formData 充值分类表单对象
     * @return 是否新增成功
     */
    boolean saveRechargeCategory(RechargeCategoryForm formData);

    /**
     * 修改充值分类
     *
     * @param id   充值分类ID
     * @param formData 充值分类表单对象
     * @return 是否修改成功
     */
    boolean updateRechargeCategory(Long id, RechargeCategoryForm formData);

    /**
     * 删除充值分类
     *
     * @param ids 充值分类ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteRechargeCategorys(String ids);
    List<Map<String, Object>> getRechargeCategoryOptions();

    /**
     * 前端获取充值分类
     */
    List<RechargeCategoryVO> getRechargeCategoryList();
}
