package com.bbs.service.impl;

import java.util.List;

import com.bbs.domain.fm.FmEvents;
import com.bbs.mapper.FmEventsMapper;
import com.bbs.service.IFmEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class FmEventsServiceImpl implements IFmEventsService
{
    @Autowired
    private FmEventsMapper fmEventsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FmEvents selectFmEventsById(Long id)
    {
        return fmEventsMapper.selectFmEventsById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmEvents 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FmEvents> selectFmEventsList(FmEvents fmEvents)
    {
        return fmEventsMapper.selectFmEventsList(fmEvents);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmEvents 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFmEvents(FmEvents fmEvents)
    {
        return fmEventsMapper.insertFmEvents(fmEvents);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmEvents 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFmEvents(FmEvents fmEvents)
    {
        return fmEventsMapper.updateFmEvents(fmEvents);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmEventsByIds(Long[] ids)
    {
        return fmEventsMapper.deleteFmEventsByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmEventsById(Long id)
    {
        return fmEventsMapper.deleteFmEventsById(id);
    }
}
