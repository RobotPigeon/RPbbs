package com.bbs.service.impl;

import java.util.List;

import com.bbs.domain.fm.FmMatch;
import com.bbs.mapper.FmMatchMapper;
import com.bbs.service.IFmMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class FmMatchServiceImpl implements IFmMatchService
{
    @Autowired
    private FmMatchMapper fmMatchMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FmMatch selectFmMatchById(String id)
    {
        return fmMatchMapper.selectFmMatchById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmMatch 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FmMatch> selectFmMatchList(FmMatch fmMatch)
    {
        return fmMatchMapper.selectFmMatchList(fmMatch);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmMatch 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFmMatch(FmMatch fmMatch)
    {
        return fmMatchMapper.insertFmMatch(fmMatch);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmMatch 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFmMatch(FmMatch fmMatch)
    {
        return fmMatchMapper.updateFmMatch(fmMatch);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmMatchByIds(String[] ids)
    {
        return fmMatchMapper.deleteFmMatchByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmMatchById(String id)
    {
        return fmMatchMapper.deleteFmMatchById(id);
    }
}
