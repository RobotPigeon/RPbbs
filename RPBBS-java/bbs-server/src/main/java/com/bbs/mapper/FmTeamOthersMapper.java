package com.bbs.mapper;

import com.bbs.domain.fm.FmTeamOthers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 存储球队其他现Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Mapper
public interface FmTeamOthersMapper 
{
    /**
     * 查询存储球队其他现
     * 
     * @param id 存储球队其他现主键
     * @return 存储球队其他现
     */
    public FmTeamOthers selectFmTeamOthersById(Long id);

    /**
     * 查询存储球队其他现列表
     * 
     * @param fmTeamOthers 存储球队其他现
     * @return 存储球队其他现集合
     */
    public List<FmTeamOthers> selectFmTeamOthersList(FmTeamOthers fmTeamOthers);

    /**
     * 新增存储球队其他现
     * 
     * @param fmTeamOthers 存储球队其他现
     * @return 结果
     */
    public int insertFmTeamOthers(FmTeamOthers fmTeamOthers);

    /**
     * 修改存储球队其他现
     * 
     * @param fmTeamOthers 存储球队其他现
     * @return 结果
     */
    public int updateFmTeamOthers(FmTeamOthers fmTeamOthers);

    /**
     * 删除存储球队其他现
     * 
     * @param id 存储球队其他现主键
     * @return 结果
     */
    public int deleteFmTeamOthersById(Long id);

    /**
     * 批量删除存储球队其他现
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFmTeamOthersByIds(Long[] ids);
}
