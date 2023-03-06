package com.bbs.service.impl;

import com.bbs.service.ICaptchaService;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.image.BufferedImage;

public class CaptchaService implements ICaptchaService {

    @Autowired
    private Producer kaptcha;


    @Override
    public String createCaptcha() {
        String text = kaptcha.createText();
        BufferedImage image = kaptcha.createImage(text);


        return text;
    }

    @Override
    public boolean verify(String captcha) {
        return false;
    }

    public static void main(String[] args) {
        ICaptchaService service = new CaptchaService();
        System.out.println(service.createCaptcha());
    }
}
