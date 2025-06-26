package com.youlai.boot.common.constant;

public class SysConfigConstant {
    /**
     * minio上传配置
     */
    public static final String CONFIG_KEY_MINIO_UPLOAD_DOMAIN = "minioUploadUrl"; // minio上传域名
    public static final String CONFIG_KEY_MINIO_UPLOAD_BUCKET_NAME = "minioBucket"; // minio上传bucketName
    public static final String CONFIG_KEY_MINIO_UPLOAD_ENDPOINT = "minioEndpoint"; // minio上传endpoint
    public static final String CONFIG_KEY_MINIO_UPLOAD_ACCESS_KEY = "minioAccessKey"; // minio上传accessKey
    public static final String CONFIG_KEY_MINIO_UPLOAD_SECRET_KEY = "minioSecretKey"; // minio上传secretKey

    /**
     * 文件上传基础配置
     */
    public static final String CONFIG_KEY_FILE_UPLOAD_IMAGE_EXT = "image_ext_str"; // 图片文件允许扩展名
    public static final String CONFIG_KEY_FILE_UPLOAD_IMAGE_MAX_SIZE = "image_max_size"; // 图片文件最大大小
    public static final String CONFIG_KEY_FILE_UPLOAD_FILE_EXT = "file_ext_str"; // 普通文件允许扩展名
    public static final String CONFIG_KEY_FILE_UPLOAD_FILE_MAX_SIZE = "file_max_size"; // 普通文件最大大小

    /**
     * 日期格式化配置
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String DATE_FORMAT_DATE = "yyyy-MM-dd";
    public static final String DATE_FORMAT_YEAR = "yyyy";
    public static final String DATE_FORMAT_MONTH_DATE = "MM-dd";
    public static final String DATE_FORMAT_MONTH = "yyyy-MM";
    public static final String DATE_TIME_FORMAT_NUM = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_NUM = "yyyyMMdd";
    public static final String DATE_FORMAT_START = "yyyy-MM-dd 00:00:00";
    public static final String DATE_FORMAT_END = "yyyy-MM-dd 23:59:59";
    public static final String DATE_FORMAT_MONTH_START = "yyyy-MM-01 00:00:00";
    public static final String DATE_FORMAT_YEAR_START = "yyyy-01-01 00:00:00";
    public static final String DATE_FORMAT_YEAR_END = "yyyy-12-31 23:59:59";
    public static final String DATE_FORMAT_HHMMSS = "HH:mm:ss";
    public static final String DATE_FORMAT_START_PEREND = "00:00:00";
    public static final String DATE_FORMAT_END_PEREND = "23:59:59";
    public static final String DATE_FORMAT_HHMM = "yyyy-MM-dd HH:mm";

    /**
     * 时间转换
     */
    public static final String SEARCH_DATE_DAY = "today"; //今天
    public static final String SEARCH_DATE_YESTERDAY = "yesterday"; //昨天
    public static final String SEARCH_DATE_LATELY_7 = "lately7"; //最近7天
    public static final String SEARCH_DATE_LATELY_30 = "lately30"; //最近30天
    public static final String SEARCH_DATE_WEEK = "week"; //本周
    public static final String SEARCH_DATE_PRE_WEEK = "preWeek"; //上周
    public static final String SEARCH_DATE_MONTH = "month"; //本月
    public static final String SEARCH_DATE_PRE_MONTH = "preMonth"; //上月
    public static final String SEARCH_DATE_YEAR = "year"; //年
    public static final String SEARCH_DATE_PRE_YEAR = "preYear"; //上一年
    // 时间类型开始时间
    public static String DATE_TIME_TYPE_BEGIN = "begin";

    // 时间类型结束时间
    public static String DATE_TIME_TYPE_END = "end";

    // 游戏配置
    public static final String CONFIG_KEY_GAME_PROVIDER = "gameProvider"; // 游戏供应商
    public static final String CONFIG_KEY_MERCHANT_ID = "merchantId"; // 商户ID
    public static final String CONFIG_KEY_MERCHANT_SECRET = "merchantSecret"; // 商户密钥
    public static final String CONFIG_KEY_API_URL = "apiUrl";
    public static final String CONFIG_KEY_CURRENCY = "currency"; // 货币类型
    public static final String CONFIG_KEY_LANGUAGE  = "language"; // 语言

    // newNg游戏商户配置
    public static final String CONFIG_KEY_NEW_NG_MERCHANT_ID = "newNgMerchantId"; // 新游戏商户ID
    public static final String CONFIG_KEY_NEW_NG_MERCHANT_SECRET = "newNgSecretKey"; // 新游戏商户密钥
    public static final String CONFIG_KEY_NEW_NG_API_URL = "newNgApiUrl"; // 新游戏商户apiUrl
    public static final String CONFIG_KEY_NEW_NG_CURRENCY = "newNgCurrency"; // 新游戏商户货币类型
    public static final String CONFIG_KEY_NEW_NG_SN  = "newNgSn"; // 新游戏商户前缀
    public static final String CONFIG_KEY_NEW_NG_RETURN_URL  = "newNgReturnUrl"; // 新游戏商户回调地址
    public static final String CONFIG_KEY_NEW_NG_LANGUAGE  = "newNgLanguage"; // 新游戏商户语言

    // 美盛游戏商户配置
    public static final String CONFIG_KEY_MS_API_URL = "msApiUrl"; // 美盛游戏商户apiUrl
    public static final String CONFIG_KEY_MS_MERCHANT_ID = "msAccount"; // 美盛游戏商户ID
    public static final String CONFIG_KEY_MS_MERCHANT_SECRET = "msApiKey"; // 美盛游戏商户密钥

    // 商城基础配置
    public static final String CONFIG_KEY_SHOP_TITLE = "title"; // 商城标题
    public static final String CONFIG_KEY_SHOP_LOGO = "logo"; // 商城logo
    public static final String CONFIG_KEY_SHOP_TITLES = "titles"; // 商城副标题
    public static final String CONFIG_KEY_SHOP_WEBSITE_NAME = "websiteName"; // 商城网址名称
    public static final String CONFIG_KEY_SHOP_WEBSITE_FAVICON = "favicon"; // 商城网站图标

    // 验证码配置
    public static final String CONFIG_KEY_CAPTCHA_TYPE = "captchaType"; // 验证码类型
    public static final String CONFIG_KEY_CAPTCHA_WIDTH = "width"; // 验证码宽度
    public static final String CONFIG_KEY_CAPTCHA_HEIGHT = "height"; // 验证码高度
    public static final String CONFIG_KEY_CAPTCHA_INTERFERE_COUNT = "interfaceCount"; // 验证码干扰线数量
    public static final String CONFIG_KEY_CAPTCHA_TEXT_ALPHA = "textAlpha"; // 验证码透明度
    public static final String CONFIG_KEY_CAPTCHA_EXPIRE_SECONDS = "expireSeconds"; // 验证码过期时间
    public static final String CONFIG_KEY_CAPTCHA_CODE_TYPE = "codeType"; // 验证码类型
    public static final String CONFIG_KEY_CAPTCHA_CODE_LENGTH = "codeLength"; // 验证码长度
    public static final String CONFIG_KEY_CAPTCHA_FONT_NAME = "fontName"; // 验证码字体
    public static final String CONFIG_KEY_CAPTCHA_FONT_WEIGHT = "fontWeight"; // 验证码字体
    public static final String CONFIG_KEY_CAPTCHA_FONT_SIZE = "fontSize"; // 验证码字体大小
}
