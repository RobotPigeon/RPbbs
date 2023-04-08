package com.bbs.controller;

import com.bbs.domain.msg.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@Slf4j
@RequestMapping("bbs/file")
public class FileController {

    //  D:\workspace_oneself\test_\files    File.separator等同于分隔符"\"
    public static Path filePath = Paths.get("D:"+File.separator+"workspace_oneself"+File.separator+"test_"+File.separator+"files");

    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file) throws RuntimeException, IOException {
        // 文件是否为空
        if (file.isEmpty()) {
            return AjaxResult.error("文件不能为空");
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
//        // 获取文件后缀
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        // 上传文件夹路径
//        D:\workspace_oneself\test_
        Path rootPath = FileController.filePath;

        // 路径存在判断
        if (!Files.exists(rootPath)) {
            Files.createDirectories(rootPath);
        }
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs();
//        }

        // 上传路径
        Path path = Paths.get(rootPath+File.separator+fileName);

        try {
            file.transferTo(path);
            log.info("上传成功后的文件路径未：" + path);
            return AjaxResult.success(path);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
        return AjaxResult.error("文件上传失败");
    }

    //文件下载相关代码
    @GetMapping(value = "/download")
    public AjaxResult downloadImage(@RequestParam String fileName, HttpServletRequest request, HttpServletResponse response) {
        // 下载路径
        Path uploadDir = FileController.filePath;

//        File testFile = new File("D:\\workspace_oneself\\test_\\files\\test.txt");
//        log.info(String.valueOf(testFile.exists()));

        File file = new File(uploadDir+File.separator+fileName);

        log.info(String.valueOf(file.exists()));
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition",
                    "attachment;fileName=" + fileName);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                log.info("file :"+fileName+" download succeed!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 关闭流操作
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else {
            return AjaxResult.error("该文件不存在");
        }
        return AjaxResult.success();
    }
}


