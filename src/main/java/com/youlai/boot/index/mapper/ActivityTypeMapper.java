package com.youlai.boot.index.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.index.model.entity.ActivityType;
import com.youlai.boot.index.model.query.ActivityTypeQuery;
import com.youlai.boot.index.model.vo.ActivityTypeVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 活动类型Mapper接口
 *
 * @author MrZhang
 * @since 2025-06-06 20:45
 */
@Mapper
public interface ActivityTypeMapper extends BaseMapper<ActivityType> {

}
