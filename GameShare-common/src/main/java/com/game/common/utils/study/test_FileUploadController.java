//package com.game.controller;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//
//@RestController
//public class test_FileUploadController {
//
//    @PostMapping("/upload")
//    public String upload(String uid, String uname, MultipartFile photo,
//                         HttpServletRequest request) throws IOException {
//        System.out.println(uid);
//        System.out.println(uname);
//        System.out.println(photo.getOriginalFilename());
//        System.out.println(photo.getContentType());
//
//        String path=request.getServletContext().getRealPath("/upload/");
//        System.out.println(path);
//        saveFile(photo,path);
//        return "上传成功";
//    }
//
//    public void saveFile(MultipartFile photo, String path) throws IOException {
//        File dir=new File(path);
//        if(!dir.exists()){
//            dir.mkdir();
//        }
//        File file=new File(path + photo.getOriginalFilename());
//        photo.transferTo(file);
//    }
//}
