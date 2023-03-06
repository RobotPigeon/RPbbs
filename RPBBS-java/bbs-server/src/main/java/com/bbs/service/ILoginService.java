package com.bbs.service;

import com.bbs.domain.User;

public interface ILoginService {

    /**
     * 账号密码验证成功，返回一段token，否则返回空字符串
     * @param username
     * @param password
     * @return
     */
    public String login(String username, String password);

}
