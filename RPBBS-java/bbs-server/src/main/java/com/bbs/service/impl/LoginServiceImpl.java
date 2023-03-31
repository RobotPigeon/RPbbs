package com.bbs.service.impl;

import com.bbs.domain.User;
import com.bbs.mapper.UserMapper;
import com.bbs.service.ILoginService;
import com.bbs.service.ITokenService;
import com.bbs.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ITokenService tokenService;

    @Override
    public Map login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(MD5Utils.getHash(password));
        Map<String,Object> map = new HashMap<>();

        try {
            List<User> userList = userMapper.selectUserList(user);
            if (userList.get(0) != null) {
//                return tokenService.getToken(userList.get(0));
                map.put("token",tokenService.getToken(userList.get(0)));
                map.put("user",userList.get(0));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return map;
    }

}
