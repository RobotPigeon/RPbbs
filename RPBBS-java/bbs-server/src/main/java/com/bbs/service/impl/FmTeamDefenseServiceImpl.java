package com.bbs.service.impl;

import java.util.List;

import com.bbs.domain.fm.FmTeamDefense;
import com.bbs.mapper.FmTeamDefenseMapper;
import com.bbs.service.IFmTeamDefenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class FmTeamDefenseServiceImpl implements IFmTeamDefenseService
{
    @Autowired
    private FmTeamDefenseMapper fmTeamDefenseMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FmTeamDefense selectFmTeamDefenseById(Long id)
    {
        return fmTeamDefenseMapper.selectFmTeamDefenseById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmTeamDefense 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FmTeamDefense> selectFmTeamDefenseList(FmTeamDefense fmTeamDefense)
    {
        return fmTeamDefenseMapper.selectFmTeamDefenseList(fmTeamDefense);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmTeamDefense 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFmTeamDefense(FmTeamDefense fmTeamDefense)
    {
        return fmTeamDefenseMapper.insertFmTeamDefense(fmTeamDefense);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmTeamDefense 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFmTeamDefense(FmTeamDefense fmTeamDefense)
    {
        return fmTeamDefenseMapper.updateFmTeamDefense(fmTeamDefense);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmTeamDefenseByIds(Long[] ids)
    {
        return fmTeamDefenseMapper.deleteFmTeamDefenseByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmTeamDefenseById(Long id)
    {
        return fmTeamDefenseMapper.deleteFmTeamDefenseById(id);
    }
}
