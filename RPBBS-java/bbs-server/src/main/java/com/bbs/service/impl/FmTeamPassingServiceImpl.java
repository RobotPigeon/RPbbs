package com.bbs.service.impl;

import java.util.List;

import com.bbs.domain.fm.FmTeamPassing;
import com.bbs.mapper.FmTeamPassingMapper;
import com.bbs.service.IFmTeamPassingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 足球传球数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class FmTeamPassingServiceImpl implements IFmTeamPassingService
{
    @Autowired
    private FmTeamPassingMapper fmTeamPassingMapper;

    /**
     * 查询足球传球数据
     * 
     * @param id 足球传球数据主键
     * @return 足球传球数据
     */
    @Override
    public FmTeamPassing selectFmTeamPassingById(Long id)
    {
        return fmTeamPassingMapper.selectFmTeamPassingById(id);
    }

    /**
     * 查询足球传球数据列表
     * 
     * @param fmTeamPassing 足球传球数据
     * @return 足球传球数据
     */
    @Override
    public List<FmTeamPassing> selectFmTeamPassingList(FmTeamPassing fmTeamPassing)
    {
        return fmTeamPassingMapper.selectFmTeamPassingList(fmTeamPassing);
    }

    /**
     * 新增足球传球数据
     * 
     * @param fmTeamPassing 足球传球数据
     * @return 结果
     */
    @Override
    public int insertFmTeamPassing(FmTeamPassing fmTeamPassing)
    {
        return fmTeamPassingMapper.insertFmTeamPassing(fmTeamPassing);
    }

    /**
     * 修改足球传球数据
     * 
     * @param fmTeamPassing 足球传球数据
     * @return 结果
     */
    @Override
    public int updateFmTeamPassing(FmTeamPassing fmTeamPassing)
    {
        return fmTeamPassingMapper.updateFmTeamPassing(fmTeamPassing);
    }

    /**
     * 批量删除足球传球数据
     * 
     * @param ids 需要删除的足球传球数据主键
     * @return 结果
     */
    @Override
    public int deleteFmTeamPassingByIds(Long[] ids)
    {
        return fmTeamPassingMapper.deleteFmTeamPassingByIds(ids);
    }

    /**
     * 删除足球传球数据信息
     * 
     * @param id 足球传球数据主键
     * @return 结果
     */
    @Override
    public int deleteFmTeamPassingById(Long id)
    {
        return fmTeamPassingMapper.deleteFmTeamPassingById(id);
    }
}
