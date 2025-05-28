package com.youlai.boot.index.model.entity;

import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

import java.math.BigDecimal;

/**
 * 前端用户实体对象
 *
 * @author MrZhang
 * @since 2025-05-24 14:47
 */
@Getter
@Setter
@TableName("eb_user")
public class EbUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 支付密码
     */
    private String payPassword;
    /**
     * 国家
     */
    private String county;
    /**
     * 最后一次登录ip
     */
    private String ip;
    /**
     * 账号状态
     */
    private Boolean status;
    /**
     * 是否删除
     */
    private Boolean isDeleted;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * vip等级
     */
    private Integer vipLevel;
}
