package com.youlai.boot.index.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 前端用户分页查询对象
 *
 * @author MrZhang
 * @since 2025-05-24 14:47
 */
@Schema(description ="前端用户查询对象")
@Getter
@Setter
public class EbUserQuery extends BasePageQuery {

}
