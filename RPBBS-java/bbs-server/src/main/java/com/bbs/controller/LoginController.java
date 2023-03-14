package com.bbs.controller;

import com.bbs.domain.msg.AjaxResult;
import com.bbs.domain.req.LoginReq;
import com.bbs.service.ICaptchaService;
import com.bbs.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录验证
 */

@RestController
@RequestMapping("/bbs/login")
@CrossOrigin
public class LoginController {
    @Autowired
    private ILoginService loginService;

    @Autowired
    private ICaptchaService captchaService;


    @PostMapping("/check")
    public AjaxResult login(@RequestBody LoginReq loginReq) {
        int res = captchaService.verify(loginReq.getUuid(), loginReq.getCode());
        String token = loginService.login(loginReq.getUsername(), loginReq.getPassword());

        switch (res){
            case 0:{
                return token != null ? AjaxResult.success("登录成功", new HashMap<String, String>(){{put("token", token);}}) : AjaxResult.error("账号密码错误");
            }
            case 1:{
                return AjaxResult.error("验证码验证失败");
            }
            default:{}
        }
        return AjaxResult.error("unknown err");
    }

    /**
     * 获取验证码，建议之后整理进业务层 控制层获取data(map)返回
     * @param
     * @return
     */
    @GetMapping(path = "/kaptcha/get")
    public AjaxResult getKaptcha() {
//        // 生成验证码
//        String text = kaptchaProducer.createText();
//        BufferedImage image = kaptchaProducer.createImage(text);
//        UUID uuid = UUID.randomUUID();
//
//        // 转换流信息写出
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        try
//        {
//            ImageIO.write(image, "png", os);
//        }
//        catch (IOException e)
//        {
//            Logger.getLogger(this.getClass().getName()).warning(e.getMessage());
//        }
//
//        Logger.getLogger(this.getClass().getName()).info("text:" + text + " uuid:" + uuid);
//
//
//
//        // 存入redis缓存
//        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
//
//        valueOperations.set(String.valueOf(uuid), text, 60, TimeUnit.SECONDS);
//        Logger.getLogger(this.getClass().getName()).info("to save in redis...");
//
//
//        byte[] bytes = os.toByteArray();
////        BASE64Encoder encoder = new BASE64Encoder();
////        String image_base64 = encoder.encodeBuffer(bytes).trim();
////        String finalImage_base6 = image_base64.replaceAll("\n","").replaceAll("\r","");
//        String finalImage_base6 = Base64.getEncoder().encodeToString(os.toByteArray());
//
//        Logger.getLogger(this.getClass().getName()).info("imageStr:" + finalImage_base6);
        Map data= captchaService.createCaptchaAndUuid();

        return !data.isEmpty() ? AjaxResult.success().put("data", data) : AjaxResult.error("验证码获取错误") ;
    }

//    /**
//     * 流式传输 验证码
//     * @param response
//     * @param session
//     */
//    @RequestMapping("/getCaptImg")
//    public void  getCaptImg(HttpServletResponse response, HttpSession session){
//        // 生成验证码
//        String text = kaptchaProducer.createText();
//        BufferedImage image = kaptchaProducer.createImage(text);
//        UUID uuid = UUID.randomUUID();
//
//        try {
//            response.setContentType("image/png");
//            OutputStream os = response.getOutputStream();
//            ImageIO.write(image,"png",os);
//        } catch (IOException e) {
//            System.out.println("响应验证码失败"+e.getMessage());
//        }
//    }

//    @PostMapping("/kaptcha/verify")
//    public AjaxResult verifyChaptcha(@RequestBody LoginReq loginReq){
//        int res = captchaService.verify(loginReq.getUuid(), loginReq.getCode());
//        switch (res) {
//            case 0:{
//                return AjaxResult.success();
//            }
//            case 1:{
//                return AjaxResult.error("验证码验证失败").put("chaptcha_err_type", res);
//            } default:{}
//        }
//        return AjaxResult.error("unknow err");
//    }
}
