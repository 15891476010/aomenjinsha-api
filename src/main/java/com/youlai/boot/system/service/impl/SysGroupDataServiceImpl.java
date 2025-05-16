package com.youlai.boot.system.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.gson.Gson;
import com.youlai.boot.common.base.CommonPage;
import com.youlai.boot.system.model.vo.SystemFormItemCheckVo;
import com.youlai.boot.utils.MrZhangUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.system.mapper.SysGroupDataMapper;
import com.youlai.boot.system.service.SysGroupDataService;
import com.youlai.boot.system.model.entity.SysGroupData;
import com.youlai.boot.system.model.form.SysGroupDataForm;
import com.youlai.boot.system.model.query.SysGroupDataQuery;
import com.youlai.boot.system.model.vo.SysGroupDataVO;
import com.youlai.boot.system.converter.SysGroupDataConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 组合分类数据服务实现类
 *
 * @author MrZhang
 * @since 2025-05-15 00:48
 */
@Service
@RequiredArgsConstructor
public class SysGroupDataServiceImpl extends ServiceImpl<SysGroupDataMapper, SysGroupData> implements SysGroupDataService {

    private final SysGroupDataConverter sysGroupDataConverter;

    /**
     * 获取组合分类数据分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<SysGroupDataVO>} 组合分类数据分页列表
     */
    @Override
    public Page<SysGroupDataVO> getSysGroupDataPage(SysGroupDataQuery queryParams) {
        LambdaQueryWrapper<SysGroupData> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysGroupData::getGid, queryParams.getGid());
        if (queryParams.getStatus() != null) {
            wrapper.eq(SysGroupData::getStatus, queryParams.getStatus());
        }
        Page<SysGroupData> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        Page<SysGroupData> sysGroupDataPage = baseMapper.selectPage(page, wrapper);
        return CommonPage.copyPageInfo(sysGroupDataPage, sysGroupDataConverter.toVoList(sysGroupDataPage.getRecords()));
    }

    /**
     * 获取组合分类数据表单数据
     *
     * @param id 组合分类数据ID
     * @return 组合分类数据表单数据
     */
    @Override
    public SysGroupDataForm getSysGroupDataFormData(Long id) {
        SysGroupData entity = this.getById(id);
        return sysGroupDataConverter.toForm(entity);
    }

    /**
     * 新增组合分类数据
     *
     * @param formData 组合分类数据表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveSysGroupData(SysGroupDataForm formData) {
        SysGroupData entity = sysGroupDataConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新组合分类数据
     *
     * @param id   组合分类数据ID
     * @param formData 组合分类数据表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateSysGroupData(Long id,SysGroupDataForm formData) {
        SysGroupData entity = sysGroupDataConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除组合分类数据
     *
     * @param ids 组合分类数据ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteSysGroupDatas(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的组合分类数据数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public List<HashMap<String, Object>> getListMapByGid(Integer gid) {
        // 1. 查询数据
        SysGroupDataQuery sysGroupDataQuery = new SysGroupDataQuery();
        sysGroupDataQuery.setGid(gid);
        sysGroupDataQuery.setStatus(true);
        sysGroupDataQuery.setPageNum(1);
        sysGroupDataQuery.setPageSize(Integer.MAX_VALUE);
        List<SysGroupDataVO> list = getSysGroupDataPage(sysGroupDataQuery).getRecords();

        // 2. 如果数据为空，返回 null
        if (list == null || list.isEmpty()) {
            return null;
        }

        // 3. 准备返回结果
        List<HashMap<String, Object>> resultList = new ArrayList<>();

        for (SysGroupDataVO sysGroupDataVO : list) {
            try {
                // 4. 解析 JSON 数组（因为数据是以 [ 开头的数组）
                JSONArray jsonArray = JSONArray.parseArray(sysGroupDataVO.getValue());

                // 6. 创建结果Map
                HashMap<String, Object> map = new HashMap<>();
                // 5. 遍历数组中的每个对象
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject item = jsonArray.getJSONObject(i);

                    // 7. 提取需要的字段
                    map.put(item.getString("field"), item.get("value"));
                }
                resultList.add(map);
            } catch (Exception e) {
                e.printStackTrace(); // 打印异常
            }
        }

        return resultList.isEmpty() ? null : resultList;
    }

}
