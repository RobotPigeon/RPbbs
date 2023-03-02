package com.bbs.service;

import com.bbs.domain.User;

public interface ITokenService {
    public String getToken(User user);
}
