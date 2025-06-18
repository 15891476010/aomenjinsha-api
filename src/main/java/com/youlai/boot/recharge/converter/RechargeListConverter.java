package com.youlai.boot.recharge.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.recharge.model.entity.RechargeList;
import com.youlai.boot.recharge.model.form.RechargeListForm;
import com.youlai.boot.recharge.model.vo.RechargeListVO;

import java.util.List;

/**
 * 用户充值列表对象转换器
 *
 * @author MrZhang
 * @since 2025-06-01 19:49
 */
@Mapper(componentModel = "spring")
public interface RechargeListConverter{

    RechargeListForm toForm(RechargeList entity);

    RechargeList toEntity(RechargeListForm formData);

    List<RechargeListVO> toListEntity(List<RechargeList> entitys);
}