package com.bbs.service.impl;

import com.bbs.domain.User;
import com.bbs.domain.UserInfo;
import com.bbs.service.IRegisterService;
import com.bbs.service.IUserInfoService;
import com.bbs.service.IUserService;
import com.bbs.utils.DateTimeUtils;
import com.bbs.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Slf4j
@Service
public class RegisterServiceImpl implements IRegisterService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserInfoService userInfoService;

    @Override
    public int addUser(User message) {
        User user = new User();
        user.setUsername(message.getUsername());
        // 账号名查重
        if (userService.selectUserList(user).isEmpty()) {
            user.setPassword(MD5Utils.getHash(message.getPassword()));
            user.setCreateTime(DateTimeUtils.now());
            user.setUpdateTime(user.getCreateTime());
            user.setStatus(0L);
            try {
                userService.insertUser(user);
            }catch (Exception e){
                log.error(e.getMessage());
                return -1;
            }

            // 用户信息初始化
            try {
                User user1 = userService.selectUserList(user).get(0);
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(String.valueOf(user1.getId()));
                userInfo.setLevel(1L);
                userInfoService.insertUserInfo(userInfo);
            }catch (Exception e) {
                log.error(e.getMessage());
            }
            return 0;
        }else {
            return 1;
        }
    }
}
