package com.bbs.domain.fm;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 对象 fm_player_shooting
 */
@Data
@TableName("fm_player_shooting")
public class FmPlayerShooting
{
    private static final long serialVersionUID = 1L;

    /** 主键自增 */
    private Long id;

    /** 进球数 */
    private Long Gls;

    /** 射门次数 */
    private Long Sh;

    /** 射正次数 */
    private Long SoT;

    /** 射正率 */
    private Long SoTP;

    /** 每90分钟射门次数 */
    private Long sh90;

    /** 每90分钟射正次数 */
    private Long sot90;

    /** 每个进球需要的射门次数 */
    private Long gSh;

    /** 每个进球需要的射正次数 */
    private Long gSot;

    /** 平均射门距离 */
    private Long ADist;

    /** 任意球射门次数 */
    private Long FK;

    /** 点球射门次数 */
    private Long PK;

    /** 点球射门次数 */
    private Long PKatt;

    /** 预期进球数 */
    private Long Xg;

    /** 非点球预期进球数 */
    private Long npxG;

    /** 非点球预期进球率 */
    private Long npxgSh;

    /** 非点球进球数-非点球预期进球数 */
    private Long npGXg;

    /** 进球数-预期进球数 */
    private Long gXg;

}
