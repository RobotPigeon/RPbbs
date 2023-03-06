package com.ruoyi.bbs.domain;

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

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
    }
    public void setCreateById(String createById) 
    {
        this.createById = createById;
    }

    public String getCreateById() 
    {
        return createById;
    }
    public void setCardId(String cardId) 
    {
        this.cardId = cardId;
    }

    public String getCardId() 
    {
        return cardId;
    }
    public void setReplyId(String replyId) 
    {
        this.replyId = replyId;
    }

    public String getReplyId() 
    {
        return replyId;
    }
    public void setReplyToId(String replyToId) 
    {
        this.replyToId = replyToId;
    }

    public String getReplyToId() 
    {
        return replyToId;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("message", getMessage())
            .append("createById", getCreateById())
            .append("cardId", getCardId())
            .append("replyId", getReplyId())
            .append("replyToId", getReplyToId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .toString();
    }
}
