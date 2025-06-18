package com.youlai.boot.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.common.base.BasePageQuery;
import com.youlai.boot.system.model.entity.Attachment;
import com.youlai.boot.system.model.form.AttachmentForm;
import com.youlai.boot.system.model.query.AttachmentQuery;
import com.youlai.boot.system.model.vo.AttachmentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 附件管理服务类
 *
 * @author MrZhang
 * @since 2025-05-13 13:06
 */
public interface AttachmentService extends IService<Attachment> {

    /**
     *附件管理分页列表
     *
     * @return {@link IPage<AttachmentVO>} 附件管理分页列表
     */
    Page<Attachment> getAttachmentPage(AttachmentQuery queryParams);

    /**
     * 获取附件管理表单数据
     *
     * @param id 附件管理ID
     * @return 附件管理表单数据
     */
    AttachmentForm getAttachmentFormData(Long id);

    /**
     * 新增附件管理
     *
     * @param formData 附件管理表单对象
     * @return 是否新增成功
     */
    boolean saveAttachment(AttachmentForm formData);

    /**
     * 修改附件管理
     *
     * @param id   附件管理ID
     * @param formData 附件管理表单对象
     * @return 是否修改成功
     */
    boolean updateAttachment(Long id, AttachmentForm formData);

    /**
     * 删除附件管理
     *
     * @param ids 附件管理ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteAttachments(String ids);

    /**
     * 根据为文件名查询文件url
     */
    String getFileUrlByFileName(String fileName);

}
