package com.bbs.service;

import com.bbs.domain.fm.FmPlayerShooting;

import java.util.List;

public interface IFmPlayerShootingService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FmPlayerShooting selectFmPlayerShootingById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmPlayerShooting 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FmPlayerShooting> selectFmPlayerShootingList(FmPlayerShooting fmPlayerShooting);

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmPlayerShooting 【请填写功能名称】
     * @return 结果
     */
    public int insertFmPlayerShooting(FmPlayerShooting fmPlayerShooting);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmPlayerShooting 【请填写功能名称】
     * @return 结果
     */
    public int updateFmPlayerShooting(FmPlayerShooting fmPlayerShooting);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteFmPlayerShootingByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFmPlayerShootingById(Long id);
}
