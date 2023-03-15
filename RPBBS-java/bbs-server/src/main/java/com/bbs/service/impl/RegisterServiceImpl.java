package com.bbs.service.impl;

import com.bbs.domain.User;
import com.bbs.mapper.UserMapper;
import com.bbs.service.IRegisterService;
import com.bbs.utils.DateTimeUtils;
import com.bbs.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegisterServiceImpl implements IRegisterService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User message) {
        User user = new User();
        user.setUsername(message.getUsername());
        // 账号名查重
        if (!userMapper.selectUserList(user).isEmpty()) {
            return 1;
        }else {
            user.setPassword(MD5Utils.getHash(message.getPassword()));
            user.setCreateTime(DateTimeUtils.now());
            user.setUpdateTime(user.getCreateTime());
            user.setStatus(0L);
            try {
                userMapper.insertUser(user);
            }catch (Exception e){
                log.error(e.getMessage());
                return -1;
            }
            return 0;
        }
    }
}
