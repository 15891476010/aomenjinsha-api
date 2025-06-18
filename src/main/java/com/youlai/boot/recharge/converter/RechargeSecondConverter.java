package com.youlai.boot.recharge.converter;

import com.youlai.boot.recharge.model.form.RechargeSecondForm;
import com.youlai.boot.recharge.model.vo.RechargeSecondVO;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.recharge.model.entity.RechargeSecond;

import java.util.List;

/**
 * 充值分类子配置对象转换器
 *
 * @author MrZhang
 * @since 2025-05-29 13:32
 */
@Mapper(componentModel = "spring")
public interface RechargeSecondConverter{

    RechargeSecondForm toForm(RechargeSecond entity);

    RechargeSecond toEntity(RechargeSecondForm formData);

    List<RechargeSecondVO> toListEntity(List<RechargeSecond> entitys);
}