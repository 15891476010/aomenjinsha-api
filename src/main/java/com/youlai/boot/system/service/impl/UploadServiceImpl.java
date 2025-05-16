package com.youlai.boot.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.youlai.boot.common.constant.SysConfigConstant;
import com.youlai.boot.common.exception.UsdtException;
import com.youlai.boot.system.model.entity.Attachment;
import com.youlai.boot.system.model.vo.CloudVo;
import com.youlai.boot.system.model.vo.FileResultVo;
import com.youlai.boot.system.model.vo.UploadCommonVo;
import com.youlai.boot.system.service.AttachmentService;
import com.youlai.boot.system.service.ConfigService;
import com.youlai.boot.system.service.MinioService;
import com.youlai.boot.system.service.UploadService;
import com.youlai.boot.utils.DateUtil;
import com.youlai.boot.utils.MrZhangUtil;
import com.youlai.boot.utils.UploadUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Autowired
    private ConfigService configService;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private MinioService minioService;
    /**
     * 图片上传
     * @param multipartFile 文件
     * @param model 模块 用户user,商品product,微信wechat,news文章
     * @param pid 分类ID 0编辑器,1商品图片,2拼团图片,3砍价图片,4秒杀图片,5文章图片,6组合数据图,7前台用户,8微信系列
     * @return FileResultVo
     */
    @Override
    public FileResultVo imageUpload(MultipartFile multipartFile, String model, Integer pid) throws IOException {
        if (null == multipartFile || multipartFile.isEmpty()) {
            throw new UsdtException("上传的文件对象不存在...");
        }

        String extStr = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_FILE_UPLOAD_IMAGE_EXT);
        int size = Integer.parseInt(configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_FILE_UPLOAD_IMAGE_MAX_SIZE));
        String type = "/";

        UploadCommonVo uploadCommonVo = new UploadCommonVo();
        uploadCommonVo.setExtStr(extStr);
        uploadCommonVo.setSize(size);
        uploadCommonVo.setType(type);

        // 文件名
        String fileName = multipartFile.getOriginalFilename();
        System.out.println("fileName = " + fileName);
        // 文件后缀名
        String extName = FilenameUtils.getExtension(fileName);
        if (StringUtils.isEmpty(extName)) {
            throw new RuntimeException("文件类型未定义不能上传...");
        }

        if (fileName.length() > 99) {
            fileName = StrUtil.subPre(fileName, 90).concat(".").concat(extName);
        }

        // 文件大小验证
        // 文件分隔符转化为当前系统的格式
        float fileSize = (float)multipartFile.getSize() / 1024 / 1024;
        String fs = String.format("%.2f", fileSize);
        if( fileSize > uploadCommonVo.getSize()){
            throw new UsdtException("最大允许上传" + uploadCommonVo.getSize() + " MB的文件, 当前文件大小为 " + fs + " MB");
        }

        // 判断文件的后缀名是否符合规则
        if (StringUtils.isNotEmpty(uploadCommonVo.getExtStr())) {
            // 切割文件扩展名
            List<String> extensionList = MrZhangUtil.stringToArrayStr(uploadCommonVo.getExtStr());
            if (extensionList.size() > 0) {
                //判断
                if (!extensionList.contains(extName)) {
                    throw new UsdtException("上传文件的类型只能是：" + uploadCommonVo.getExtStr());
                }
            } else {
                throw new UsdtException("上传文件的类型只能是：" + uploadCommonVo.getExtStr());
            }
        }

        // 变更文件名
        String newFileName = UploadUtil.fileName(extName);
        // 创建目标文件的名称，规则：  子目录/年/月/日.后缀名
        // 文件分隔符转化为当前系统的格式
        // 文件分隔符转化为当前系统的格式
        String webPath = uploadCommonVo.getType() + uploadCommonVo.getModelPath() + DateUtil.nowDate(SysConfigConstant.DATE_FORMAT_DATE).replace("-", "/") + "/";
        String destPath = FilenameUtils.separatorsToSystem(uploadCommonVo.getRootPath() + webPath) + newFileName;

        // 拼装返回的数据
        FileResultVo resultFile = new FileResultVo();
        resultFile.setFileSize(multipartFile.getSize());
        resultFile.setFileName(fileName);
        resultFile.setExtName(extName);
//        resultFile.setServerPath(destPath);
        resultFile.setUrl(webPath + newFileName);
        resultFile.setType(multipartFile.getContentType());

        CloudVo cloudVo = new CloudVo();

        resultFile.setType(resultFile.getType().replace("image/", ""));
        Attachment Attachment = new Attachment();
        Attachment.setName(resultFile.getFileName());
//        Attachment.setAttDir(resultFile.getUrl());
        Attachment.setSattDir(resultFile.getUrl());
        Attachment.setAttSize(resultFile.getFileSize().toString());
        Attachment.setAttType(resultFile.getType());
        Attachment.setImageType(1);   //图片上传类型 1本地 2七牛云 3OSS 4COS, 默认本地
//        Attachment.setAttDir(resultFile.getServerPath()); // 服务器上存储的绝对地址， 上传到云的时候使用
        Attachment.setPid(pid);
        Attachment.setImageType(5);

        cloudVo.setDomain(configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MINIO_UPLOAD_DOMAIN));
        cloudVo.setAccessKey(configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MINIO_UPLOAD_ACCESS_KEY));
        cloudVo.setSecretKey(configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MINIO_UPLOAD_SECRET_KEY));
        cloudVo.setBucketName(configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_MINIO_UPLOAD_BUCKET_NAME));
        try {
            String minioUrl = minioService.upload(cloudVo, multipartFile);
            Attachment.setSattDir(minioUrl);
            resultFile.setUrl(minioUrl);
            logger.info("MinIO upload success: {}", minioUrl);
        } catch (Exception e) {
            logger.error("MinIO upload failed: {}", e.getMessage());
            throw new UsdtException("MinIO upload failed: " + e.getMessage());
        }
        attachmentService.save(Attachment);
        return resultFile;
    }

    /**
     * 文件长传
     * @param multipartFile 文件
     * @param model 模块 用户user,商品product,微信wechat,news文章
     * @param pid 分类ID 0编辑器,1商品图片,2拼团图片,3砍价图片,4秒杀图片,5文章图片,6组合数据图,7前台用户,8微信系列
     * @return FileResultVo
     * @throws IOException
     */
    @Override
    public FileResultVo fileUpload(MultipartFile multipartFile, String model, Integer pid) throws IOException {
//        String rootPath = (crmebConfig.getImagePath() + "/").replace(" ", "").replace("//", "/");
//        UploadUtil.setModelPath(model);
//        String modelPath = "public/" + model + "/";
//        String extStr = configService.getSystemConfig(SysConfigConstant.UPLOAD_FILE_EXT_STR_CONFIG_KEY);
//        int size = Integer.parseInt(configService.getSystemConfig(SysConfigConstant.UPLOAD_FILE_MAX_SIZE_CONFIG_KEY));
//        String type = SysConfigConstant.UPLOAD_TYPE_FILE + "/";
//
//        UploadCommonVo uploadCommonVo = new UploadCommonVo();
//        uploadCommonVo.setRootPath(rootPath);
//        uploadCommonVo.setModelPath(modelPath);
//        uploadCommonVo.setExtStr(extStr);
//        uploadCommonVo.setSize(size);
//        uploadCommonVo.setType(type);
//
//        if (null == multipartFile || multipartFile.isEmpty()) {
//            throw new UsdtException("上传的文件对象不存在...");
//        }
//        // 文件名
//        String fileName = multipartFile.getOriginalFilename();
//        System.out.println("fileName = " + fileName);
//        // 文件后缀名
//        String extName = FilenameUtils.getExtension(fileName);
//        if (StringUtils.isEmpty(extName)) {
//            throw new RuntimeException("文件类型未定义不能上传...");
//        }
//
//        if (fileName.length() > 99) {
//            fileName = StrUtil.subPre(fileName, 90).concat(".").concat(extName);
//        }
//
//        //文件大小验证
//        // 文件分隔符转化为当前系统的格式
//        float fileSize = (float)multipartFile.getSize() / 1024 / 1024;
//        String fs = String.format("%.2f", fileSize);
//        if( fileSize > uploadCommonVo.getSize()){
//            throw new UsdtException("最大允许上传" + uploadCommonVo.getSize() + " MB的文件, 当前文件大小为 " + fs + " MB");
//        }
//
//        // 判断文件的后缀名是否符合规则
////        isContains(extName);
//        if (StringUtils.isNotEmpty(uploadCommonVo.getExtStr())) {
//            // 切割文件扩展名
//            List<String> extensionList = CrmebUtil.stringToArrayStr(uploadCommonVo.getExtStr());
//
//            if (extensionList.size() > 0) {
//                //判断
//                if (!extensionList.contains(extName)) {
//                    throw new UsdtException("上传文件的类型只能是：" + uploadCommonVo.getExtStr());
//                }
//            } else {
//                throw new UsdtException("上传文件的类型只能是：" + uploadCommonVo.getExtStr());
//            }
//        }
//
//        //文件名
//        String newFileName = UploadUtil.fileName(extName);
//        // 创建目标文件的名称，规则请看destPath方法
//        //规则：  子目录/年/月/日.后缀名
//        // 文件分隔符转化为当前系统的格式
//        // 文件分隔符转化为当前系统的格式
//        String webPath = uploadCommonVo.getType() + uploadCommonVo.getModelPath() + DateUtil.nowDate(SysConfigConstant.DATE_FORMAT_DATE).replace("-", "/") + "/";
//        String destPath = FilenameUtils.separatorsToSystem(uploadCommonVo.getRootPath() + webPath) + newFileName;
//        // 创建文件
//        File file = UploadUtil.createFile(destPath);
//
//        // 拼装返回的数据
//        FileResultVo resultFile = new FileResultVo();
//        resultFile.setFileSize(multipartFile.getSize());
//        resultFile.setFileName(fileName);
//        resultFile.setExtName(extName);
////        resultFile.setServerPath(destPath);
//        resultFile.setUrl(webPath + newFileName);
//        resultFile.setType(multipartFile.getContentType());
//
//        //图片上传类型 1本地 2七牛云 3OSS 4COS, 默认本地
//        String uploadType = configService.getSystemConfigException("uploadType");
//        Integer uploadTypeInt = Integer.parseInt(uploadType);
//        String pre;
//        CloudVo cloudVo = new CloudVo();
//
//        resultFile.setType(resultFile.getType().replace("file/", ""));
//        Attachment Attachment = new Attachment();
//        Attachment.setName(resultFile.getFileName());
//        Attachment.setSattDir(resultFile.getUrl());
//        Attachment.setAttSize(resultFile.getFileSize().toString());
//        Attachment.setAttType(resultFile.getType());
//        Attachment.setImageType(1);   //图片上传类型 1本地 2七牛云 3OSS 4COS, 默认本地，任务轮询数据库放入云服务
//        Attachment.setPid(pid);
//
//        if (uploadTypeInt.equals(1)) {
//            // 保存文件
//            multipartFile.transferTo(file);
//            AttachmentService.save(Attachment);
//            return resultFile;
//        }
//        // 判断是否保存本地
//        String fileIsSave = configService.getSystemConfigException("file_is_save");
//        if ("1".equals(fileIsSave)) {
//            multipartFile.transferTo(file);
//        }
//
//        switch (uploadTypeInt) {
//            case 1:
//                // 保存文件
//                multipartFile.transferTo(file);
//                break;
//            case 2:
//                Attachment.setImageType(2);
//                pre = "qn";
//                cloudVo.setDomain(configService.getSystemConfigException(pre+"UploadUrl"));
//                cloudVo.setAccessKey(configService.getSystemConfigException(pre+"AccessKey"));
//                cloudVo.setSecretKey(configService.getSystemConfigException(pre+"SecretKey"));
//                cloudVo.setBucketName(configService.getSystemConfigException(pre+"StorageName"));
//                cloudVo.setRegion(configService.getSystemConfigException(pre+"StorageRegion"));
//
//                try{
//                    // 构造一个带指定Zone对象的配置类, 默认华东
//                    Configuration cfg = new Configuration(Region.huadong());
//                    if("huabei".equals(cloudVo.getRegion())){
//                        cfg = new Configuration(Region.huabei());
//                    }
//                    if("huanan".equals(cloudVo.getRegion())){
//                        cfg = new Configuration(Region.huanan());
//                    }
//                    if("beimei".equals(cloudVo.getRegion())){
//                        cfg = new Configuration(Region.beimei());
//                    }
//                    if("dongnanya".equals(cloudVo.getRegion())){
//                        cfg = new Configuration(Region.xinjiapo());
//                    }
//
//                    // 其他参数参考类注释
//                    UploadManager uploadManager = new UploadManager(cfg);
//                    // 生成上传凭证，然后准备上传
//                    Auth auth = Auth.create(cloudVo.getAccessKey(), cloudVo.getSecretKey());
//                    String upToken = auth.uploadToken(cloudVo.getBucketName());
//
//                    String webPathQn = crmebConfig.getImagePath();
//                    logger.info("AsyncServiceImpl.qCloud.id " + Attachment.getAttId());
//                    qiNiuService.uploadFile(uploadManager, cloudVo, upToken,
//                            Attachment.getSattDir(), webPathQn + "/" + Attachment.getSattDir(), file);
//                }catch (Exception e){
//                    logger.error("AsyncServiceImpl.qCloud.fail " + e.getMessage());
//                }
//                break;
//            case 3:
//                Attachment.setImageType(3);
//                pre = "al";
//                cloudVo.setDomain(configService.getSystemConfigException(pre+"UploadUrl"));
//                cloudVo.setAccessKey(configService.getSystemConfigException(pre+"AccessKey"));
//                cloudVo.setSecretKey(configService.getSystemConfigException(pre+"SecretKey"));
//                cloudVo.setBucketName(configService.getSystemConfigException(pre+"StorageName"));
//                cloudVo.setRegion(configService.getSystemConfigException(pre+"StorageRegion"));
//                try{
//                    String webPathAl = crmebConfig.getImagePath();
//                    logger.info("AsyncServiceImpl.oss.id " + Attachment.getAttId());
//                    ossService.upload(cloudVo, Attachment.getSattDir(),  webPathAl + "/" + Attachment.getSattDir(),
//                            file);
//                }catch (Exception e){
//                    logger.error("AsyncServiceImpl.oss fail " + e.getMessage());
//                }
//                break;
//            case 4:
//                Attachment.setImageType(4);
//                pre = "tx";
//                cloudVo.setDomain(configService.getSystemConfigException(pre+"UploadUrl"));
//                cloudVo.setAccessKey(configService.getSystemConfigException(pre+"AccessKey"));
//                cloudVo.setSecretKey(configService.getSystemConfigException(pre+"SecretKey"));
//                cloudVo.setBucketName(configService.getSystemConfigException(pre+"StorageName"));
//                cloudVo.setRegion(configService.getSystemConfigException(pre+"StorageRegion"));
//                // 1 初始化用户身份信息(secretId, secretKey)
//                COSCredentials cred = new BasicCOSCredentials(cloudVo.getAccessKey(), cloudVo.getSecretKey());
//                // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
//                ClientConfig clientConfig = new ClientConfig(new com.qcloud.cos.region.Region(cloudVo.getRegion()));
//                // 3 生成 cos 客户端。
//                COSClient cosClient = new COSClient(cred, clientConfig);
//
//                try{
//                    String webPathTx = crmebConfig.getImagePath();
//                    logger.info("AsyncServiceImpl.cos.id " + Attachment.getAttId());
//                    cosService.uploadFile(cloudVo, Attachment.getSattDir(), webPathTx + "/" + Attachment.getSattDir(), file, cosClient);
//                }catch (Exception e){
//                    logger.error("AsyncServiceImpl.cos.fail " + e.getMessage());
//                }finally {
//                    cosClient.shutdown();
//                }
//                break;
//        }
//        AttachmentService.save(Attachment);
//        return resultFile;
        return null;
    }
}
