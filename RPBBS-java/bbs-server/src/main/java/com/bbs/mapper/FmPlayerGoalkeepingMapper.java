package com.bbs.mapper;

import com.bbs.domain.fm.FmPlayerGoalkeeping;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FmPlayerGoalkeepingMapper 
{

    public FmPlayerGoalkeeping selectFmPlayerGoalkeepingById(Long id);

    public List<FmPlayerGoalkeeping> selectFmPlayerGoalkeepingList(FmPlayerGoalkeeping fmPlayerGoalkeeping);

    public int insertFmPlayerGoalkeeping(FmPlayerGoalkeeping fmPlayerGoalkeeping);

    public int updateFmPlayerGoalkeeping(FmPlayerGoalkeeping fmPlayerGoalkeeping);

    public int deleteFmPlayerGoalkeepingById(Long id);

    public int deleteFmPlayerGoalkeepingByIds(Long[] ids);
}
