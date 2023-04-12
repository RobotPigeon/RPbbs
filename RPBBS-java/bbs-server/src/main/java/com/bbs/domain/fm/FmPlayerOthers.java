package com.bbs.domain.fm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 对象 fm_player_others
 */
@Data
@TableName("fm_player_others")
public class FmPlayerOthers
{
    private static final long serialVersionUID = 1L;

    /** 主键自增 */
    private Long id;

    /** 黄牌数 */
    private Long CrdY;

    /** 红牌数 */
    private Long CrdR;

    /** 两黄变一红次数 */
    @TableField("`2CrdY`")
    private Long _2CrdY;

    /** 犯规数 */
    private Long Fls;

    /** 被犯规数 */
    private Long Fld;

    /** 越位次数 */
    private Long Off;

    /** 传中次数 */
    private Long Crs;

    /** 成功铲断次数 */
    private Long TklW;

    /** 赢得点球次数 */
    private Long Pkwon;

    /** 犯规导致点球次数 */
    private Long Pkcon;

    /** 乌龙球数 */
    private Long OG;

    /** 抢回球权次数 */
    private Long Recov;

    /** 空中争顶成功次数 */
    private Long ADWon;

    /** 空中争顶失败次数 */
    private Long ADLost;

    /** 拦截次数 */
    private Long nOInt;

    /** 空中争顶成功率 */
    private Long ADWP;

}
