package com.bbs.mapper;

import com.bbs.domain.fm.FmMatch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Mapper
public interface FmMatchMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FmMatch selectFmMatchById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmMatch 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FmMatch> selectFmMatchList(FmMatch fmMatch);

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmMatch 【请填写功能名称】
     * @return 结果
     */
    public int insertFmMatch(FmMatch fmMatch);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmMatch 【请填写功能名称】
     * @return 结果
     */
    public int updateFmMatch(FmMatch fmMatch);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFmMatchById(String id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFmMatchByIds(String[] ids);
}
