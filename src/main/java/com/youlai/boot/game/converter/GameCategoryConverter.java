package com.youlai.boot.game.converter;

import com.youlai.boot.game.model.vo.GameCategoryResultVO;
import com.youlai.boot.game.model.vo.GameCategoryVO;
import org.mapstruct.Mapper;
import com.youlai.boot.game.model.entity.GameCategory;
import com.youlai.boot.game.model.form.GameCategoryForm;

import java.util.List;

/**
 * 游戏分类对象转换器
 *
 * @author MrZhang
 * @since 2025-05-18 16:38
 */
@Mapper(componentModel = "spring")
public interface GameCategoryConverter{

    GameCategoryForm toForm(GameCategory entity);

    GameCategory toEntity(GameCategoryForm formData);

    List<GameCategoryVO> toVoList (List<GameCategory> entities);

    List<GameCategoryResultVO> toResultVoList (List<GameCategoryVO> entities);
}