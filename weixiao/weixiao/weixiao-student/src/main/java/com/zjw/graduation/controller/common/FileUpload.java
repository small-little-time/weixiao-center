package com.zjw.graduation.controller.common;

import com.zjw.graduation.mvc.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@Api(value = "common.FileUpload", tags = {"文件上传"})
public class FileUpload {

    @Value("${file.path}")
    private String path;
    @Value("${file.server}")
    private String server;
    @Value("${file.pattern}")
    private String pattern;

    @PostMapping("/upload")
    public JsonResult receiveCameraCapture(@RequestParam("id") Long id,
                                           @RequestParam("file") MultipartFile file) {
        String pathUrl = path + id + "\\";
        if (file == null) {
            return JsonResult.success("null");
        }

        // 保存图片
        String filename = file.getOriginalFilename();
        if (filename == null){
            return JsonResult.success("null");
        }

        File fileUrl = new File(pathUrl);

        if (!fileUrl.exists()) {
            fileUrl.mkdir();
        }
        filename = UUID.randomUUID().toString().replaceAll("-", "") + "-" +  filename;
        String destFilename = filename;
        File destImage = new File(fileUrl, destFilename);
        try {
            file.transferTo(destImage);
            return JsonResult.success("success", server + pattern + "/" + id + "/" + filename);
        } catch (IOException e) {
            return JsonResult.error("图片保存失败");
        }
    }
}
