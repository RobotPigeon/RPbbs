package com.bbs.service;

import com.bbs.domain.fm.FmPlayerDefense;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
public interface IFmPlayerDefenseService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FmPlayerDefense selectFmPlayerDefenseById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmPlayerDefense 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FmPlayerDefense> selectFmPlayerDefenseList(FmPlayerDefense fmPlayerDefense);

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmPlayerDefense 【请填写功能名称】
     * @return 结果
     */
    public int insertFmPlayerDefense(FmPlayerDefense fmPlayerDefense);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmPlayerDefense 【请填写功能名称】
     * @return 结果
     */
    public int updateFmPlayerDefense(FmPlayerDefense fmPlayerDefense);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteFmPlayerDefenseByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFmPlayerDefenseById(Long id);
}
