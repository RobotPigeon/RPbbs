package com.bbs.domain;

import lombok.Data;
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
@Data
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

}
