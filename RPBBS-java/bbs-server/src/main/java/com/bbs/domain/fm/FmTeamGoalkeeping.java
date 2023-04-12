package com.bbs.domain.fm;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 球队守门员现对象 fm_team_goalkeeping
 */
@Data
@TableName("fm_team_goalkeeping")
public class FmTeamGoalkeeping
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 出场次数 */
    private Long starts;

    /** 出场时间 */
    private Long min;

    /** 失球数 */
    private Long GA;

    /** 每90分钟失球数 */
    private Long GA90;

    /** 扑救数 */
    private Long SoTa;

    /** 扑救成功数 */
    private Long Saves;

    /** 扑救成功率 */
    private Long saveP;

    /** 胜场数 */
    private Long w;

    /** 平场数 */
    private Long d;

    /** 负场数 */
    private Long l;

    /** 零封数 */
    private Long CS;

    /** 零封率 */
    private Long csP;

    /** 点球数 */
    private Long pkatt;

    /** 点球进球数 */
    private Long pka;

    /** 点球扑救数 */
    private Long pksv;

    /** 点球被射中数 */
    private Long pkm;

    /** 点球扑救率 */
    private Long pksvP;

}
