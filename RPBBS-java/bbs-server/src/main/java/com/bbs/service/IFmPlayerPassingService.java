package com.bbs.service;

import com.bbs.domain.fm.FmPlayerPassing;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
public interface IFmPlayerPassingService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FmPlayerPassing selectFmPlayerPassingById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmPlayerPassing 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FmPlayerPassing> selectFmPlayerPassingList(FmPlayerPassing fmPlayerPassing);

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmPlayerPassing 【请填写功能名称】
     * @return 结果
     */
    public int insertFmPlayerPassing(FmPlayerPassing fmPlayerPassing);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmPlayerPassing 【请填写功能名称】
     * @return 结果
     */
    public int updateFmPlayerPassing(FmPlayerPassing fmPlayerPassing);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteFmPlayerPassingByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFmPlayerPassingById(Long id);
}
