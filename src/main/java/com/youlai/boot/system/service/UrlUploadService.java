package com.youlai.boot.system.service;

import com.youlai.boot.system.model.vo.FileResultVo;

public interface UrlUploadService {
    FileResultVo imageUrlUpload(String url, String model, Integer pid) throws Exception;
    FileResultVo urlUploadName(String url, String model, Integer pid,String name) throws Exception;
}
