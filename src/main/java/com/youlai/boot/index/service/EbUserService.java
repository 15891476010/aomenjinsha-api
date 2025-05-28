package com.youlai.boot.index.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.core.security.model.AuthenticationToken;
import com.youlai.boot.index.model.entity.EbUser;
import com.youlai.boot.index.model.form.EbUserForm;
import com.youlai.boot.index.model.form.EbUserLoginRequest;
import com.youlai.boot.index.model.query.EbUserQuery;
import com.youlai.boot.index.model.vo.EbUserBalanceVO;
import com.youlai.boot.index.model.vo.EbUserFrontVO;
import com.youlai.boot.index.model.vo.EbUserVO;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;

import java.net.http.HttpRequest;

/**
 * 前端用户服务类
 *
 * @author MrZhang
 * @since 2025-05-24 14:47
 */
public interface EbUserService extends IService<EbUser> {

    /**
     *前端用户分页列表
     *
     * @return {@link Page<EbUserVO>} 前端用户分页列表
     */
    Page<EbUserVO> getEbUserPage(EbUserQuery queryParams);

    /**
     * 获取前端用户表单数据
     *
     * @param id 前端用户ID
     * @return 前端用户表单数据
     */
    EbUserForm getEbUserFormData(Long id);

    /**
     * 新增前端用户
     *
     * @param formData 前端用户表单对象
     * @return 是否新增成功
     */
    boolean saveEbUser(HttpServletRequest request, EbUserForm formData);

    /**
     * 修改前端用户
     *
     * @param id   前端用户ID
     * @param formData 前端用户表单对象
     * @return 是否修改成功
     */
    boolean updateEbUser(Long id, EbUserForm formData);

    /**
     * 删除前端用户
     *
     * @param ids 前端用户ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteEbUsers(String ids);

    /**
     * 用户注册
     */
    boolean register(EbUserForm formData);

    /**
     * 用户登录
     */
    AuthenticationToken login(HttpServletRequest request, EbUserLoginRequest loginRequest);

    EbUserFrontVO getCurrentUserInfo();

    /**
     * 获取用户余额
     */
    EbUserBalanceVO getUserBalance();

    /**
     * 余额归户
     */
    boolean transfer();
}
