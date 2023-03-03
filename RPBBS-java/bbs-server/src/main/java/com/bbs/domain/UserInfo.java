package com.bbs.domain;

import lombok.Data;

/**
 * 用户信息对象 user_info
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Data
public class UserInfo
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 关联用户id */
    private String userId;

    /** 用户等级 */
    private Long level;

    /** 用户简讯 */
    private String message;

    /** 用户头像资源路径 */
    private String avatarPath;

}
