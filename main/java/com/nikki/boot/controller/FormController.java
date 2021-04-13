package com.nikki.boot.controller;

import com.nikki.boot.Utils.UploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传功能
 */
@Controller
//@RequestPart:获取表单文件项
@Slf4j
public class FormController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "forms/form_layouts";
    }
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("email={},username={},照片大小={},附件数量={}",
                email,username,headerImg.getSize(),photos.length);
        File fileDir = UploadUtils.getImgDirFile();
        if(!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            File newFile = new File(fileDir.getAbsolutePath() + File.separator + originalFilename);
            headerImg.transferTo(newFile);
        }
        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    File newFile = new File(fileDir.getAbsolutePath() + File.separator + originalFilename);
                    photo.transferTo(newFile);
                }
            }
        }
        return "main";
    }
}
