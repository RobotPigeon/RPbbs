package com.bbs.service;

import com.bbs.domain.fm.FmEvents;

import java.util.List;


/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
public interface IFmEventsService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FmEvents selectFmEventsById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmEvents 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FmEvents> selectFmEventsList(FmEvents fmEvents);

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmEvents 【请填写功能名称】
     * @return 结果
     */
    public int insertFmEvents(FmEvents fmEvents);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmEvents 【请填写功能名称】
     * @return 结果
     */
    public int updateFmEvents(FmEvents fmEvents);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteFmEventsByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFmEventsById(Long id);
}
