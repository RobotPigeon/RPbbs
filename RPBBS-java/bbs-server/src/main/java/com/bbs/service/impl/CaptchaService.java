package com.bbs.service.impl;

import com.bbs.service.ICaptchaService;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
public class CaptchaService implements ICaptchaService {

    @Autowired
    private Producer kaptchaProducer;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public String createCaptchaAndUuid() {
        // 返回结果
        String resultStr;

        // 生成验证码
        String text = kaptchaProducer.createText();
        BufferedImage image = kaptchaProducer.createImage(text);
        UUID uuid = UUID.randomUUID();

        // 流转换
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try
        {
            ImageIO.write(image, "png", os);
        }
        catch (IOException e)
        {
            Logger.getLogger(this.getClass().getName()).warning(e.getMessage());
        }

//        Logger.getLogger(this.getClass().getName()).info("text:" + text + " uuid:" + uuid);

        // 存入redis缓存
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        // 验证码过期时间为60s
        valueOperations.set(String.valueOf(uuid), text, 60, TimeUnit.SECONDS);
        Logger.getLogger(this.getClass().getName()).info("{ uuid: "+uuid+" text: "+text+" }"+" --to save in redis");

        // base64编码
        byte[] bytes = os.toByteArray();
//        BASE64Encoder encoder = new BASE64Encoder();
//        String image_base64 = encoder.encodeBuffer(bytes).trim();
//        String finalImage_base6 = image_base64.replaceAll("\n","").replaceAll("\r","");
//        String finalImage_base6 = Base64.getEncoder().encodeToString(os.toByteArray());
//        Logger.getLogger(this.getClass().getName()).info("imageStr:" + finalImage_base6);

        resultStr = "{uuid:"+uuid+",image:"+Base64.getEncoder().encodeToString(os.toByteArray())+"}";

        return resultStr;
    }

    @Override
    public int verify(String uuid, String text) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String textInRedis = (String) valueOperations.get(uuid);

        Logger.getLogger(this.getClass().getName()).info("verify: the value of " + uuid+" get in redis is *"+textInRedis+"*");
        if (textInRedis.equals(text)) {
            return 0;
        }
        return 1;
    }

}
