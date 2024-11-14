package com.game.web;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class test_FileUploadController {

    @PostMapping("/upload")
    public String upload(String uid, String uname, MultipartFile photo,
                         HttpServletRequest request) throws IOException {
        System.out.println(uid);
        System.out.println(uname);
        System.out.println(photo.getOriginalFilename());
        System.out.println(photo.getContentType());

        String path="D:\\GameShare\\uploadGames";
        System.out.println(path);
        saveFile(photo,path);
        return "上传成功";
    }

    public void saveFile(MultipartFile photo, String path) throws IOException {
        File dir=new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }
        File file=new File(path + photo.getOriginalFilename());
        photo.transferTo(file);
    }

    @GetMapping(value="/upload")
    public String hello(String name, String psw, HttpServletRequest request) {
        String path=request.getServletContext().getRealPath("/upload/");
        System.out.println("/upload 地址为："+path);
        return "Hello World! "+path;
    }
}
