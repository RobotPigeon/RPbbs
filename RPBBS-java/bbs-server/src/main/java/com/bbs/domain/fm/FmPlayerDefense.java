package com.bbs.domain.fm;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 对象 fm_player_defense
 */
@Data
@TableName("fm_player_defense")
public class FmPlayerDefense
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Long id;

    /** 抢断 */
    private Long Tkl;

    /** 抢断成功 */
    private Long TklW;

    /** 争抢抢断 */
    private Long CTkl;

    /** 争抢次数 */
    private Long Catt;

    /** 争抢抢断成功率 */
    private Long CTklP;

    /** 争抢抢断失败 */
    private Long CTklL;

    /** 封堵射门 */
    private Long Blocks;

    /** 射门被封堵 */
    private Long ShotBlock;

    /** 传球被封堵 */
    private Long PassBlock;

    /** 抢断和拦截 */
    private Long tklInt;

    /** 解围 */
    private Long Clear;

    /** 失误 */
    private Long Err;

    /** 防守第三区 */
    private Long def3rd;

    /** 中场第三区 */
    private Long mid3rd;

    /** 进攻第三区 */
    private Long att3rd;

    /** 拦截 */
    private Long nOint;

}
