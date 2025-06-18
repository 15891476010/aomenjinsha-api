package com.youlai.boot.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.model.entity.SysGroup;
import com.youlai.boot.system.model.form.SysGroupForm;
import com.youlai.boot.system.model.query.SysGroupQuery;
import com.youlai.boot.system.model.vo.SysGroupVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 组合数据分类服务类
 *
 * @author MrZhang
 * @since 2025-05-15 00:13
 */
public interface SysGroupService extends IService<SysGroup> {

    /**
     *组合数据分类分页列表
     *
     * @return {@link IPage<SysGroupVO>} 组合数据分类分页列表
     */
    Page<SysGroupVO> getSysGroupPage(SysGroupQuery queryParams);

    /**
     * 获取组合数据分类表单数据
     *
     * @param id 组合数据分类ID
     * @return 组合数据分类表单数据
     */
    SysGroupForm getSysGroupFormData(Long id);

    /**
     * 新增组合数据分类
     *
     * @param formData 组合数据分类表单对象
     * @return 是否新增成功
     */
    boolean saveSysGroup(SysGroupForm formData);

    /**
     * 修改组合数据分类
     *
     * @param id   组合数据分类ID
     * @param formData 组合数据分类表单对象
     * @return 是否修改成功
     */
    boolean updateSysGroup(Long id, SysGroupForm formData);

    /**
     * 删除组合数据分类
     *
     * @param ids 组合数据分类ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSysGroups(String ids);

}
