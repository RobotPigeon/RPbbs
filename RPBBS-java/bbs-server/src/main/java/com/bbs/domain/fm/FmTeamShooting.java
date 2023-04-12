package com.bbs.domain.fm;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 对象 fm_team_shooting
 */
@Data
@TableName("fm_team_shooting")
public class FmTeamShooting
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Long id;

    /** 进球数 */
    private Long Gls;

    /** 射门数 */
    private Long Sh;

    /** 射正数 */
    private Long SoT;

    /** 射正率 */
    private Long sotP;

    /** 每90分钟射门数 */
    private Long sh90;

    /** 每90分钟射正数 */
    private Long sot90;

    /** 每个进球的射门数 */
    private Long gSh;

    /** 每个进球的射正数 */
    private Long gSot;

    /** 平均射门距离 */
    private Long Dist;

    /** 任意球数 */
    private Long FK;

    /** 点球数 */
    private Long PK;

    /** 点球尝试数 */
    private Long Pkatt;

    /** 预期进球数 */
    private Long xG;

    /** 非点球预期进球数 */
    private Long npxG;

    /** 非点球预期进球率 */
    private Long npxgSh;

    /** 进球数减去预期进球数 */
    private Long gXg;

    /** 非点球进球数减去非点球预期进球数 */
    private Long npGXg;

}
