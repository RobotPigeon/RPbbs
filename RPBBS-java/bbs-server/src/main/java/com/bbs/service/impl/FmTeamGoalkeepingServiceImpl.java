package com.bbs.service.impl;

import java.util.List;

import com.bbs.domain.fm.FmTeamGoalkeeping;
import com.bbs.mapper.FmTeamGoalkeepingMapper;
import com.bbs.service.IFmTeamGoalkeepingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 球队守门员现Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class FmTeamGoalkeepingServiceImpl implements IFmTeamGoalkeepingService
{
    @Autowired
    private FmTeamGoalkeepingMapper fmTeamGoalkeepingMapper;

    /**
     * 查询球队守门员现
     * 
     * @param id 球队守门员现主键
     * @return 球队守门员现
     */
    @Override
    public FmTeamGoalkeeping selectFmTeamGoalkeepingById(Long id)
    {
        return fmTeamGoalkeepingMapper.selectFmTeamGoalkeepingById(id);
    }

    /**
     * 查询球队守门员现列表
     * 
     * @param fmTeamGoalkeeping 球队守门员现
     * @return 球队守门员现
     */
    @Override
    public List<FmTeamGoalkeeping> selectFmTeamGoalkeepingList(FmTeamGoalkeeping fmTeamGoalkeeping)
    {
        return fmTeamGoalkeepingMapper.selectFmTeamGoalkeepingList(fmTeamGoalkeeping);
    }

    /**
     * 新增球队守门员现
     * 
     * @param fmTeamGoalkeeping 球队守门员现
     * @return 结果
     */
    @Override
    public int insertFmTeamGoalkeeping(FmTeamGoalkeeping fmTeamGoalkeeping)
    {
        return fmTeamGoalkeepingMapper.insertFmTeamGoalkeeping(fmTeamGoalkeeping);
    }

    /**
     * 修改球队守门员现
     * 
     * @param fmTeamGoalkeeping 球队守门员现
     * @return 结果
     */
    @Override
    public int updateFmTeamGoalkeeping(FmTeamGoalkeeping fmTeamGoalkeeping)
    {
        return fmTeamGoalkeepingMapper.updateFmTeamGoalkeeping(fmTeamGoalkeeping);
    }

    /**
     * 批量删除球队守门员现
     * 
     * @param ids 需要删除的球队守门员现主键
     * @return 结果
     */
    @Override
    public int deleteFmTeamGoalkeepingByIds(Long[] ids)
    {
        return fmTeamGoalkeepingMapper.deleteFmTeamGoalkeepingByIds(ids);
    }

    /**
     * 删除球队守门员现信息
     * 
     * @param id 球队守门员现主键
     * @return 结果
     */
    @Override
    public int deleteFmTeamGoalkeepingById(Long id)
    {
        return fmTeamGoalkeepingMapper.deleteFmTeamGoalkeepingById(id);
    }
}
