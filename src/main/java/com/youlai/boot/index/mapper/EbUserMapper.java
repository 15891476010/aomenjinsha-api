package com.youlai.boot.index.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.index.model.entity.EbUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 前端用户Mapper接口
 *
 * @author MrZhang
 * @since 2025-05-24 14:47
 */
@Mapper
public interface EbUserMapper extends BaseMapper<EbUser> {
}
