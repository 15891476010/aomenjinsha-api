package com.youlai.boot.recharge.converter;

import com.youlai.boot.recharge.model.vo.RechargeConfigVO;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.recharge.model.entity.RechargeConfig;
import com.youlai.boot.recharge.model.form.RechargeConfigForm;

import java.util.List;

/**
 * 充值分类子配置对象转换器
 *
 * @author MrZhang
 * @since 2025-05-29 00:36
 */
@Mapper(componentModel = "spring")
public interface RechargeConfigConverter{

    RechargeConfigForm toForm(RechargeConfig entity);

    RechargeConfig toEntity(RechargeConfigForm formData);

    List<RechargeConfigVO> toVOList(List<RechargeConfig> entityList);
}