package com.bbs.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.fm.FmPlayerBasic;
import com.bbs.domain.fm.FmTeamBasic;
import com.bbs.domain.vo.FmTeamVo;
import com.bbs.mapper.*;
import com.bbs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FmTeamExtensionServiceImpl implements IFmTeamExtensionService {

    @Autowired
    private IFmTeamBasicService fmTeamBasicService;

    @Autowired
    private IFmTeamDefenseService fmTeamDefenseService;

    @Autowired
    private IFmTeamGoalkeepingService fmTeamGoalkeepingService;

    @Autowired
    private IFmTeamOthersService fmTeamOthersService;

    @Autowired
    private IFmTeamPassingService fmTeamPassingService;

    @Autowired
    private IFmTeamShootingService fmTeamShootingService;

    @Autowired
    private IFmPlayerBasicService fmPlayerBasicService;

    @Autowired
    private FmTeamTotalMapper fmTeamTotalMapper;

    @Override
    public List<FmPlayerBasic> selectFmPlayerBasicByFmTeamBasicSquad(String param) {
        // 传参判断
        if (param == null || param.isEmpty()) {
            return null;
        }

        FmPlayerBasic fmPlayerBasic = new FmPlayerBasic();
        fmPlayerBasic.setSquad(param);
        List<FmPlayerBasic> list = fmPlayerBasicService.selectFmPlayerBasicList(fmPlayerBasic);

        return list;
    }

    @Override
    public List<FmTeamVo> selectFmTeamVoListWithFmplayerBasic() {
//        List<FmTeamVo> list = fmTeamTotalMapper.selectFmTeamVoListWithFmPlayerBasic();
        List<FmTeamBasic> fmTeamBasics = fmTeamBasicService.selectFmTeamBasicList(new FmTeamBasic());
        List<FmTeamVo> list = new ArrayList<>();
        for (FmTeamBasic basic : fmTeamBasics) {
            list.add(new FmTeamVo(basic));
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setTeamDefense(fmTeamDefenseService.selectFmTeamDefenseById(list.get(i).getId()));
            list.get(i).setTeamOthers(fmTeamOthersService.selectFmTeamOthersById(list.get(i).getId()));
            list.get(i).setTeamGoalkeeping(fmTeamGoalkeepingService.selectFmTeamGoalkeepingById(list.get(i).getId()));
            list.get(i).setTeamPassing(fmTeamPassingService.selectFmTeamPassingById(list.get(i).getId()));
            list.get(i).setTeamShooting(fmTeamShootingService.selectFmTeamShootingById(list.get(i).getId()));
            list.get(i).setPlayerBasicList(selectFmPlayerBasicByFmTeamBasicSquad(list.get(i).getSquad()));
        }
        return list;
    }

    @Override
    public IPage<FmTeamVo> selectFmTeamVoPageWithFmplayerBasic(Page page) {
        Page<FmTeamBasic> fmTeamBasicPage = fmTeamBasicService.page(page);
        List<FmTeamVo> fmTeamVoList = new ArrayList<>();
        for (int i = 0; i < fmTeamBasicPage.getRecords().size(); i++) {
            FmTeamVo fmTeamVo = new FmTeamVo(fmTeamBasicPage.getRecords().get(i));
            fmTeamVo.setTeamDefense(fmTeamDefenseService.selectFmTeamDefenseById(fmTeamVo.getId()));
            fmTeamVo.setTeamOthers(fmTeamOthersService.selectFmTeamOthersById(fmTeamVo.getId()));
            fmTeamVo.setTeamGoalkeeping(fmTeamGoalkeepingService.selectFmTeamGoalkeepingById(fmTeamVo.getId()));
            fmTeamVo.setTeamPassing(fmTeamPassingService.selectFmTeamPassingById(fmTeamVo.getId()));
            fmTeamVo.setTeamShooting(fmTeamShootingService.selectFmTeamShootingById(fmTeamVo.getId()));
            fmTeamVo.setPlayerBasicList(selectFmPlayerBasicByFmTeamBasicSquad(fmTeamVo.getSquad()));
            fmTeamVoList.add(fmTeamVo);
        }
        // package Page
        Page<FmTeamVo> fmTeamVoPage = new Page<>();
        fmTeamVoPage.setCurrent(fmTeamBasicPage.getCurrent());
        fmTeamVoPage.setPages(fmTeamBasicPage.getPages());
        fmTeamVoPage.setTotal(fmTeamBasicPage.getTotal());
        fmTeamVoPage.setSize(fmTeamBasicPage.getSize());
        fmTeamVoPage.setRecords(fmTeamVoList);

        return fmTeamVoPage;
    }
}
