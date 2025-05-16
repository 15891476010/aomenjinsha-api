package com.youlai.boot.system.service;

import com.youlai.boot.system.model.vo.CloudVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface MinioService {
    void uploadFile(CloudVo cloudVo, String objectName, String localFile, File file);
    String upload(CloudVo cloudVo, MultipartFile file);
}
