package com.bbs.service;

import com.bbs.domain.fm.FmTeamDefense;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
public interface IFmTeamDefenseService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FmTeamDefense selectFmTeamDefenseById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmTeamDefense 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FmTeamDefense> selectFmTeamDefenseList(FmTeamDefense fmTeamDefense);

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmTeamDefense 【请填写功能名称】
     * @return 结果
     */
    public int insertFmTeamDefense(FmTeamDefense fmTeamDefense);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmTeamDefense 【请填写功能名称】
     * @return 结果
     */
    public int updateFmTeamDefense(FmTeamDefense fmTeamDefense);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteFmTeamDefenseByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFmTeamDefenseById(Long id);
}
