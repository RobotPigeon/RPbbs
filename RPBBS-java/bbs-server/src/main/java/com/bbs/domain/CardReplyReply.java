package com.bbs.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 二级回复帖子对象 card_reply_reply
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Data
public class CardReplyReply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 文本内容 */
    @Excel(name = "文本内容")
    private String message;

    /** 创建者id */
    @Excel(name = "创建者id")
    private String createById;

    /** 从属帖子id */
    @Excel(name = "从属帖子id")
    private String cardId;

    /** 从属回复帖子id */
    @Excel(name = "从属回复帖子id")
    private String replyId;

    /** 回复对象id */
    @Excel(name = "回复对象id")
    private String replyToId;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

}
