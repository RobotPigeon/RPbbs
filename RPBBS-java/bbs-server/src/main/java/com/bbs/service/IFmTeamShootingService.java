package com.bbs.service;

import com.bbs.domain.fm.FmTeamShooting;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
public interface IFmTeamShootingService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FmTeamShooting selectFmTeamShootingById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmTeamShooting 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FmTeamShooting> selectFmTeamShootingList(FmTeamShooting fmTeamShooting);

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmTeamShooting 【请填写功能名称】
     * @return 结果
     */
    public int insertFmTeamShooting(FmTeamShooting fmTeamShooting);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmTeamShooting 【请填写功能名称】
     * @return 结果
     */
    public int updateFmTeamShooting(FmTeamShooting fmTeamShooting);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteFmTeamShootingByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFmTeamShootingById(Long id);
}
