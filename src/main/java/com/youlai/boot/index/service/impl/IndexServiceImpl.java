package com.youlai.boot.index.service.impl;

import com.youlai.boot.common.constant.SysConfigConstant;
import com.youlai.boot.common.constant.SysGroupConstants;
import com.youlai.boot.index.model.AdminIndexResultVo;
import com.youlai.boot.index.model.FrontIndexResultVo;
import com.youlai.boot.index.service.IndexService;
import com.youlai.boot.system.service.ConfigService;
import com.youlai.boot.system.service.SysGroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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

    @Override
    public FrontIndexResultVo getIndexFrontData() {
        FrontIndexResultVo frontIndexResultVo = new FrontIndexResultVo();
        List<HashMap<String, Object>> listMapByGid = sysGroupDataService.getListMapByGid(SysGroupConstants.GROUP_ID_FRONT_TABBAR);
        List<HashMap<String, Object>> topNav = sysGroupDataService.getListMapByGid(SysGroupConstants.GROUP_ID_TOP_NAV);
        List<HashMap<String, Object>> banner = sysGroupDataService.getListMapByGid(SysGroupConstants.GROUP_ID_INDEX_BANNER);
        List<HashMap<String, Object>> noticeBar = sysGroupDataService.getListMapByGid(SysGroupConstants.GROUP_ID_INDEX_NOTICE_BAR);
        List<HashMap<String, Object>> targetUrl = sysGroupDataService.getListMapByGid(SysGroupConstants.GROUP_ID_INDEX_TARGET_URL);
        String imagePrefix = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MINIO_UPLOAD_DOMAIN); // 添加图片请求前缀
        String shopTitle = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_SHOP_TITLE);
        String shopLogo = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_SHOP_LOGO);
        String systemConfig = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_SHOP_TITLES);
        String shopWebsiteName = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_SHOP_WEBSITE_NAME);
        String shopWebsiteFavicon = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_SHOP_WEBSITE_FAVICON);
        frontIndexResultVo.setTitle(shopTitle);
        frontIndexResultVo.setTitles(systemConfig);
        frontIndexResultVo.setLogo(shopLogo);
        frontIndexResultVo.setTabbar(listMapByGid);
        frontIndexResultVo.setImagePrefix(imagePrefix);
        frontIndexResultVo.setTopNav(topNav);
        frontIndexResultVo.setBanner(banner);
        frontIndexResultVo.setNoticeBar(noticeBar);
        frontIndexResultVo.setTargetUrl(targetUrl);
        frontIndexResultVo.setWebsiteName(shopWebsiteName);
        frontIndexResultVo.setFavicon(shopWebsiteFavicon);
        return frontIndexResultVo;
    }
}
