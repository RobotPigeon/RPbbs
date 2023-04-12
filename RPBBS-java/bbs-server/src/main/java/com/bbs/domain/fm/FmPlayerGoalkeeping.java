package com.bbs.domain.fm;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 对象 fm_player_goalkeeping
 */
@Data
@TableName("fm_player_goalkeeping")
public class FmPlayerGoalkeeping
{
    private static final long serialVersionUID = 1L;

    /** 主键自增 */
    private Long id;

    /** 失球数 */
    private Long GA;

    /** 每90分钟失球数 */
    private Long GA90;

    /** 对手射门次数 */
    private Long SoTA;

    /** 扑救次数 */
    private Long Saves;

    /** 扑救率 */
    private Long SaveP;

    /** 胜场数 */
    private Long W;

    /** 平场数 */
    private Long D;

    /** 负场数 */
    private Long L;

    /** 零封数 */
    private Long CS;

    /** 零封率 */
    private Long csP;

    /** 点球次数 */
    private Long PKatt;

    /** 对手点球数 */
    private Long PKA;

    /** 扑出点球数 */
    private Long PKsv;

    /** 被点球破门数 */
    private Long PKm;

    /** 扑出点球率 */
    private Long pksvP;

}
