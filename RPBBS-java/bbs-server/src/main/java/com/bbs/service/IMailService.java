package com.bbs.service;

public interface IMailService {

    /**
     * 发送验证邮箱
     * @param mail
     * @return uuid
     */
    public String sendCheckMail(String mail);

    /**
     * 发送简单文章邮箱
     * @param mail
     */
    public void sendSimpleMail(String mail);

    public int verifyAndUpdate(String uuid, String text, String userId);
}
