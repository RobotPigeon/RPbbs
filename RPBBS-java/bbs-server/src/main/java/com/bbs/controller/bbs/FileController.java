package com.bbs.controller.bbs;

import com.bbs.domain.msg.AjaxResult;
import com.bbs.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
        String filePath = FileUtils.upload(file);
        return filePath == null ? AjaxResult.error("上传失败") : AjaxResult.success(filePath);
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


