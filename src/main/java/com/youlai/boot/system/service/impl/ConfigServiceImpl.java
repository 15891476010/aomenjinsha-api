package com.youlai.boot.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.common.constant.RedisConstants;
import com.youlai.boot.system.converter.ConfigConverter;
import com.youlai.boot.system.mapper.ConfigMapper;
import com.youlai.boot.system.model.entity.Config;
import com.youlai.boot.system.model.form.ConfigForm;
import com.youlai.boot.system.model.query.ConfigPageQuery;
import com.youlai.boot.system.model.vo.ConfigVO;
import com.youlai.boot.system.service.ConfigService;
import com.youlai.boot.core.security.util.SecurityUtils;
import com.youlai.boot.system.service.SysFormTempService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 系统配置Service接口实现
 *
 * @author Theo
 * @since 2024-07-29 11:17:26
 */
@Service
@RequiredArgsConstructor
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

    private final ConfigConverter configConverter;

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private SysFormTempService sysFormTempService;

    /**
     * 系统启动完成后，加载系统配置到缓存
     */
    @PostConstruct
    public void init() {
        refreshCache();
    }

    /**
     * 分页查询系统配置
     *
     * @param configPageQuery 查询参数
     * @return 系统配置分页列表
     */
    @Override
    public IPage<ConfigVO> page(ConfigPageQuery configPageQuery) {
        Page<Config> page = new Page<>(configPageQuery.getPageNum(), configPageQuery.getPageSize());
        String keywords = configPageQuery.getKeywords();
        LambdaQueryWrapper<Config> query = new LambdaQueryWrapper<Config>()
                .and(StringUtils.isNotBlank(keywords),
                    q -> q.like(Config::getConfigKey, keywords)
                        .or()
                        .like(Config::getConfigName, keywords)
                );
        Page<Config> pageList = this.page(page, query);
        return configConverter.toPageVo(pageList);
    }

    /**
     * 保存系统配置
     *
     * @param configForm 系统配置表单
     * @return 是否保存成功
     */
    @Override
    public boolean save(ConfigForm configForm) {
        Assert.isTrue(
                super.count(new LambdaQueryWrapper<Config>().eq(Config::getConfigKey, configForm.getConfigKey())) == 0,
                "配置键已存在");
        Config config = configConverter.toEntity(configForm);
        config.setCreateBy(SecurityUtils.getUserId());
        config.setIsDeleted(0);
        return this.save(config);
    }

    /**
     * 获取系统配置表单数据
     *
     * @param id 系统配置ID
     * @return 系统配置表单数据
     */
    @Override
    public ConfigForm getConfigFormData(Long id) {
        Config entity = this.getById(id);
        return configConverter.toForm(entity);
    }

    /**
     * 编辑系统配置
     *
     * @param id         系统配置ID
     * @param configForm 系统配置表单
     * @return 是否编辑成功
     */
    @Override
    public boolean edit(Long id, ConfigForm configForm) {
        Assert.isTrue(
                super.count(new LambdaQueryWrapper<Config>().eq(Config::getConfigKey, configForm.getConfigKey()).ne(Config::getId, id)) == 0,
                "配置键已存在");
        Config config = configConverter.toEntity(configForm);
        config.setUpdateBy(SecurityUtils.getUserId());
        return this.updateById(config);
    }

    /**
     * 删除系统配置
     *
     * @param id 系统配置ID
     * @return 是否删除成功
     */
    @Override
    public boolean delete(Long id) {
        if (id != null) {
            return super.update(new LambdaUpdateWrapper<Config>()
                    .eq(Config::getId,id)
                    .set(Config::getIsDeleted, 1)
                    .set(Config::getUpdateBy, SecurityUtils.getUserId())
            );
        }
        return false;
    }

    /**
     * 刷新系统配置缓存
     *
     * @return 是否刷新成功
     */
    @Override
    public boolean refreshCache() {
        redisTemplate.delete(RedisConstants.System.CONFIG);
        List<Config> list = this.list();
        if (list != null) {
            Map<String, String> map = list.stream().collect(Collectors.toMap(Config::getConfigKey, Config::getConfigValue));
            redisTemplate.opsForHash().putAll(RedisConstants.System.CONFIG, map);
            return true;
        }
        return false;
    }

    /**
     * 获取系统配置
     *
     * @param key 配置键
     * @return 配置值
     */
    @Override
    public String getSystemConfig(String key) {
        if (StringUtils.isNotBlank(key)) {
            return (String) redisTemplate.opsForHash().get(RedisConstants.System.CONFIG, key);
        }
        return null;
    }

    @Override
    public Map<String, String> getConfigByTemplateId(Integer templateId) {
        LambdaQueryWrapper<Config> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Config::getFormId, templateId);
        List<Config> configs = baseMapper.selectList(wrapper);
        Map<String, String> map = new HashMap<>();
        configs.forEach(config -> {
            map.put(config.getConfigKey(), config.getConfigValue());
        });
        return map;
    }

    @Override
    public void updateConfigByTemplateId(Integer templateId, Map<String, String> configMap) {
        if (templateId != null && configMap != null) {
            LambdaQueryWrapper<Config> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Config::getFormId, templateId);
            int delete = baseMapper.delete(wrapper);

            // 循环configMap
            for (Map.Entry<String, String> entry : configMap.entrySet()) {
                Config config = new Config();
                config.setConfigKey(entry.getKey());
                config.setConfigValue(entry.getValue());
                config.setConfigName(entry.getKey());
                config.setFormId(templateId);
                baseMapper.insert(config);
            }
        }
    }

}
