package com.youlai.boot.game.service;

import com.youlai.boot.game.model.entity.GamePlatType;
import com.youlai.boot.game.model.form.GamePlatTypeForm;
import com.youlai.boot.game.model.query.GamePlatTypeQuery;
import com.youlai.boot.game.model.vo.GamePlatTypeVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 游戏平台列表服务类
 *
 * @author MrZhang
 * @since 2025-06-15 18:49
 */
public interface GamePlatTypeService extends IService<GamePlatType> {

    /**
     *游戏平台列表分页列表
     *
     * @return {@link Page<GamePlatTypeVO>} 游戏平台列表分页列表
     */
    Page<GamePlatTypeVO> getGamePlatTypePage(GamePlatTypeQuery queryParams);

    /**
     * 获取游戏平台列表表单数据
     *
     * @param id 游戏平台列表ID
     * @return 游戏平台列表表单数据
     */
    GamePlatTypeForm getGamePlatTypeFormData(Long id);

    /**
     * 新增游戏平台列表
     *
     * @param formData 游戏平台列表表单对象
     * @return 是否新增成功
     */
    boolean saveGamePlatType(GamePlatTypeForm formData);

    /**
     * 修改游戏平台列表
     *
     * @param id   游戏平台列表ID
     * @param formData 游戏平台列表表单对象
     * @return 是否修改成功
     */
    boolean updateGamePlatType(Long id, GamePlatTypeForm formData);

    /**
     * 删除游戏平台列表
     *
     * @param ids 游戏平台列表ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteGamePlatTypes(String ids);

    /**
     * 获取游戏代码
     */
    Map<String, Object> getGamePlatType(String platType);
}
