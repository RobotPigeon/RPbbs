package com.bbs.service;

import com.bbs.domain.fm.FmTeamOthers;

import java.util.List;

/**
 * 存储球队其他现Service接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
public interface IFmTeamOthersService 
{
    /**
     * 查询存储球队其他现
     * 
     * @param id 存储球队其他现主键
     * @return 存储球队其他现
     */
    public FmTeamOthers selectFmTeamOthersById(Long id);

    /**
     * 查询存储球队其他现列表
     * 
     * @param fmTeamOthers 存储球队其他现
     * @return 存储球队其他现集合
     */
    public List<FmTeamOthers> selectFmTeamOthersList(FmTeamOthers fmTeamOthers);

    /**
     * 新增存储球队其他现
     * 
     * @param fmTeamOthers 存储球队其他现
     * @return 结果
     */
    public int insertFmTeamOthers(FmTeamOthers fmTeamOthers);

    /**
     * 修改存储球队其他现
     * 
     * @param fmTeamOthers 存储球队其他现
     * @return 结果
     */
    public int updateFmTeamOthers(FmTeamOthers fmTeamOthers);

    /**
     * 批量删除存储球队其他现
     * 
     * @param ids 需要删除的存储球队其他现主键集合
     * @return 结果
     */
    public int deleteFmTeamOthersByIds(Long[] ids);

    /**
     * 删除存储球队其他现信息
     * 
     * @param id 存储球队其他现主键
     * @return 结果
     */
    public int deleteFmTeamOthersById(Long id);
}
