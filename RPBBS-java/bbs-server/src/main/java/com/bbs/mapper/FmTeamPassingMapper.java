package com.bbs.mapper;

import com.bbs.domain.fm.FmTeamPassing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 足球传球数据Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Mapper
public interface FmTeamPassingMapper 
{
    /**
     * 查询足球传球数据
     * 
     * @param id 足球传球数据主键
     * @return 足球传球数据
     */
    public FmTeamPassing selectFmTeamPassingById(Long id);

    /**
     * 查询足球传球数据列表
     * 
     * @param fmTeamPassing 足球传球数据
     * @return 足球传球数据集合
     */
    public List<FmTeamPassing> selectFmTeamPassingList(FmTeamPassing fmTeamPassing);

    /**
     * 新增足球传球数据
     * 
     * @param fmTeamPassing 足球传球数据
     * @return 结果
     */
    public int insertFmTeamPassing(FmTeamPassing fmTeamPassing);

    /**
     * 修改足球传球数据
     * 
     * @param fmTeamPassing 足球传球数据
     * @return 结果
     */
    public int updateFmTeamPassing(FmTeamPassing fmTeamPassing);

    /**
     * 删除足球传球数据
     * 
     * @param id 足球传球数据主键
     * @return 结果
     */
    public int deleteFmTeamPassingById(Long id);

    /**
     * 批量删除足球传球数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFmTeamPassingByIds(Long[] ids);
}
