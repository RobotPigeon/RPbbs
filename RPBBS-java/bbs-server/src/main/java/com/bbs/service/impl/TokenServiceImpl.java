package com.bbs.service.impl;

import com.bbs.domain.User;
import com.bbs.service.ITokenService;
import com.bbs.utils.JJWTUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements ITokenService {
    @Override
    public String getToken(User user) {
        Map map = new HashMap<>();
        map.put("id",user.getId());
        map.put("name",user.getUsername());
        return JJWTUtils.createJWT(map,86400L);
    }
}
