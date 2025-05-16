package com.youlai.boot.system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.system.mapper.SysFormTempMapper;
import com.youlai.boot.system.service.SysFormTempService;
import com.youlai.boot.system.model.entity.SysFormTemp;
import com.youlai.boot.system.model.form.SysFormTempForm;
import com.youlai.boot.system.model.query.SysFormTempQuery;
import com.youlai.boot.system.model.vo.SysFormTempVO;
import com.youlai.boot.system.converter.SysFormTempConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 表单模板服务实现类
 *
 * @author MrZhang
 * @since 2025-05-07 15:40
 */
@Service
@RequiredArgsConstructor
public class SysFormTempServiceImpl extends ServiceImpl<SysFormTempMapper, SysFormTemp> implements SysFormTempService {

    private final SysFormTempConverter sysFormTempConverter;

    /**
     * 获取表单模板分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<SysFormTempVO>} 表单模板分页列表
     */
    @Override
    public IPage<SysFormTempVO> getSysFormTempPage(SysFormTempQuery queryParams) {
        Page<SysFormTempVO> pageVO = this.baseMapper.getSysFormTempPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }

    /**
     * 获取表单模板表单数据
     *
     * @param id 表单模板ID
     * @return 表单模板表单数据
     */
    @Override
    public SysFormTempVO getSysFormTempFormData(Long id) {
        SysFormTemp byId = this.getById(id);
        return sysFormTempConverter.toVO(byId);
    }

    /**
     * 新增表单模板
     *
     * @param formData 表单模板表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSysFormTemp(SysFormTempForm formData) {
        SysFormTemp entity = sysFormTempConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新表单模板
     *
     * @param formData 表单模板表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSysFormTemp(SysFormTempForm formData) {
        SysFormTemp entity = sysFormTempConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除表单模板
     *
     * @param ids 表单模板ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSysFormTemps(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的表单模板数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
