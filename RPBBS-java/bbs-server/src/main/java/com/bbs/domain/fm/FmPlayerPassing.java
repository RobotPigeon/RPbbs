package com.bbs.domain.fm;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 对象 fm_player_passing
 */
@Data
@TableName("fm_player_passing")
public class FmPlayerPassing
{
    private static final long serialVersionUID = 1L;

    /** 主键自增 */
    private Long id;

    /** 传球成功次数 */
    private Long TotalCmp;

    /** 传球总次数 */
    private Long TotalAtt;

    /** 传球成功率 */
    private Long TotalCmpP;

    /** 传球总距离 */
    private Long TotalTotDist;

    /** 传球进攻距离 */
    private Long TotalPrgDist;

    /** 短传成功次数 */
    private Long ShortCmp;

    /** 短传总次数 */
    private Long ShortAtt;

    /** 短传成功率 */
    private Long ShortCmpP;

    /** 中传成功次数 */
    private Long MediumCmp;

    /** 中传总次数 */
    private Long MediumAtt;

    /** 中传成功率 */
    private Long MediumCmpP;

    /** 长传成功次数 */
    private Long LongCmp;

    /** 长传总次数 */
    private Long LongAtt;

    /** 长传成功率 */
    private Long LongCmpP;

    /** 助攻次数 */
    private Long Ast;

    /** 预期助攻数 */
    private Long xAG;

    /** 预期传球成功次数 */
    private Long xA;

    /** 助攻数-预期助攻数 */
    private Long aXag;

    /** 关键传球次数 */
    private Long KP;

    /** 进攻第三区域传球次数 */
    private Long LastThird;

    /** 进攻第三区域传球成功次数 */
    private Long PPA;

    /** 传中成功次数 */
    private Long CrsPA;

    /** 传球进攻距离 */
    private Long PrgP;

}
