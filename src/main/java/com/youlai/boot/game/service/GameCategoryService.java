package com.youlai.boot.game.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.common.base.BasePageQuery;
import com.youlai.boot.game.model.entity.GameCategory;
import com.youlai.boot.game.model.form.GameCategoryForm;
import com.youlai.boot.game.model.query.GameCategoryQuery;
import com.youlai.boot.game.model.vo.GameCategoryResultVO;
import com.youlai.boot.game.model.vo.GameCategoryVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 游戏分类服务类
 *
 * @author MrZhang
 * @since 2025-05-18 16:38
 */
public interface GameCategoryService extends IService<GameCategory> {

    /**
     *游戏分类分页列表
     *
     * @return {@link Page<GameCategoryVO>} 游戏分类分页列表
     */
    Page<GameCategoryVO> getGameCategoryPage(GameCategoryQuery queryParams);

    /**
     * 获取游戏分类表单数据
     *
     * @param id 游戏分类ID
     * @return 游戏分类表单数据
     */
    GameCategoryForm getGameCategoryFormData(Long id);

    /**
     * 新增游戏分类
     *
     * @param formData 游戏分类表单对象
     * @return 是否新增成功
     */
    boolean saveGameCategory(GameCategoryForm formData);

    /**
     * 修改游戏分类
     *
     * @param id   游戏分类ID
     * @param formData 游戏分类表单对象
     * @return 是否修改成功
     */
    boolean updateGameCategory(Long id, GameCategoryForm formData);

    /**
     * 删除游戏分类
     *
     * @param ids 游戏分类ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteGameCategorys(String ids);

    /**
     * 联查游戏列表
     */
    Page<GameCategoryResultVO> getGameCategoryResultList(BasePageQuery one, BasePageQuery two);

    /**
     * 获取Options
     */
    List<Map<String, Object>> getOptions();

}
