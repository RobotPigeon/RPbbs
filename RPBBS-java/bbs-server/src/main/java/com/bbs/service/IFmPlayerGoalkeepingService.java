package com.bbs.service;

import com.bbs.domain.fm.FmPlayerGoalkeeping;

import java.util.List;

public interface IFmPlayerGoalkeepingService 
{
    public FmPlayerGoalkeeping selectFmPlayerGoalkeepingById(Long id);

    /**
     * 查询列表
     */
    public List<FmPlayerGoalkeeping> selectFmPlayerGoalkeepingList(FmPlayerGoalkeeping fmPlayerGoalkeeping);

    /**
     * 新增
     */
    public int insertFmPlayerGoalkeeping(FmPlayerGoalkeeping fmPlayerGoalkeeping);

    /**
     * 修改
     */
    public int updateFmPlayerGoalkeeping(FmPlayerGoalkeeping fmPlayerGoalkeeping);

    /**
     * 批量删除
     */
    public int deleteFmPlayerGoalkeepingByIds(Long[] ids);

    /**
     * 删除信息
     */
    public int deleteFmPlayerGoalkeepingById(Long id);
}
