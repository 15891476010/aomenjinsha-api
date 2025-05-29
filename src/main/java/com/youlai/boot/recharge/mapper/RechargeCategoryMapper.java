package com.youlai.boot.recharge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.recharge.model.entity.RechargeCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 充值分类Mapper接口
 *
 * @author MrZhang
 * @since 2025-05-29 00:00
 */
@Mapper
public interface RechargeCategoryMapper extends BaseMapper<RechargeCategory> {
}
