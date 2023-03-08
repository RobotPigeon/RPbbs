package com.bbs.controller;

import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.ILoginService;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;


/**
 * 登录验证
 */

@RestController
@RequestMapping("/bbs/login")
@CrossOrigin
public class LoginController {
    @Autowired
    ILoginService loginService;

    @Autowired
    private Producer kaptchaProducer;


    @GetMapping("/login")
    public AjaxResult login(@RequestParam("username") String username, @RequestParam("password") String password) {
        String token = loginService.login(username, password);
        return token != null ? AjaxResult.success("登录成功", new HashMap<String, String>(){{put("token", token);}}) : AjaxResult.error();
    }


    /**
     * 获取验证码，建议之后整理进业务层 控制层获取data(map)返回
     * @param response
     * @return
     */
    @GetMapping(path = "/kaptcha")
    public AjaxResult getKaptcha(HttpServletResponse response/*, HttpSession session*/) {
        // 生成验证码
        String text = kaptchaProducer.createText();
        BufferedImage image = kaptchaProducer.createImage(text);
        UUID uuid = UUID.randomUUID();

        // 存入redis缓存


        return AjaxResult.success().put("data", new HashMap<String,Object>(){{
            put("image", Base64.getEncoder().encode(image.toString().getBytes(StandardCharsets.UTF_8)));
            put("uuid",uuid);
        }});
    }

    /**
     * 流式传输 验证码
     * @param response
     * @param session
     */
    @RequestMapping("/getCaptImg")
    public void  getCaptImg(HttpServletResponse response, HttpSession session){
        // 生成验证码
        String text = kaptchaProducer.createText();
        BufferedImage image = kaptchaProducer.createImage(text);
        UUID uuid = UUID.randomUUID();

        try {
            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            ImageIO.write(image,"png",os);
        } catch (IOException e) {
            System.out.println("响应验证码失败"+e.getMessage());
        }
    }
}
