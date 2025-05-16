package com.youlai.boot.system.service;

import com.youlai.boot.system.model.entity.SysFormTemp;
import com.youlai.boot.system.model.form.SysFormTempForm;
import com.youlai.boot.system.model.query.SysFormTempQuery;
import com.youlai.boot.system.model.vo.SysFormTempVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 表单模板服务类
 *
 * @author MrZhang
 * @since 2025-05-07 15:40
 */
public interface SysFormTempService extends IService<SysFormTemp> {

    /**
     *表单模板分页列表
     *
     * @return {@link IPage<SysFormTempVO>} 表单模板分页列表
     */
    IPage<SysFormTempVO> getSysFormTempPage(SysFormTempQuery queryParams);

    /**
     * 获取表单模板表单数据
     *
     * @param id 表单模板ID
     * @return 表单模板表单数据
     */
    SysFormTempVO getSysFormTempFormData(Long id);

    /**
     * 新增表单模板
     *
     * @param formData 表单模板表单对象
     * @return 是否新增成功
     */
    boolean saveSysFormTemp(SysFormTempForm formData);

    /**
     * 修改表单模板
     *
     * @param formData 表单模板表单对象
     * @return 是否修改成功
     */
    boolean updateSysFormTemp(SysFormTempForm formData);

    /**
     * 删除表单模板
     *
     * @param ids 表单模板ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteSysFormTemps(String ids);

}
