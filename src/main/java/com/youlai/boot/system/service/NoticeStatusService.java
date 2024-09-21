package com.youlai.boot.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.boot.system.model.entity.NoticeStatus;
import com.youlai.boot.system.model.query.NoticeQuery;
import com.youlai.boot.system.model.vo.NoticeStatusVO;
import com.youlai.boot.system.model.vo.NoticeVO;

import java.util.List;

/**
 * 用户公告状态服务类
 *
 * @author youlaitech
 * @since 2024-08-28 16:56
 */
public interface NoticeStatusService extends IService<NoticeStatus> {

    /**
     * 获取未读的通知公告
     * @return 公告列表
     */
    List<NoticeStatusVO> listUnreadNotices();

    /**
     * 全部标记为已读
     * @return 是否成功
     */
    boolean readAll();

    /**
     * 分页获取我的通知公告
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return 我的通知公告分页列表
     */
    IPage<NoticeStatusVO> getMyNoticePage(Page<NoticeVO> page, NoticeQuery queryParams);
}
