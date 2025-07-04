package com.youlai.boot.system.controller;

import cn.idev.excel.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.model.entity.Attachment;
import com.youlai.boot.system.model.vo.FileResultVo;
import com.youlai.boot.system.service.AttachmentService;
import com.youlai.boot.system.service.UploadService;
import com.youlai.boot.system.service.UrlUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.system.model.form.AttachmentForm;
import com.youlai.boot.system.model.query.AttachmentQuery;
import com.youlai.boot.common.result.Result;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 附件管理前端控制层
 *
 * @author MrZhang
 * @since 2025-05-13 13:06
 */
@Tag(name = "附件管理接口")
@RestController
@RequestMapping("/api/v1/attachment")
@RequiredArgsConstructor
public class AttachmentController  {

    private final AttachmentService attachmentService;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private UrlUploadService urlUploadService;

    @Operation(summary = "附件管理分页列表")
    @PostMapping("/page")
    @PreAuthorize("@ss.hasPerm('system:attachment:query')")
    public Result<Page<Attachment>> getAttachmentPage(@RequestBody AttachmentQuery queryParams) {
        Page<Attachment> result = attachmentService.getAttachmentPage(queryParams);
        return Result.success(result);
    }

    @Operation(summary = "文件上传")
    @PostMapping("/upload")
    @PreAuthorize("@ss.hasPerm('system:attachment:upload')")
    public Result<FileResultVo> saveAttachment(MultipartFile file,
                                               @RequestParam(value = "model") String model,
                                               @RequestParam(value = "pid") Integer pid) throws IOException {
        FileResultVo fileResultVo = uploadService.imageUpload(file, model, pid);
        return Result.success(fileResultVo);
    }

    @Operation(summary = "通过url上传文件")
    @PostMapping("/urlUpload")
    @PreAuthorize("@ss.hasPerm('system:attachment:upload')")
    public Result<FileResultVo> saveAttachment(
            @RequestParam("url") String url,
            @RequestParam("model") String model,
            @RequestParam("pid") Integer pid) throws Exception {

        // 参数校验
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("URL参数不能为空");
        }
        FileResultVo fileResultVo = urlUploadService.imageUrlUpload(url, model, pid);
        return Result.success(fileResultVo);
    }

    @Operation(summary = "获取附件管理表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('system:attachment:edit')")
    public Result<AttachmentForm> getAttachmentForm(
            @Parameter(description = "附件管理ID") @PathVariable Long id
    ) {
        AttachmentForm formData = attachmentService.getAttachmentFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改附件管理")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('system:attachment:edit')")
    public Result<Void> updateAttachment(
            @Parameter(description = "附件管理ID") @PathVariable Long id,
            @RequestBody @Validated AttachmentForm formData
    ) {
        boolean result = attachmentService.updateAttachment(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除附件管理")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('system:attachment:delete')")
    public Result<Void> deleteAttachments(
            @Parameter(description = "附件管理ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = attachmentService.deleteAttachments(ids);
        return Result.judge(result);
    }

    @Operation(summary = "根据文件名模糊查询url")
    @GetMapping("/{name}")
    public Result<String> getAttachment(@PathVariable String name) {
        String fileUrlByFileName = attachmentService.getFileUrlByFileName(name);
        return Result.success(fileUrlByFileName);
    }
}
