package com.youlai.boot.game.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.game.model.entity.GamePlatType;
import com.youlai.boot.game.model.form.GamePlatTypeForm;
import com.youlai.boot.game.model.vo.GamePlatTypeVO;

import java.util.List;

/**
 * 游戏平台列表对象转换器
 *
 * @author MrZhang
 * @since 2025-06-15 18:49
 */
@Mapper(componentModel = "spring")
public interface GamePlatTypeConverter{

    GamePlatTypeForm toForm(GamePlatType entity);

    GamePlatType toEntity(GamePlatTypeForm formData);

    List<GamePlatTypeVO> toListEntity(List<GamePlatType> entitys);
}