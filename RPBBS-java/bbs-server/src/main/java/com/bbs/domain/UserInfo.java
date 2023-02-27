package com.bbs.domain;

import lombok.Data;
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
@Data
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

}
