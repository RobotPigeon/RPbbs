package com.bbs.service.impl;

import com.bbs.service.ICaptchaService;
import com.bbs.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MailServiceImpl implements IMailService {

    @Autowired
    private ICaptchaService captchaService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendCheckMail(String mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        Map<String, String> captchaMap = captchaService.createText();
        String message = "您的验证码为：\n\t"+captchaMap.get("text")+"\n请在5分钟进行验证.";

        simpleMailMessage.setFrom("2038240310@qq.com");
        simpleMailMessage.setTo(mail);
        simpleMailMessage.setSubject("邮箱验证");
        simpleMailMessage.setText(message);

        javaMailSender.send(simpleMailMessage);

        return captchaMap.get("uuid");
    }

    @Override
    public void sendSimpleMail(String mail) {

    }

    @Override
    public int verifyAndUpdate(String uuid, String text, String userId) {
        return 0;
    }


}
