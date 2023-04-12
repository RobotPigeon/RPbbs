package com.bbs.domain.fm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 存储球队其他现对象 fm_team_others
 */
@Data
@TableName("fm_team_others")
public class FmTeamOthers
{
    private static final long serialVersionUID = 1L;

    /** 自增id */
    private Long id;

    /** 黄牌数 */
    private Long CrdY;

    /** 红牌数 */
    private Long CrdR;

    /** 两黄变一红数 */
    @TableField("2CrdY")
    private Long _2CrdY;

    /** 犯规数 */
    private Long Fls;

    /** 被侵犯数 */
    private Long Fld;

    /** 越位数 */
    private Long Off;

    /** 传中数 */
    private Long Crs;

    /** 抢断成功数 */
    private Long TklW;

    /** 争顶成功数 */
    private Long Pkwon;

    /** 争顶失败数 */
    private Long Pkcon;

    /** 乌龙球数 */
    private Long OG;

    /** 抢回球权数 */
    private Long Recov;

    /** 空中争顶成功数 */
    private Long ADWon;

    /** 空中争顶失败数 */
    private Long ADLost;

    /** 拦截次数 */
    private Long nOInt;

    /** 空中对抗成功百分比 */
    private Long ADWP;

}
