package com.youlai.boot.recharge.service;

import com.youlai.boot.recharge.model.entity.RechargeThree;
import com.youlai.boot.recharge.model.form.RechargeThreeForm;
import com.youlai.boot.recharge.model.query.RechargeThreeQuery;
import com.youlai.boot.recharge.model.vo.RechargeThreeVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 充值三级配置服务类
 *
 * @author MrZhang
 * @since 2025-05-29 18:59
 */
public interface RechargeThreeService extends IService<RechargeThree> {

    /**
     *充值三级配置分页列表
     *
     * @return {@link Page<RechargeThreeVO>} 充值三级配置分页列表
     */
    Page<RechargeThreeVO> getRechargeThreePage(RechargeThreeQuery queryParams);

    /**
     * 获取充值三级配置表单数据
     *
     * @param id 充值三级配置ID
     * @return 充值三级配置表单数据
     */
    RechargeThreeForm getRechargeThreeFormData(Long id);

    /**
     * 新增充值三级配置
     *
     * @param formData 充值三级配置表单对象
     * @return 是否新增成功
     */
    boolean saveRechargeThree(RechargeThreeForm formData);

    /**
     * 修改充值三级配置
     *
     * @param id   充值三级配置ID
     * @param formData 充值三级配置表单对象
     * @return 是否修改成功
     */
    boolean updateRechargeThree(Long id, RechargeThreeForm formData);

    /**
     * 删除充值三级配置
     *
     * @param ids 充值三级配置ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteRechargeThrees(String ids);

}
