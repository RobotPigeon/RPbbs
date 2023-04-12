package com.bbs.service.impl;

import java.util.List;

import com.bbs.domain.fm.FmTeamOthers;
import com.bbs.mapper.FmTeamOthersMapper;
import com.bbs.service.IFmTeamOthersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 存储球队其他现Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class FmTeamOthersServiceImpl implements IFmTeamOthersService
{
    @Autowired
    private FmTeamOthersMapper fmTeamOthersMapper;

    /**
     * 查询存储球队其他现
     * 
     * @param id 存储球队其他现主键
     * @return 存储球队其他现
     */
    @Override
    public FmTeamOthers selectFmTeamOthersById(Long id)
    {
        return fmTeamOthersMapper.selectFmTeamOthersById(id);
    }

    /**
     * 查询存储球队其他现列表
     * 
     * @param fmTeamOthers 存储球队其他现
     * @return 存储球队其他现
     */
    @Override
    public List<FmTeamOthers> selectFmTeamOthersList(FmTeamOthers fmTeamOthers)
    {
        return fmTeamOthersMapper.selectFmTeamOthersList(fmTeamOthers);
    }

    /**
     * 新增存储球队其他现
     * 
     * @param fmTeamOthers 存储球队其他现
     * @return 结果
     */
    @Override
    public int insertFmTeamOthers(FmTeamOthers fmTeamOthers)
    {
        return fmTeamOthersMapper.insertFmTeamOthers(fmTeamOthers);
    }

    /**
     * 修改存储球队其他现
     * 
     * @param fmTeamOthers 存储球队其他现
     * @return 结果
     */
    @Override
    public int updateFmTeamOthers(FmTeamOthers fmTeamOthers)
    {
        return fmTeamOthersMapper.updateFmTeamOthers(fmTeamOthers);
    }

    /**
     * 批量删除存储球队其他现
     * 
     * @param ids 需要删除的存储球队其他现主键
     * @return 结果
     */
    @Override
    public int deleteFmTeamOthersByIds(Long[] ids)
    {
        return fmTeamOthersMapper.deleteFmTeamOthersByIds(ids);
    }

    /**
     * 删除存储球队其他现信息
     * 
     * @param id 存储球队其他现主键
     * @return 结果
     */
    @Override
    public int deleteFmTeamOthersById(Long id)
    {
        return fmTeamOthersMapper.deleteFmTeamOthersById(id);
    }
}
