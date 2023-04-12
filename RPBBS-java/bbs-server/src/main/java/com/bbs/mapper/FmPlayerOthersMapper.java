package com.bbs.mapper;

import com.bbs.domain.fm.FmPlayerOthers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Mapper
public interface FmPlayerOthersMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFmPlayerOthersById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFmPlayerOthersByIds(Long[] ids);
}
