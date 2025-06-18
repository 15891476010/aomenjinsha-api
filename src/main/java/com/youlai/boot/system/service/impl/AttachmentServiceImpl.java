package com.youlai.boot.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.base.PageQueryParams;
import com.youlai.boot.common.constant.SysConfigConstant;
import com.youlai.boot.system.model.query.AttachmentQuery;
import com.youlai.boot.system.service.ConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.system.mapper.AttachmentMapper;
import com.youlai.boot.system.service.AttachmentService;
import com.youlai.boot.system.model.entity.Attachment;
import com.youlai.boot.system.model.form.AttachmentForm;
import com.youlai.boot.system.model.vo.AttachmentVO;
import com.youlai.boot.system.converter.AttachmentConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 附件管理服务实现类
 *
 * @author MrZhang
 * @since 2025-05-13 13:06
 */
@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements AttachmentService {

    private final AttachmentConverter attachmentConverter;

    @Autowired
    private ConfigService configService;

    /**
     * 获取附件管理分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<AttachmentVO>} 附件管理分页列表
     */
    @Override
    public Page<Attachment> getAttachmentPage(AttachmentQuery queryParams) {
        Page<Attachment> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<Attachment> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Attachment::getId);
        if (ObjectUtil.isNotEmpty(queryParams.getName())) {
            wrapper.like(Attachment::getName, queryParams.getName());
        }

        if (ObjectUtil.isNotEmpty(queryParams.getPid())) {
            wrapper.eq(Attachment::getPid, queryParams.getPid());
        }
        String systemConfig = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MINIO_UPLOAD_DOMAIN);
        List<Attachment> records = baseMapper.selectPage(page, wrapper).getRecords();
        records.forEach(item -> {
            item.setAttDir(systemConfig);
        });
        page.setRecords(records);
        return page;
    }

    /**
     * 获取附件管理表单数据
     *
     * @param id 附件管理ID
     * @return 附件管理表单数据
     */
    @Override
    public AttachmentForm getAttachmentFormData(Long id) {
        Attachment entity = this.getById(id);
        return attachmentConverter.toForm(entity);
    }

    /**
     * 新增附件管理
     *
     * @param formData 附件管理表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveAttachment(AttachmentForm formData) {
        Attachment entity = attachmentConverter.toEntity(formData);
        return this.save(entity);
    }

    /**
     * 更新附件管理
     *
     * @param id   附件管理ID
     * @param formData 附件管理表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateAttachment(Long id,AttachmentForm formData) {
        Attachment entity = attachmentConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除附件管理
     *
     * @param ids 附件管理ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteAttachments(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的附件管理数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public String getFileUrlByFileName(String fileName) {
        LambdaQueryWrapper<Attachment> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Attachment::getName, fileName);
        if (ObjectUtil.isNotEmpty(baseMapper.selectList(wrapper))) {
            return baseMapper.selectList(wrapper).get(0).getSattDir();
        }
        return "";
    }

}
