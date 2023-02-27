package com.bbs.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 user
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Data
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

}
