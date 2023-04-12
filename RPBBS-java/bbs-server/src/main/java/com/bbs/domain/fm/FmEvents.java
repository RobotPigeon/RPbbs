package com.bbs.domain.fm;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 对象 fm_events
 */
@Data
@TableName("fm_events")
public class FmEvents
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 赛事名称 */
    private String eventName;

    /** 赛事冠军 */
    private String eventChampion;

    /** 赛事开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date eventStartTime;

    /** 赛事结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date eventEndTime;

    /** 举办地点 */
    private String eventLocation;

}
