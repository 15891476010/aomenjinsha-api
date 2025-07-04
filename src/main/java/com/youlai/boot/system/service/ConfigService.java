package com.youlai.boot.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.boot.system.model.entity.Config;
import com.youlai.boot.system.model.form.ConfigForm;
import com.youlai.boot.system.model.query.ConfigPageQuery;
import com.youlai.boot.system.model.vo.ConfigVO;

import java.util.Map;

/**
 * 系统配置Service接口
 *
 * @author Theo
 * @since 2024-07-29 11:17:26
 */
public interface ConfigService extends IService<Config> {

    /**
     * 分页查询系统配置
     * @param sysConfigPageQuery 查询参数
     * @return 系统配置分页列表
     */
    IPage<ConfigVO> page(ConfigPageQuery sysConfigPageQuery);

    /**
     * 保存系统配置
     * @param sysConfigForm 系统配置表单
     * @return 是否保存成功
     */
    boolean save(ConfigForm sysConfigForm);

    /**
     * 获取系统配置表单数据
     *
     * @param id 系统配置ID
     * @return 系统配置表单数据
     */
    ConfigForm getConfigFormData(Long id);

    /**
     * 编辑系统配置
     * @param id  系统配置ID
     * @param sysConfigForm 系统配置表单
     * @return 是否编辑成功
     */
    boolean edit(Long id, ConfigForm sysConfigForm);

    /**
     * 删除系统配置
     * @param ids 系统配置ID
     * @return 是否删除成功
     */
    boolean delete(Long ids);

    /**
     * 刷新系统配置缓存
     * @return 是否刷新成功
     */
    boolean refreshCache();

    /**
     * 获取系统配置
     * @param key 配置键
     * @return 配置值
     */
    String getSystemConfig(String key);

    /**
     * 根据模板id修改对应的配置
     */
    Map<String, String> getConfigByTemplateId(Integer templateId);

    /**
     * 根据模板id修改对应的配置
     */
    void updateConfigByTemplateId(Integer templateId, Map<String, String> configMap);

}
