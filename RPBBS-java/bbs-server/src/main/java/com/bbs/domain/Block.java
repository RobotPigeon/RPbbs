package com.bbs.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


/**
 * 帖子板块对象 block
 * 
 * @author wws
 * @date 2023-02-27
 */
@Data
@TableName(value = "bbs_block")
public class Block
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 板块名 */
    private String blockName;

    /** 图片资源路径 */
    private String picPath;

    /** 状态 */
    private Long status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
