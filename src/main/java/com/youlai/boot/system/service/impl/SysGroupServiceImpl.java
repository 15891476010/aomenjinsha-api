package com.youlai.boot.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.base.CommonPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.system.mapper.SysGroupMapper;
import com.youlai.boot.system.service.SysGroupService;
import com.youlai.boot.system.model.entity.SysGroup;
import com.youlai.boot.system.model.form.SysGroupForm;
import com.youlai.boot.system.model.query.SysGroupQuery;
import com.youlai.boot.system.model.vo.SysGroupVO;
import com.youlai.boot.system.converter.SysGroupConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 组合数据分类服务实现类
 *
 * @author MrZhang
 * @since 2025-05-15 00:13
 */
@Service
@RequiredArgsConstructor
public class SysGroupServiceImpl extends ServiceImpl<SysGroupMapper, SysGroup> implements SysGroupService {

    private final SysGroupConverter sysGroupConverter;

    /**
     * 获取组合数据分类分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<SysGroupVO>} 组合数据分类分页列表
     */
    @Override
    public Page<SysGroupVO> getSysGroupPage(SysGroupQuery queryParams) {
        LambdaQueryWrapper<SysGroup> wrapper = new LambdaQueryWrapper<>();
        Page<SysGroup> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        Page<SysGroup> sysGroupPage = baseMapper.selectPage(page, wrapper);
        List<SysGroupVO> voList = sysGroupConverter.toVoList(sysGroupPage.getRecords());
        return CommonPage.copyPageInfo(page, voList);
    }

    /**
     * 获取组合数据分类表单数据
     *
     * @param id 组合数据分类ID
     * @return 组合数据分类表单数据
     */
    @Override
    public SysGroupForm getSysGroupFormData(Long id) {
        SysGroup entity = this.getById(id);
        return sysGroupConverter.toForm(entity);
    }

    /**
     * 新增组合数据分类
     *
     * @param formData 组合数据分类表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSysGroup(SysGroupForm formData) {
        SysGroup entity = sysGroupConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新组合数据分类
     *
     * @param id   组合数据分类ID
     * @param formData 组合数据分类表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSysGroup(Long id,SysGroupForm formData) {
        SysGroup entity = sysGroupConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除组合数据分类
     *
     * @param ids 组合数据分类ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSysGroups(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的组合数据分类数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
