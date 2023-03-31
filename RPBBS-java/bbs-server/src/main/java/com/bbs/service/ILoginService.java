package com.bbs.service;

import java.util.Map;

public interface ILoginService {

    /**
     * 账号密码验证成功，返回一段token，否则返回空字符串
     * @param username
     * @param password
     * @return
     */
    public Map login(String username, String password);

}
