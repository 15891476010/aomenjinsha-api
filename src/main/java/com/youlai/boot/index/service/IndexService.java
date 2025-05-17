package com.youlai.boot.index.service;

import com.youlai.boot.index.model.AdminIndexResultVo;
import com.youlai.boot.index.model.FrontIndexResultVo;

public interface IndexService {
    AdminIndexResultVo getIndexAdminData();

    FrontIndexResultVo getIndexFrontData();
}
