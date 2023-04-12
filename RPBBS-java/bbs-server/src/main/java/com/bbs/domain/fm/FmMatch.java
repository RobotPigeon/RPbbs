package com.bbs.domain.fm;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 对象 fm_match
 */
@Data
@TableName("fm_match")
public class FmMatch
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private String id;

    /** 比赛阶段 */
    private String Round;

    /** 比赛日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date Date;

    /** 比赛时间 */
    private String Time;

    /** 主队 */
    private String Home;

    /** 主队预期进球数 */
    private Long homeXg;

    /** 比分 */
    private String Score;

    /** 客队预期进球数 */
    private Long awayXg;

    /** 客队 */
    private String Away;

    /** 观众人数 */
    private Long Attendance;

    /** 比赛场馆 */
    private String Venue;

    /** 裁判 */
    private String Referee;

    /** 备注 */
    private String Notes;

    /** 赛事id */
    private Long EventsID;

}
