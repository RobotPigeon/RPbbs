package com.ruoyi.bbs.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 帖子信息对象 card_info
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
public class CardInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 相关帖子id */
    @Excel(name = "相关帖子id")
    private String cardId;

    /** 帖子类型 */
    @Excel(name = "帖子类型")
    private String cardTypeId;

    /** 喜欢数量 */
    @Excel(name = "喜欢数量")
    private Long likeNum;

    /** 富文本 */
    @Excel(name = "富文本")
    private String richtext;

    /** 资源路径 */
    @Excel(name = "资源路径")
    private String sourcePath;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCardId(String cardId) 
    {
        this.cardId = cardId;
    }

    public String getCardId() 
    {
        return cardId;
    }
    public void setCardTypeId(String cardTypeId) 
    {
        this.cardTypeId = cardTypeId;
    }

    public String getCardTypeId() 
    {
        return cardTypeId;
    }
    public void setLikeNum(Long likeNum) 
    {
        this.likeNum = likeNum;
    }

    public Long getLikeNum() 
    {
        return likeNum;
    }
    public void setRichtext(String richtext) 
    {
        this.richtext = richtext;
    }

    public String getRichtext() 
    {
        return richtext;
    }
    public void setSourcePath(String sourcePath) 
    {
        this.sourcePath = sourcePath;
    }

    public String getSourcePath() 
    {
        return sourcePath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cardId", getCardId())
            .append("cardTypeId", getCardTypeId())
            .append("likeNum", getLikeNum())
            .append("richtext", getRichtext())
            .append("sourcePath", getSourcePath())
            .toString();
    }
}
