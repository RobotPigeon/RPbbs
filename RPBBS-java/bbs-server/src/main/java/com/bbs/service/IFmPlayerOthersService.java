package com.bbs.service;

import com.bbs.domain.fm.FmPlayerOthers;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
public interface IFmPlayerOthersService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FmPlayerOthers selectFmPlayerOthersById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmPlayerOthers 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FmPlayerOthers> selectFmPlayerOthersList(FmPlayerOthers fmPlayerOthers);

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmPlayerOthers 【请填写功能名称】
     * @return 结果
     */
    public int insertFmPlayerOthers(FmPlayerOthers fmPlayerOthers);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmPlayerOthers 【请填写功能名称】
     * @return 结果
     */
    public int updateFmPlayerOthers(FmPlayerOthers fmPlayerOthers);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteFmPlayerOthersByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFmPlayerOthersById(Long id);
}