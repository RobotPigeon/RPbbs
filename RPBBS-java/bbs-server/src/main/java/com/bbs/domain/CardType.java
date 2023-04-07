package com.bbs.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 帖子类型对象 card_type
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Data
@TableName(value = "bbs_card_type")
public class CardType
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 类型名称 */
    private String typeName;

    /** 状态 */
    private Long status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
