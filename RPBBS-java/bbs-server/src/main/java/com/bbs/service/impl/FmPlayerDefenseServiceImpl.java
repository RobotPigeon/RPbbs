package com.bbs.service.impl;

import java.util.List;

import com.bbs.domain.fm.FmPlayerDefense;
import com.bbs.mapper.FmPlayerDefenseMapper;
import com.bbs.service.IFmPlayerDefenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class FmPlayerDefenseServiceImpl implements IFmPlayerDefenseService
{
    @Autowired
    private FmPlayerDefenseMapper fmPlayerDefenseMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FmPlayerDefense selectFmPlayerDefenseById(Long id)
    {
        return fmPlayerDefenseMapper.selectFmPlayerDefenseById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmPlayerDefense 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FmPlayerDefense> selectFmPlayerDefenseList(FmPlayerDefense fmPlayerDefense)
    {
        return fmPlayerDefenseMapper.selectFmPlayerDefenseList(fmPlayerDefense);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmPlayerDefense 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFmPlayerDefense(FmPlayerDefense fmPlayerDefense)
    {
        return fmPlayerDefenseMapper.insertFmPlayerDefense(fmPlayerDefense);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmPlayerDefense 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFmPlayerDefense(FmPlayerDefense fmPlayerDefense)
    {
        return fmPlayerDefenseMapper.updateFmPlayerDefense(fmPlayerDefense);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmPlayerDefenseByIds(Long[] ids)
    {
        return fmPlayerDefenseMapper.deleteFmPlayerDefenseByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmPlayerDefenseById(Long id)
    {
        return fmPlayerDefenseMapper.deleteFmPlayerDefenseById(id);
    }
}
