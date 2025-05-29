package com.youlai.boot.recharge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.recharge.model.entity.RechargeConfig;
import com.youlai.boot.recharge.model.form.RechargeConfigForm;
import com.youlai.boot.recharge.model.query.RechargeConfigQuery;
import com.youlai.boot.recharge.model.vo.RechargeConfigVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 充值分类子配置服务类
 *
 * @author MrZhang
 * @since 2025-05-29 00:36
 */
public interface RechargeConfigService extends IService<RechargeConfig> {

    /**
     *充值分类子配置分页列表
     *
     * @return {@link Page<RechargeConfigVO>} 充值分类子配置分页列表
     */
    Page<RechargeConfigVO> getRechargeConfigPage(RechargeConfigQuery queryParams);

    /**
     * 获取充值分类子配置表单数据
     *
     * @param id 充值分类子配置ID
     * @return 充值分类子配置表单数据
     */
    RechargeConfigForm getRechargeConfigFormData(Long id);

    /**
     * 新增充值分类子配置
     *
     * @param formData 充值分类子配置表单对象
     * @return 是否新增成功
     */
    boolean saveRechargeConfig(RechargeConfigForm formData);

    /**
     * 修改充值分类子配置
     *
     * @param id   充值分类子配置ID
     * @param formData 充值分类子配置表单对象
     * @return 是否修改成功
     */
    boolean updateRechargeConfig(Long id, RechargeConfigForm formData);

    /**
     * 删除充值分类子配置
     *
     * @param ids 充值分类子配置ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteRechargeConfigs(String ids);

    /**
     * 获取Options
     */
    List<Map<String, Object>> getOptions();

}
