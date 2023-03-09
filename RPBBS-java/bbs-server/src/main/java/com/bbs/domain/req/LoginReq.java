package com.bbs.domain.req;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 登录验证返回数据体
 */
@Data
@Component
public class LoginReq {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 输入的验证码
     */
    private String code;
    /**
     * 全局唯一id
     */
    private String uuid;

    public LoginReq() {

    }
    public LoginReq(String username, String password, String code, String uuid) {
        this.username = username;
        this.password = password;
        this.code = code;
        this.uuid = uuid;
    }

}
