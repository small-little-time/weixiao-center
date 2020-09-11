package com.zjw.graduation.controller.com;


import com.zjw.graduation.mvc.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@Api(value = "adm.FileUpload", tags = {"文件上传"})
public class FileUpload {

    @Value("${file.path}")
    private String path;
    @Value("${file.server}")
    private String server;
    @Value("${file.pattern}")
    private String pattern;

    @PostMapping("/upload")
    public JsonResult reciveCameraCapture(@RequestParam("file") MultipartFile file) {
        if (file == null) {
            return JsonResult.success("null");
        }

        // 保存图片
        String filename = file.getOriginalFilename();
        if (filename == null){
            return JsonResult.success("null");
        }

        File fileUrl = new File(path);

        if (!fileUrl.exists()) {
            fileUrl.mkdirs();
        }
        filename = UUID.randomUUID().toString().replaceAll("-", "") + "-" +  filename;
        String destFilename = filename;
        File destImage = new File(fileUrl, destFilename);
        try {
            file.transferTo(destImage);
            return JsonResult.success("success", server + pattern + "/" + filename);
        } catch (IOException e) {
            return JsonResult.error("图片保存失败");
        }
    }
}
