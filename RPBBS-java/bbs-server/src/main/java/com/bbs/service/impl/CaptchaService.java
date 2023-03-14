package com.bbs.service.impl;

import com.bbs.service.ICaptchaService;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class CaptchaService implements ICaptchaService {

    @Autowired
    private Producer kaptchaProducer;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public Map createCaptchaAndUuid() {
        // 返回结果
        Map resultMap = new HashMap<String, String>();
//        String resultStr;

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
            log.error(e.getMessage());
        }

//        Logger.getLogger(this.getClass().getName()).info("text:" + text + " uuid:" + uuid);

        // 存入redis缓存
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        // 验证码过期时间为60s
        valueOperations.set(String.valueOf(uuid), text, 60, TimeUnit.SECONDS);
        log.info("create captcha: { uuid: "+uuid+"\ttext: "+text+" } and save in redis now.");
//        Logger.getLogger(this.getClass().getName()).info("{ uuid: "+uuid+" text: "+text+" }"+" --to save in redis");

        // base64编码
        byte[] bytes = os.toByteArray();
//        BASE64Encoder encoder = new BASE64Encoder();
//        String image_base64 = encoder.encodeBuffer(bytes).trim();
//        String finalImage_base6 = image_base64.replaceAll("\n","").replaceAll("\r","");
//        String finalImage_base6 = Base64.getEncoder().encodeToString(os.toByteArray());
//        Logger.getLogger(this.getClass().getName()).info("imageStr:" + finalImage_base6);

        resultMap.put("uuid", uuid);
        resultMap.put("image", Base64.getEncoder().encodeToString(os.toByteArray()));

//        resultStr = "{uuid:"+uuid+",image:"+Base64.getEncoder().encodeToString(os.toByteArray())+"}";

        return resultMap;
    }

    @Override
    public int verify(String uuid, String text) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String textInRedis = (String) valueOperations.get(uuid);

//        Logger.getLogger(this.getClass().getName()).info("verify: the value of " + uuid+" get in redis is *"+textInRedis+"*");
        if (textInRedis.equals(text)) {
            log.info(uuid+" : verified pass.");
            return 0;
        }
        return 1;
    }

}
