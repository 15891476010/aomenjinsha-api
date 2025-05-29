package com.youlai.boot.recharge.converter;

import com.youlai.boot.recharge.model.vo.RechargeCategoryVO;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.recharge.model.entity.RechargeCategory;
import com.youlai.boot.recharge.model.form.RechargeCategoryForm;

import java.util.List;

/**
 * 充值分类对象转换器
 *
 * @author MrZhang
 * @since 2025-05-29 00:00
 */
@Mapper(componentModel = "spring")
public interface RechargeCategoryConverter{

    RechargeCategoryForm toForm(RechargeCategory entity);

    RechargeCategory toEntity(RechargeCategoryForm formData);

    List<RechargeCategoryVO> toVOList(List<RechargeCategory> entityList);
}