package com.bbs.domain.vo;

import com.bbs.domain.fm.*;
import lombok.Data;

@Data
public class FmPlayerVo extends FmPlayerBasic {

    private FmPlayerDefense playerDefense;

    private FmPlayerGoalkeeping playerGoalkeeping;

    private FmPlayerOthers playerOthers;

    private FmPlayerPassing playerPassing;

    private FmPlayerShooting playerShooting;

    public FmPlayerVo() {}

    public FmPlayerVo(FmPlayerBasic basic) {
        setId(basic.getId());
        setPlayer(basic.getPlayer());
        setPos(basic.getPos());
        setSquad(basic.getSquad());
        setAge(basic.getAge());
        setClub(basic.getClub());
        setBorn(basic.getBorn());
        setMP(basic.getMP());
        setStarts(basic.getStarts());
        setMin(basic.getMin());
        set_90s(basic.get_90s());
        setGls(basic.getGls());
        setAst(basic.getAst());
        setPK(basic.getPK());
        setPkatt(basic.getPkatt());
        setXG(basic.getXG());
        setNpxG(basic.getNpxG());
        setXAG(basic.getXAG());
        setPrgC(basic.getPrgC());
        setPrgP(basic.getPrgP());
        setPrgR(basic.getPrgR());
        setGA(basic.getGA());
        setGPk(basic.getGPk());
        setNpxgXag(basic.getNpxgXag());
        setEventsID(basic.getEventsID());
    }
}
