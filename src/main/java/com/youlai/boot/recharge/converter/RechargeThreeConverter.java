package com.youlai.boot.recharge.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.recharge.model.entity.RechargeThree;
import com.youlai.boot.recharge.model.form.RechargeThreeForm;
import com.youlai.boot.recharge.model.vo.RechargeThreeVO;

import java.util.List;

/**
 * 充值三级配置对象转换器
 *
 * @author MrZhang
 * @since 2025-05-29 18:59
 */
@Mapper(componentModel = "spring")
public interface RechargeThreeConverter{

    RechargeThreeForm toForm(RechargeThree entity);

    RechargeThree toEntity(RechargeThreeForm formData);

    List<RechargeThreeVO> toListEntity(List<RechargeThree> entitys);
}