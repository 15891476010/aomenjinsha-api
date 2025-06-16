package com.youlai.boot.game.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.game.model.entity.GamePlatType;
import com.youlai.boot.game.model.query.GamePlatTypeQuery;
import com.youlai.boot.game.model.vo.GamePlatTypeVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 游戏平台列表Mapper接口
 *
 * @author MrZhang
 * @since 2025-06-15 18:49
 */
@Mapper
public interface GamePlatTypeMapper extends BaseMapper<GamePlatType> {

}
