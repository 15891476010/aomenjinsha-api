package com.youlai.boot.recharge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.recharge.model.entity.RechargeList;
import com.youlai.boot.recharge.model.query.RechargeListQuery;
import com.youlai.boot.recharge.model.vo.RechargeListVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户充值列表Mapper接口
 *
 * @author MrZhang
 * @since 2025-06-01 19:49
 */
@Mapper
public interface RechargeListMapper extends BaseMapper<RechargeList> {

}
