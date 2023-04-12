package com.bbs.mapper;

import com.bbs.domain.fm.FmTeamGoalkeeping;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 球队守门员现Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Mapper
public interface FmTeamGoalkeepingMapper 
{
    /**
     * 查询球队守门员现
     * 
     * @param id 球队守门员现主键
     * @return 球队守门员现
     */
    public FmTeamGoalkeeping selectFmTeamGoalkeepingById(Long id);

    /**
     * 查询球队守门员现列表
     * 
     * @param fmTeamGoalkeeping 球队守门员现
     * @return 球队守门员现集合
     */
    public List<FmTeamGoalkeeping> selectFmTeamGoalkeepingList(FmTeamGoalkeeping fmTeamGoalkeeping);

    /**
     * 新增球队守门员现
     * 
     * @param fmTeamGoalkeeping 球队守门员现
     * @return 结果
     */
    public int insertFmTeamGoalkeeping(FmTeamGoalkeeping fmTeamGoalkeeping);

    /**
     * 修改球队守门员现
     * 
     * @param fmTeamGoalkeeping 球队守门员现
     * @return 结果
     */
    public int updateFmTeamGoalkeeping(FmTeamGoalkeeping fmTeamGoalkeeping);

    /**
     * 删除球队守门员现
     * 
     * @param id 球队守门员现主键
     * @return 结果
     */
    public int deleteFmTeamGoalkeepingById(Long id);

    /**
     * 批量删除球队守门员现
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFmTeamGoalkeepingByIds(Long[] ids);
}
