package com.youlai.boot.recharge.service;

import com.youlai.boot.recharge.model.entity.RechargeList;
import com.youlai.boot.recharge.model.form.RechargeListForm;
import com.youlai.boot.recharge.model.query.RechargeListQuery;
import com.youlai.boot.recharge.model.vo.RechargeListVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户充值列表服务类
 *
 * @author MrZhang
 * @since 2025-06-01 19:49
 */
public interface RechargeListService extends IService<RechargeList> {

    /**
     *用户充值列表分页列表
     *
     * @return {@link Page<RechargeListVO>} 用户充值列表分页列表
     */
    Page<RechargeListVO> getRechargeListPage(RechargeListQuery queryParams);

    /**
     * 获取用户充值列表表单数据
     *
     * @param id 用户充值列表ID
     * @return 用户充值列表表单数据
     */
    RechargeListForm getRechargeListFormData(Long id);

    /**
     * 新增用户充值列表
     *
     * @param formData 用户充值列表表单对象
     * @return 是否新增成功
     */
    boolean saveRechargeList(RechargeListForm formData);

    /**
     * 修改用户充值列表
     *
     * @param id   用户充值列表ID
     * @param formData 用户充值列表表单对象
     * @return 是否修改成功
     */
    boolean updateRechargeList(Long id, RechargeListForm formData);

    /**
     * 删除用户充值列表
     *
     * @param ids 用户充值列表ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteRechargeLists(String ids);

}
