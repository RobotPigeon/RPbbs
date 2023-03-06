package com.bbs.service.impl;

import com.bbs.domain.User;
import com.bbs.mapper.UserMapper;
import com.bbs.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements IRegisterService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(String message) {
        //message内容暂且不明，之后处理

        User user = new User();
        int result = userMapper.insertUser(user);
        return result>0 ? true : false ;
    }
}
