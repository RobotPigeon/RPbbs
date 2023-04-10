package com.bbs;

import com.bbs.constant.AdressConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class RPbbsApplication {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(RPbbsApplication.class, args);
        log.info("bbs模块开启！");

        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        AdressConst.httpAdress = AdressConst.httpAdress + ip + ":" + port;
        log.info(AdressConst.httpAdress);
        log.info("\t\n----------------------------------------------------------\n\t" +
                "swagger-ui: \thttp://" + ip + ":" + port + path + "/swagger-ui/index.html\n\t" +
                "----------------------------------------------------------");
    }
}
