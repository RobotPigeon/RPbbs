package com.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.fm.FmPlayerBasic;
import com.bbs.domain.vo.FmPlayerVo;
import com.bbs.mapper.*;
import com.bbs.service.IFmPlayerExtensionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FmPlayerExtensionServiceImpl implements IFmPlayerExtensionService {

    @Autowired
    private FmPlayerBasicMapper fmPlayerBasicMapper;

    @Autowired
    private FmPlayerDefenseMapper fmPlayerDefenseMapper;

    @Autowired
    private FmPlayerGoalkeepingMapper fmPlayerGoalkeepingMapper;

    @Autowired
    private FmPlayerOthersMapper fmPlayerOthersMapper;

    @Autowired
    private FmPlayerPassingMapper fmPlayerPassingMapper;

    @Autowired
    private FmPlayerShootingMapper fmPlayerShootingMapper;

    @Override
    public FmPlayerVo selectFmPlayerVoById(Long id) {
        // 查询次数过高，想降低查询次数需编写sql，这里不做
        FmPlayerBasic fmPlayerBasic = fmPlayerBasicMapper.selectFmPlayerBasicById(id);
        FmPlayerVo fmPlayerVo = new FmPlayerVo(fmPlayerBasic);
        fmPlayerVo.setPlayerDefense(fmPlayerDefenseMapper.selectFmPlayerDefenseById(id));
        fmPlayerVo.setPlayerGoalkeeping(fmPlayerGoalkeepingMapper.selectFmPlayerGoalkeepingById(id));
        fmPlayerVo.setPlayerOthers(fmPlayerOthersMapper.selectFmPlayerOthersById(id));
        fmPlayerVo.setPlayerPassing(fmPlayerPassingMapper.selectFmPlayerPassingById(id));
        fmPlayerVo.setPlayerShooting(fmPlayerShootingMapper.selectFmPlayerShootingById(id));
        return fmPlayerVo;
    }

    @Override
    public List<FmPlayerVo> selectFmPlayerVoList(FmPlayerBasic body) {
        return null;
    }

    @Override
    public IPage<FmPlayerVo> selectFmPlayerVoPage(Page page) {
        return null;
    }

    @Override
    public IPage<FmPlayerVo> selectFmPlayerVoPage(Page page, Wrapper wrapper) {
        return null;
    }
}
