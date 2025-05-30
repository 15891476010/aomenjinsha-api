package com.youlai.boot.index.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.index.model.entity.UserTransfer;
import com.youlai.boot.index.model.query.UserTransferQuery;
import com.youlai.boot.index.model.vo.UserTransferVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 玩家投注表Mapper接口
 *
 * @author MrZhang
 * @since 2025-05-30 12:33
 */
@Mapper
public interface UserTransferMapper extends BaseMapper<UserTransfer> {

}
