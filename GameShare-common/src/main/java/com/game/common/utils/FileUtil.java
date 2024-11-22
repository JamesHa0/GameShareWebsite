package com.game.common.utils;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    public static String getFilePath(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("/"));
    }
    public static String getFileType(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }


    public static void saveFile(MultipartFile multipartFile, String path) {
        File dir=new File(path);
        if(!dir.exists()){
            boolean isOk = dir.mkdir();
            if (!isOk) throw new RuntimeException("创建目录失败。文件保存中止。");
        }
        File file=new File(path + multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException("保存(save)文件失败。" + e);
        }
    }
    
    public static Resource downloadFile(String fileName, String path){
        Path filePath = Paths.get(path).resolve(StringUtils.cleanPath(fileName));
        Resource resource;
        try {
            resource = new UrlResource(filePath.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException("即文件路径格式不是一个有效的 URL:" + e);
        }
        if (resource.exists()) {
            return resource;
        } else {
            throw new RuntimeException("待下载的资源(resource)不存在: " + fileName);
        }
    }

}
