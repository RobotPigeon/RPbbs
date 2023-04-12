package com.bbs.domain.fm;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 足球传球数据对象 fm_team_passing
 */
@Data
@TableName("fm_team_passing")
public class FmTeamPassing
{
    private static final long serialVersionUID = 1L;

    /** 自增id */
    private Long id;

    /** 传球总数 */
    private Long TotalCmp;

    /** 传球总次数 */
    private Long TotalAtt;

    /** 传球成功率 */
    private Long TotalCmpP;

    /** 传球总距离 */
    private Long TotalTotDist;

    /** 传球进攻距离 */
    private Long TotalPrgDist;

    /** 短传传球成功次数 */
    private Long ShortCmp;

    /** 短传传球总次数 */
    private Long ShortAtt;

    /** 短传传球成功率 */
    private Long ShortCmpP;

    /** 中传传球成功次数 */
    private Long MediumCmp;

    /** 中传传球总次数 */
    private Long MediumAtt;

    /** 中传传球成功率 */
    private Long MediumCmpP;

    /** 长传传球成功次数 */
    private Long LongCmp;

    /** 长传传球总次数 */
    private Long LongAtt;

    /** 长传传球成功率 */
    private Long LongCmpP;

    /** 助攻次数 */
    private Long Ast;

    /** 预期助攻 */
    private Long xAG;

    /** 助攻价值 */
    private Long xA;

    /** 助攻价值-预期助攻 */
    private Long aXag;

    /** 关键传球次数 */
    private Long KP;

    /** 传球到最后第三区域次数 */
    private Long LastThird;

    /** 每90分钟传球进攻参与次数 */
    private Long PPA;

    /** 每90分钟传中进攻参与次数 */
    private Long CrsPA;

    /** 每90分钟传球进攻距离 */
    private Long PrgP;

}
