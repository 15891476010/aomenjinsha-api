package com.youlai.boot.game.converter;

import com.youlai.boot.game.model.vo.GameCategoryDataVO;
import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.game.model.entity.GameCategoryData;
import com.youlai.boot.game.model.form.GameCategoryDataForm;

import java.util.List;

/**
 * 游戏列对象转换器
 *
 * @author MrZhang
 * @since 2025-05-18 19:33
 */
@Mapper(componentModel = "spring")
public interface GameCategoryDataConverter{

    GameCategoryDataForm toForm(GameCategoryData entity);

    GameCategoryData toEntity(GameCategoryDataForm formData);

    List<GameCategoryDataVO> toVoList(List<GameCategoryData> entityList);
}