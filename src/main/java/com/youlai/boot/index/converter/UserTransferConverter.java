package com.youlai.boot.index.converter;

import com.youlai.boot.index.model.query.EbUserGameTransferQuery;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.index.model.entity.UserTransfer;
import com.youlai.boot.index.model.form.UserTransferForm;
import com.youlai.boot.index.model.vo.UserTransferVO;

import java.util.List;

/**
 * 玩家投注表对象转换器
 *
 * @author MrZhang
 * @since 2025-05-30 12:33
 */
@Mapper(componentModel = "spring")
public interface UserTransferConverter{

    UserTransferForm toForm(UserTransfer entity);

    UserTransfer toEntity(UserTransferForm formData);

    List<UserTransferVO> toListEntity(List<UserTransfer> entitys);

    UserTransferForm toForm(EbUserGameTransferQuery queryParams);
}