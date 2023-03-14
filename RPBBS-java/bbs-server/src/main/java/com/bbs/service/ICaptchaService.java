package com.bbs.service;

import java.util.Map;

public interface ICaptchaService {
    public Map createCaptchaAndUuid();
    public int verify(String uuid, String text);
}
