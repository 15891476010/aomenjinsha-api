package com.youlai.boot.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.model.entity.SysGroupData;
import com.youlai.boot.system.model.form.SysGroupDataForm;
import com.youlai.boot.system.model.query.SysGroupDataQuery;
import com.youlai.boot.system.model.vo.SysGroupDataVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * 组合分类数据服务类
 *
 * @author MrZhang
 * @since 2025-05-15 00:48
 */
public interface SysGroupDataService extends IService<SysGroupData> {

    /**
     *组合分类数据分页列表
     *
     * @return {@link Page<SysGroupDataVO>} 组合分类数据分页列表
     */
    Page<SysGroupDataVO> getSysGroupDataPage(SysGroupDataQuery queryParams);

    /**
     * 获取组合分类数据表单数据
     *
     * @param id 组合分类数据ID
     * @return 组合分类数据表单数据
     */
    SysGroupDataForm getSysGroupDataFormData(Long id);

    /**
     * 新增组合分类数据
     *
     * @param formData 组合分类数据表单对象
     * @return 是否新增成功
     */
    boolean saveSysGroupData(SysGroupDataForm formData);

    /**
     * 修改组合分类数据
     *
     * @param id   组合分类数据ID
     * @param formData 组合分类数据表单对象
     * @return 是否修改成功
     */
    boolean updateSysGroupData(Long id, SysGroupDataForm formData);

    /**
     * 删除组合分类数据
     *
     * @param ids 组合分类数据ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSysGroupDatas(String ids);

    /**
     * 获取组合数据
     */
    List<HashMap<String, Object>> getListMapByGid(Integer gid);

}
