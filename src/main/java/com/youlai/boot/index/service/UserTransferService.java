package com.youlai.boot.index.service;

import com.youlai.boot.index.model.entity.UserTransfer;
import com.youlai.boot.index.model.form.UserTransferForm;
import com.youlai.boot.index.model.query.UserTransferQuery;
import com.youlai.boot.index.model.vo.UserTransferVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 玩家投注表服务类
 *
 * @author MrZhang
 * @since 2025-05-30 12:33
 */
public interface UserTransferService extends IService<UserTransfer> {

    /**
     *玩家投注表分页列表
     *
     * @return {@link Page<UserTransferVO>} 玩家投注表分页列表
     */
    Page<UserTransferVO> getUserTransferPage(UserTransferQuery queryParams);

    /**
     * 新增玩家投注表
     *
     * @param formData 玩家投注表表单对象
     * @return 是否新增成功
     */
    boolean saveUserTransfer(UserTransferForm formData);

}
