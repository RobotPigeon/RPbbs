package com.bbs.config;

import com.bbs.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
@EnableWebMvc
@Slf4j
public class FilePathConfig implements WebMvcConfigurer {

    private String uploadPathImg = String.valueOf(FileUtils.filePath);
//    private String uploadPathImg = String.valueOf(FileUtils.filePath).replace("\\","\\\\");

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        log.info(uploadPathImg);
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:" + uploadPathImg + "\\");
    }
}
