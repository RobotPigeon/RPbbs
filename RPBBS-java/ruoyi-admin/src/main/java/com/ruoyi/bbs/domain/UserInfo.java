package com.ruoyi.bbs.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户信息对象 user_info
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
public class UserInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 关联用户id */
    @Excel(name = "关联用户id")
    private String userId;

    /** 用户等级 */
    @Excel(name = "用户等级")
    private Long level;

    /** 用户简讯 */
    @Excel(name = "用户简讯")
    private String message;

    /** 用户头像资源路径 */
    @Excel(name = "用户头像资源路径")
    private String avatarPath;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setLevel(Long level) 
    {
        this.level = level;
    }

    public Long getLevel() 
    {
        return level;
    }
    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
    }
    public void setAvatarPath(String avatarPath) 
    {
        this.avatarPath = avatarPath;
    }

    public String getAvatarPath() 
    {
        return avatarPath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("level", getLevel())
            .append("message", getMessage())
            .append("avatarPath", getAvatarPath())
            .toString();
    }
}
