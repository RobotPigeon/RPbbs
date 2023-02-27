package com.bbs.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 帖子板块对象 block
 * 
 * @author wws
 * @date 2023-02-27
 */
@Data
public class Block extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 板块名 */
    @Excel(name = "板块名")
    private String blockName;

    /** 图片资源路径 */
    @Excel(name = "图片资源路径")
    private String picPath;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

}
