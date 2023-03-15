package com.bbs.service;

import com.bbs.domain.User;

public interface IRegisterService {

    /**
     * 注册添加用户
     * @return
     */
    public int addUser(User message);
}
