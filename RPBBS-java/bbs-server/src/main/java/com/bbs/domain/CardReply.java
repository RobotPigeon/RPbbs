package com.bbs.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 回复帖子对象 card_reply
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Data
@TableName(value = "bbs_card_reply")
public class CardReply
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

    /** 所在楼层 */
    @TableField("`rank`")
    private Long rank;

    /** 状态 */
    private Long status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public CardReply() {}

    public CardReply(Long id, String message, String createById, String cardId, Long rank, Long status, Date createTime, Date updateTime) {
        this.id = id;
        this.message = message;
        this.createById = createById;
        this.cardId = cardId;
        this.rank = rank;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
