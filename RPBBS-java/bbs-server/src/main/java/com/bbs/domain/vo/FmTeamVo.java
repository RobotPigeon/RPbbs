package com.bbs.domain.vo;

import com.bbs.domain.fm.*;
import lombok.Data;

import java.util.List;

@Data
public class FmTeamVo extends FmTeamBasic {

    private FmTeamDefense teamDefense;

    private FmTeamGoalkeeping teamGoalkeeping;

    private FmTeamOthers teamOthers;

    private FmTeamPassing teamPassing;

    private FmTeamShooting teamShooting;

    private List<FmPlayerBasic> playerBasicList;

    public FmTeamVo() {}

    public FmTeamVo(FmTeamBasic basic) {
        setId(basic.getId());
        setSquad(basic.getSquad());
        setNumPl(basic.getNumPl());
        setAvgAge(basic.getAvgAge());
        setPoss(basic.getPoss());
        setMP(basic.getMP());
        setStarts(basic.getStarts());
        setMin(basic.getMin());
        setMin90s(basic.getMin90s());
        setGls(basic.getGls());
        setAst(basic.getAst());
        setGA(basic.getGA());
        setGPk(basic.getGPk());
        setPK(basic.getPK());
        setPkAtt(basic.getPkAtt());
        setXG(basic.getXG());
        setNpxG(basic.getNpxG());
        setPrgDist(basic.getPrgDist());
        setPrgPass(basic.getPrgPass());
        setXAG(basic.getXAG());
        setNpxgXag(basic.getNpxgXag());
        setEventsID(basic.getEventsID());
    }

}
