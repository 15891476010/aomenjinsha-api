package com.youlai.boot.index.converter;

import com.youlai.boot.index.model.vo.EbUserBalanceVO;
import com.youlai.boot.index.model.vo.EbUserFrontVO;
import com.youlai.boot.index.model.vo.EbUserVO;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.index.model.entity.EbUser;
import com.youlai.boot.index.model.form.EbUserForm;

import java.util.List;

/**
 * 前端用户对象转换器
 *
 * @author MrZhang
 * @since 2025-05-24 14:47
 */
@Mapper(componentModel = "spring")
public interface EbUserConverter{

    EbUserForm toForm(EbUser entity);

    EbUser toEntity(EbUserForm formData);

    List<EbUserVO> toVOList(List<EbUser> entityList);

    EbUserFrontVO  toFrontVO(EbUser entity);

    EbUserBalanceVO toBalanceVO(EbUser entity);
}