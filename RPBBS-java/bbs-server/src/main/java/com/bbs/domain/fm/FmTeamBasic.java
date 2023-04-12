package com.bbs.domain.fm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 对象 fm_team_basic
 */
@Data
@TableName("fm_team_basic")
public class FmTeamBasic
{
    private static final long serialVersionUID = 1L;

    /** 主键自增 */
    private Long id;

    /** 球队名称 */
    private String Squad;

    /** 球员数量 */
    private Long numPl;

    /** 平均年龄 */
    private Long avgAge;

    /** 控球率 */
    private Long Poss;

    /** 比赛场数 */
    @TableField("`MP`")
    private Long MP;

    /** 首发场数 */
    private Long Starts;

    /** 出场时间 */
    private Long Min;

    /** 每90分钟出场时间 */
    @TableField("`Min_90s`")
    private Long min90s;

    /** 进球数 */
    private Long Gls;

    /** 助攻数 */
    private Long Ast;

    /** 进球+助攻数 */
    private Long gA;

    /** 除点球外进球数 */
    private Long gPk;

    /** 点球数 */
    @TableField("`PK`")
    private Long PK;

    /** 点球数 */
    @TableField("`PkAtt`")
    private Long PkAtt;

    /** 预期进球数 */
    @TableField("`xG`")
    private Long xG;

    /** 非点球预期进球数 */
    @TableField("`npxG`")
    private Long npxG;

    /** 传球进攻距离 */
    @TableField("`PrgDist`")
    private Long PrgDist;

    /** 传球进攻距离 */
    @TableField("`PrgPass`")
    private Long PrgPass;

    /** 预期助攻数 */
    @TableField("`xAG`")
    private Long xAG;

    /** 非点球预期进球数+预期助攻数 */
    private Long npxgXag;

    /** 赛事id */
    @TableField("`EventsID`")
    private Long EventsID;

}
