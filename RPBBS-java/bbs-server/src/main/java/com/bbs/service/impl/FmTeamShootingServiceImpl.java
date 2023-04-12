package com.bbs.service.impl;

import java.util.List;

import com.bbs.domain.fm.FmTeamShooting;
import com.bbs.mapper.FmTeamShootingMapper;
import com.bbs.service.IFmTeamShootingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class FmTeamShootingServiceImpl implements IFmTeamShootingService
{
    @Autowired
    private FmTeamShootingMapper fmTeamShootingMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FmTeamShooting selectFmTeamShootingById(Long id)
    {
        return fmTeamShootingMapper.selectFmTeamShootingById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmTeamShooting 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FmTeamShooting> selectFmTeamShootingList(FmTeamShooting fmTeamShooting)
    {
        return fmTeamShootingMapper.selectFmTeamShootingList(fmTeamShooting);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmTeamShooting 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFmTeamShooting(FmTeamShooting fmTeamShooting)
    {
        return fmTeamShootingMapper.insertFmTeamShooting(fmTeamShooting);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmTeamShooting 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFmTeamShooting(FmTeamShooting fmTeamShooting)
    {
        return fmTeamShootingMapper.updateFmTeamShooting(fmTeamShooting);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmTeamShootingByIds(Long[] ids)
    {
        return fmTeamShootingMapper.deleteFmTeamShootingByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmTeamShootingById(Long id)
    {
        return fmTeamShootingMapper.deleteFmTeamShootingById(id);
    }
}
