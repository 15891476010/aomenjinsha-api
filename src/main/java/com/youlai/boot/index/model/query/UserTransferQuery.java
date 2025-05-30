package com.youlai.boot.index.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 玩家投注表分页查询对象
 *
 * @since 2025-05-30 12:33
 */
@Schema(description ="玩家投注表查询对象")
@Getter
@Setter
public class UserTransferQuery extends BasePageQuery {

}
