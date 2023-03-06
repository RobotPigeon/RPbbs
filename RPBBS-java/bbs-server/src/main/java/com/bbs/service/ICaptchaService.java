package com.bbs.service;

public interface ICaptchaService {
    public String createCaptcha();
    public boolean verify(String captcha);
}
