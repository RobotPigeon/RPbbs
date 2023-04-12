package com.bbs.service.impl;

import java.util.List;

import com.bbs.domain.fm.FmPlayerGoalkeeping;
import com.bbs.mapper.FmPlayerGoalkeepingMapper;
import com.bbs.service.IFmPlayerGoalkeepingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FmPlayerGoalkeepingServiceImpl implements IFmPlayerGoalkeepingService
{
    @Autowired
    private FmPlayerGoalkeepingMapper fmPlayerGoalkeepingMapper;

    @Override
    public FmPlayerGoalkeeping selectFmPlayerGoalkeepingById(Long id)
    {
        return fmPlayerGoalkeepingMapper.selectFmPlayerGoalkeepingById(id);
    }

    @Override
    public List<FmPlayerGoalkeeping> selectFmPlayerGoalkeepingList(FmPlayerGoalkeeping fmPlayerGoalkeeping)
    {
        return fmPlayerGoalkeepingMapper.selectFmPlayerGoalkeepingList(fmPlayerGoalkeeping);
    }

    @Override
    public int insertFmPlayerGoalkeeping(FmPlayerGoalkeeping fmPlayerGoalkeeping)
    {
        return fmPlayerGoalkeepingMapper.insertFmPlayerGoalkeeping(fmPlayerGoalkeeping);
    }

    @Override
    public int updateFmPlayerGoalkeeping(FmPlayerGoalkeeping fmPlayerGoalkeeping)
    {
        return fmPlayerGoalkeepingMapper.updateFmPlayerGoalkeeping(fmPlayerGoalkeeping);
    }

    @Override
    public int deleteFmPlayerGoalkeepingByIds(Long[] ids)
    {
        return fmPlayerGoalkeepingMapper.deleteFmPlayerGoalkeepingByIds(ids);
    }

    @Override
    public int deleteFmPlayerGoalkeepingById(Long id)
    {
        return fmPlayerGoalkeepingMapper.deleteFmPlayerGoalkeepingById(id);
    }
}
