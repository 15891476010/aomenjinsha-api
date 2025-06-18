package com.youlai.boot.game.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.game.model.entity.GameCategoryData;
import com.youlai.boot.game.model.form.GameCategoryDataForm;
import com.youlai.boot.game.model.query.GameCategoryDataQuery;
import com.youlai.boot.game.model.vo.GameCategoryDataVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 游戏列服务类
 *
 * @author MrZhang
 * @since 2025-05-18 19:33
 */
public interface GameCategoryDataService extends IService<GameCategoryData> {

    /**
     *游戏列分页列表
     *
     * @return {@link Page<GameCategoryDataVO>} 游戏列分页列表
     */
    Page<GameCategoryDataVO> getGameCategoryDataPage(GameCategoryDataQuery queryParams);

    /**
     * 获取游戏列表单数据
     *
     * @param id 游戏列ID
     * @return 游戏列表单数据
     */
    GameCategoryDataForm getGameCategoryDataFormData(Long id);

    /**
     * 新增游戏列
     *
     * @param formData 游戏列表单对象
     * @return 是否新增成功
     */
    boolean saveGameCategoryData(GameCategoryDataForm formData);

    /**
     * 修改游戏列
     *
     * @param id   游戏列ID
     * @param formData 游戏列表单对象
     * @return 是否修改成功
     */
    boolean updateGameCategoryData(Long id, GameCategoryDataForm formData);

    /**
     * 删除游戏列
     *
     * @param ids 游戏列ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteGameCategoryDatas(String ids);

}
