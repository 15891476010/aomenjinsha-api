package com.youlai.boot.recharge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.recharge.model.entity.RechargeThree;
import com.youlai.boot.recharge.model.query.RechargeThreeQuery;
import com.youlai.boot.recharge.model.vo.RechargeThreeVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 充值三级配置Mapper接口
 *
 * @author MrZhang
 * @since 2025-05-29 18:59
 */
@Mapper
public interface RechargeThreeMapper extends BaseMapper<RechargeThree> {

}
