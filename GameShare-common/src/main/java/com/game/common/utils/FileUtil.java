package com.game.common.utils;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class FileUtil {

    public static void saveFile(MultipartFile multipartFile, Path path) {
        // 确保目录存在
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            throw new RuntimeException("创建目录失败。文件保存中止。", e);
        }

        File file=new File(path.toFile(), Objects.requireNonNull(multipartFile.getOriginalFilename()));
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException("保存文件失败。" + e);
        }
    }
    
    public static Resource downloadFile(String fileName, Path path){
        Path filePath = path.resolve(StringUtils.cleanPath(fileName));
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
