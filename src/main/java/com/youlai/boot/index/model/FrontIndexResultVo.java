package com.youlai.boot.index.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@Schema(description = "管理端全局配置字段返回对象")
public class FrontIndexResultVo {
    @Schema(description = "所有图片请求前缀")
    private String imagePrefix;
    @Schema(description = "底部tabbar")
    private List<HashMap<String, Object>> tabbar;
    @Schema(description = "顶部导航栏")
    private List<HashMap<String, Object>> topNav;
    @Schema(description = "首页banner")
    private List<HashMap<String, Object>> banner;
    @Schema(description = "首页滚动公告")
    private List<HashMap<String, Object>> noticeBar;
    @Schema(description = "首页跳转链接")
    private List<HashMap<String, Object>> targetUrl;
    @Schema(description = "商城标题")
    private String title;
    @Schema(description = "商城logo")
    private String logo;
    @Schema(description = "商城副标题")
    private String titles;
    @Schema(description = "商城网站名称")
    private String websiteName;
    @Schema(description = "商城网站图标")
    private String favicon;
}
