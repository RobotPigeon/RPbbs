package com.bbs.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 二级回复帖子对象 card_reply_reply
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Data
@TableName(value = "bbs_card_reply_reply")
public class CardReplyReply
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 文本内容 */
    private String message;

    /** 创建者id */
    private String createById;

    /** 从属帖子id */
    private String cardId;

    /** 从属回复帖子id */
    private String replyId;

    /** 回复对象id */
    private String replyToId;

    /** 状态 */
    private Long status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
