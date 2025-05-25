package com.youlai.boot.game.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.game.model.entity.GameCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 游戏分类Mapper接口
 *
 * @author MrZhang
 * @since 2025-05-18 16:38
 */
@Mapper
public interface GameCategoryMapper extends BaseMapper<GameCategory> {
}
