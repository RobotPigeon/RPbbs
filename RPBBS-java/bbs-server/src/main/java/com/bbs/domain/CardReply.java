package com.bbs.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 回复帖子对象 card_reply
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Data
public class CardReply extends BaseEntity
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

    /** 所在楼层 */
    @Excel(name = "所在楼层")
    private Long rank;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

}