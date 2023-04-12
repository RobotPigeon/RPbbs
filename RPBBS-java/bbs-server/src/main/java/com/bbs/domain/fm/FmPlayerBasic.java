package com.bbs.domain.fm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 对象 fm_player_basic
 */
@Data
@TableName("fm_player_basic")
public class FmPlayerBasic
{
    private static final long serialVersionUID = 1L;

    /** 主键自增 */
    private Long id;

    /** 球员名字 */
    private String Player;

    /** 球员位置 */
    private String Pos;

    /** 球队 */
    private String Squad;

    /** 年龄 */
    private Long Age;

    /** 俱乐部 */
    private String Club;

    /** 出生日期 */
    private Long Born;

    /** 出场次数 */
    private Long MP;

    /** 首发次数 */
    private Long Starts;

    /** 出场时间 */
    private Long Min;

    /** 出场时间（90分钟） */
    @TableField("90s")
    private Long _90s;

    /** 进球数 */
    private Long Gls;

    /** 助攻数 */
    private Long Ast;

    /** 点球数 */
    private Long PK;

    /** 点球未进数 */
    private Long Pkatt;

    /** 预期进球数 */
    private Long xG;

    /** 非点球预期进球数 */
    private Long npxG;

    /** 预期助攻数 */
    private Long xAG;

    /** 进攻推进次数 */
    private Long PrgC;

    /** 传球推进次数 */
    private Long PrgP;

    /** 传中推进次数 */
    private Long PrgR;

    /** 总进球数 */
    private Long gA;

    /** 点球进球数 */
    private Long gPk;

    /** 非点球预期进球数+预期助攻数 */
    private Long npxgXag;

    /** 赛事id */
    private Long EventsID;


}
