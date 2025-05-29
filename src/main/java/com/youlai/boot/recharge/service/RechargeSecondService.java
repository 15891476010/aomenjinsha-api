package com.youlai.boot.recharge.service;

import com.youlai.boot.recharge.model.entity.RechargeSecond;
import com.youlai.boot.recharge.model.form.RechargeSecondForm;
import com.youlai.boot.recharge.model.query.RechargeSecondQuery;
import com.youlai.boot.recharge.model.vo.RechargeSecondVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 充值分类子配置服务类
 *
 * @author MrZhang
 * @since 2025-05-29 13:32
 */
public interface RechargeSecondService extends IService<RechargeSecond> {

    /**
     *充值分类子配置分页列表
     *
     * @return {@link Page<RechargeSecondVO>} 充值分类子配置分页列表
     */
    Page<RechargeSecondVO> getRechargeSecondPage(RechargeSecondQuery queryParams);

    /**
     * 获取充值分类子配置表单数据
     *
     * @param id 充值分类子配置ID
     * @return 充值分类子配置表单数据
     */
    RechargeSecondForm getRechargeSecondFormData(Long id);

    /**
     * 新增充值分类子配置
     *
     * @param formData 充值分类子配置表单对象
     * @return 是否新增成功
     */
    boolean saveRechargeSecond(RechargeSecondForm formData);

    /**
     * 修改充值分类子配置
     *
     * @param id   充值分类子配置ID
     * @param formData 充值分类子配置表单对象
     * @return 是否修改成功
     */
    boolean updateRechargeSecond(Long id, RechargeSecondForm formData);

    /**
     * 删除充值分类子配置
     *
     * @param ids 充值分类子配置ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteRechargeSeconds(String ids);

    /**
     * 获取Options
     */
    List<Map<String, Object>> getOptions();

}
