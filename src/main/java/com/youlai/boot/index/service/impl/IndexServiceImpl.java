package com.youlai.boot.index.service.impl;

import com.youlai.boot.common.constant.SysConfigConstant;
import com.youlai.boot.index.model.AdminIndexResultVo;
import com.youlai.boot.index.service.IndexService;
import com.youlai.boot.system.service.ConfigService;
import com.youlai.boot.system.service.SysGroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private SysGroupDataService sysGroupDataService;

    @Autowired
    private ConfigService configService;
    @Override
    public AdminIndexResultVo getIndexAdminData() {
        AdminIndexResultVo adminIndexResultVo = new AdminIndexResultVo();
        String imagePrefix = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MINIO_UPLOAD_DOMAIN); // 添加图片请求前缀
        adminIndexResultVo.setImagePrefix(imagePrefix);
        return adminIndexResultVo;
    }
}
