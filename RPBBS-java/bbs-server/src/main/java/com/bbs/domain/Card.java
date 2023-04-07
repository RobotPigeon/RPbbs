package com.bbs.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 帖子对象 card
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Data
@TableName(value = "bbs_card")
public class Card
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 标题 */
    private String title;

    /** 文本内容 */
    private String message;

    /** 创建者id */
    private String createById;

    /** 所属板块id */
    private String blockId;

    /** 状态 */
    private Long status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
