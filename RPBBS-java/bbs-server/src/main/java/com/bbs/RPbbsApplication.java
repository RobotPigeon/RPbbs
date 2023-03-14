package com.bbs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RPbbsApplication {
    public static void main(String[] args) {
        SpringApplication.run(RPbbsApplication.class, args);
        log.info("bbs模块开启！");

    }
}
