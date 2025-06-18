package com.youlai.boot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.system.model.entity.SysFormTemp;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.model.query.SysFormTempQuery;
import com.youlai.boot.system.model.vo.SysFormTempVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 表单模板Mapper接口
 *
 * @author MrZhang
 * @since 2025-05-07 15:40
 */
@Mapper
public interface SysFormTempMapper extends BaseMapper<SysFormTemp> {

    /**
     * 获取表单模板分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<SysFormTempVO>} 表单模板分页列表
     */
    Page<SysFormTempVO> getSysFormTempPage(Page<SysFormTempVO> page, SysFormTempQuery queryParams);

}
