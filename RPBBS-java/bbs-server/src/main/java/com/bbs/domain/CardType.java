package com.bbs.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 帖子类型对象 card_type
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Data
public class CardType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String typeName;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

}
