package com.bbs.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class FileUtils {

    public static Path filePath = Paths.get("D:"+File.separator+"workspace_oneself"+File.separator+"test_"+File.separator+"files");
//    public static Path filePath = Paths.get(System.getProperty("user.dir")+File.separator+"files");

    public static String upload(MultipartFile file) {
        // 文件是否为空
        if (file.isEmpty()) {
            return null;
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf(".")).replace(".","");

        fileName = System.currentTimeMillis() + "." + fileSuffix;

        // 上传文件夹路径
        // D:\workspace_oneself\test_
        Path rootPath = Paths.get(filePath + File.separator);

        // 路径存在判断
        if (!Files.exists(rootPath)) {
            try {
                Files.createDirectories(rootPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 上传文件路径
        Path path = Paths.get(rootPath + File.separator + fileName);

        try {
            file.transferTo(path);
            log.info("上传成功后的服务器本地文件路径为：" + path);
            Path urlPath = Paths.get(File.separator+"img"+File.separator+fileName);
            log.info("映射网址路径："+urlPath);

            return String.valueOf(urlPath);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
