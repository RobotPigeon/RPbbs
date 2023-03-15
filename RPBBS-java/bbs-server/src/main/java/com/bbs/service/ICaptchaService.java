package com.bbs.service;

import java.util.Map;

public interface ICaptchaService {
    /**
     * 生成验证码图片
     * 返回的内包含uuid和图片的base64格式数据
     * @return Map
     */
    public Map createCaptchaAndUuid();

    /**
     * 生成验证码文字、uuid
     * @return Map
     */
    public Map createText();

    /**
     * 验证
     * @param uuid
     * @param text
     * @return
     */
    public int verify(String uuid, String text);
}
