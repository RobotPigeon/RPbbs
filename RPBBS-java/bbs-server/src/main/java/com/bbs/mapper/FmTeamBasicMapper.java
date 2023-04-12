package com.bbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bbs.domain.fm.FmTeamBasic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Mapper
public interface FmTeamBasicMapper extends BaseMapper<FmTeamBasic>
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FmTeamBasic selectFmTeamBasicById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmTeamBasic 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FmTeamBasic> selectFmTeamBasicList(FmTeamBasic fmTeamBasic);

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmTeamBasic 【请填写功能名称】
     * @return 结果
     */
    public int insertFmTeamBasic(FmTeamBasic fmTeamBasic);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmTeamBasic 【请填写功能名称】
     * @return 结果
     */
    public int updateFmTeamBasic(FmTeamBasic fmTeamBasic);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFmTeamBasicById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFmTeamBasicByIds(Long[] ids);
}
