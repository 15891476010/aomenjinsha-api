package com.youlai.boot.index.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.index.model.entity.Activite;
import com.youlai.boot.index.model.query.ActiviteQuery;
import com.youlai.boot.index.model.vo.ActiviteVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 活动表Mapper接口
 *
 * @author MrZhang
 * @since 2025-06-06 21:09
 */
@Mapper
public interface ActiviteMapper extends BaseMapper<Activite> {

}
