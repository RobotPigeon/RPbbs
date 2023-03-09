package com.bbs.service;

public interface ICaptchaService {
    public String createCaptchaAndUuid();
    public int verify(String uuid, String text);
}
