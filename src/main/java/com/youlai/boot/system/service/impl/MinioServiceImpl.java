package com.youlai.boot.system.service.impl;

import com.youlai.boot.common.exception.UsdtException;
import com.youlai.boot.system.model.vo.CloudVo;
import com.youlai.boot.system.service.MinioService;
import io.minio.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@Service
public class MinioServiceImpl implements MinioService {
    private static final Logger logger = LoggerFactory.getLogger(MinioServiceImpl.class);

    private MinioClient minioClient;

    @Autowired
    public MinioServiceImpl(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Override
    public void uploadFile(CloudVo cloudVo, String objectName, String localFile, File file) {
        if (cloudVo == null || objectName == null || localFile == null || file == null) {
            throw new UsdtException("上传参数不能为空");
        }

        try {
            logger.info("开始上传文件：{}", localFile);

            if (!file.exists()) {
                logger.error("上传文件不存在：{}", localFile);
                throw new UsdtException("上传文件不存在：" + localFile);
            }

            ObjectWriteResponse response = minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket(cloudVo.getBucketName())
                            .object(objectName)
                            .filename(localFile)
                            .build()
            );

            logger.info("文件上传成功：{}", response.object());

        } catch (Exception ex) {
            logger.error("MinIO上传失败: {}", ex.getMessage(), ex);
            throw new UsdtException("MinIO上传失败: " + ex.getMessage());
        }
    }

    private void initMinio(CloudVo cloudVo) {
        minioClient = MinioClient.builder()
                .endpoint(cloudVo.getBucketName())
                .credentials(cloudVo.getAccessKey(), cloudVo.getSecretKey())
                .build();
    }

    @Override
    public String upload(CloudVo cloudVo, MultipartFile file) {

        logger.debug("尝试上传文件，路径: {}, 文件名: {}, 大小: {}",
                file, file.getName(), file.getSize());

        try {
            // 生成带日期的文件路径
            String dateFolder = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
                    .format(new Date()) + "/";

            // 获取文件扩展名
            String originalFileName = file.getName();
            String extension = getFileExtension(originalFileName);

            // 生成唯一文件名
            String objectName = dateFolder + UUID.randomUUID().toString() + extension;

            // 获取文件内容类型
            String contentType = file.getContentType();
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

//            initMinio(cloudVo);
//
//            // 确保 bucket 存在
            ensureBucketExists(cloudVo);

            // 上传文件到 MinIO
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(cloudVo.getBucketName())
                            .object(objectName)
                            .contentType(contentType)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .build()
            );

            // 构造并返回文件URL
            String fileUrl = String.format("/%s/%s",
                    cloudVo.getBucketName(),
                    objectName);

            logger.info("文件上传成功：{}", fileUrl);
            return fileUrl;

        } catch (IOException ex) {
            String errorMsg = "读取文件输入流失败: " + ex.getMessage();
            logger.error(errorMsg, ex);
            throw new UsdtException(errorMsg);
        } catch (Exception ex) {
            String errorMsg = "MinIO 文件上传失败: " + ex.getMessage();
            logger.error(errorMsg, ex);
            throw new UsdtException(errorMsg);
        }
    }

    private String getFileExtension(String fileName) {
        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf("."));
        }
        return "";
    }

    private void ensureBucketExists(CloudVo cloudVo) throws Exception {
        boolean bucketExists = minioClient.bucketExists(
                BucketExistsArgs.builder()
                        .bucket(cloudVo.getBucketName())
                        .build()
        );
        if (!bucketExists) {
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(cloudVo.getBucketName())
                            .build()
            );
            logger.info("创建存储桶成功: {}", cloudVo.getBucketName());
        }
    }

    // 可选：检查目录是否存在（如果确实需要）
    private boolean isFolderExist(CloudVo cloudVo, String directoryPath) throws Exception {
        StatObjectResponse stat = null;
        try {
            stat = minioClient.statObject(
                    StatObjectArgs.builder()
                            .bucket(cloudVo.getBucketName())
                            .object(directoryPath)
                            .build()
            );
            return stat != null;
        } catch (Exception e) {
            return false;
        }
    }
}
