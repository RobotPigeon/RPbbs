package com.bbs.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbs.domain.fm.FmTeamBasic;
import com.bbs.mapper.FmTeamBasicMapper;
import com.bbs.service.IFmTeamBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class FmTeamBasicServiceImpl extends ServiceImpl<FmTeamBasicMapper, FmTeamBasic> implements IFmTeamBasicService
{
    @Autowired
    private FmTeamBasicMapper fmTeamBasicMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FmTeamBasic selectFmTeamBasicById(Long id)
    {
        return fmTeamBasicMapper.selectFmTeamBasicById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmTeamBasic 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FmTeamBasic> selectFmTeamBasicList(FmTeamBasic fmTeamBasic)
    {
        return fmTeamBasicMapper.selectFmTeamBasicList(fmTeamBasic);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmTeamBasic 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFmTeamBasic(FmTeamBasic fmTeamBasic)
    {
        return fmTeamBasicMapper.insertFmTeamBasic(fmTeamBasic);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmTeamBasic 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFmTeamBasic(FmTeamBasic fmTeamBasic)
    {
        return fmTeamBasicMapper.updateFmTeamBasic(fmTeamBasic);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmTeamBasicByIds(Long[] ids)
    {
        return fmTeamBasicMapper.deleteFmTeamBasicByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmTeamBasicById(Long id)
    {
        return fmTeamBasicMapper.deleteFmTeamBasicById(id);
    }
}
