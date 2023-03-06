package com.ruoyi.bbs.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 帖子对象 card
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
public class Card extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 文本内容 */
    @Excel(name = "文本内容")
    private String message;

    /** 创建者id */
    @Excel(name = "创建者id")
    private String createById;

    /** 所属板块id */
    @Excel(name = "所属板块id")
    private String blockId;

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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
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
    public void setBlockId(String blockId) 
    {
        this.blockId = blockId;
    }

    public String getBlockId() 
    {
        return blockId;
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
            .append("title", getTitle())
            .append("message", getMessage())
            .append("createById", getCreateById())
            .append("blockId", getBlockId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .toString();
    }
}
