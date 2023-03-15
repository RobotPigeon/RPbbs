package com.bbs.domain.req;

import lombok.Data;

@Data
public class CaptchaReq {

    /**
     * uuid
     */
    private String uuid;

    /**
     * 验证码
     */
    private String text;
}
