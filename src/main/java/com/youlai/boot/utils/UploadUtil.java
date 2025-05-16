package com.youlai.boot.utils;

import cn.hutool.core.util.RandomUtil;

public class UploadUtil {
    public static String fileName(String extName){
        return MrZhangUtil.getUuid() + RandomUtil.randomString(10) + "." + extName;
    }
}
