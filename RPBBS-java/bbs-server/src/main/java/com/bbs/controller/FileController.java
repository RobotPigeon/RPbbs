package com.bbs.controller;

import com.bbs.domain.msg.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@Slf4j
@RequestMapping("bbs/file")
public class FileController {

    @PostMapping("/upload")
    public AjaxResult upload(@RequestBody MultipartFile file) throws RuntimeException {
        if (file.isEmpty()) {
            return AjaxResult.error("文件不能为空");
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        // 上传路径
        String filePath = "";

        File dest = new File(filePath+fileName);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            log.info("上传成功后的文件路径未：" + filePath + fileName);
            return AjaxResult.success(fileName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
        return AjaxResult.error("文件上传失败");
    }

    //文件下载相关代码
    @GetMapping(value = "/download")
    public String downloadImage(String fileName, HttpServletRequest request, HttpServletResponse response) {
        //String fileName = "123.JPG";
        log.debug("the fileName is : "+fileName);

        // 下载路径
        String uploadDir = "";

        String fileUrl = uploadDir+fileName;
        if (fileUrl != null) {
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
           /* String realPath = request.getServletContext().getRealPath(
                    "//WEB-INF//");*/
            /*File file = new File(realPath, fileName);*/
            File file = new File(fileUrl);
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
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
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
            }
        }
        return null;
    }
}


