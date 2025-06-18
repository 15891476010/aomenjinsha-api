package com.youlai.boot.index.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.index.model.entity.ActiviteApply;
import com.youlai.boot.index.model.query.ActiviteApplyQuery;
import com.youlai.boot.index.model.vo.ActiviteApplyVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户活动申请Mapper接口
 *
 * @author MrZhang
 * @since 2025-06-07 15:34
 */
@Mapper
public interface ActiviteApplyMapper extends BaseMapper<ActiviteApply> {

}
