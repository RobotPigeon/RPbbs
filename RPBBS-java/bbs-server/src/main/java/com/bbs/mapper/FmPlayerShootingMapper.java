package com.bbs.mapper;

import com.bbs.domain.fm.FmPlayerShooting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Mapper
public interface FmPlayerShootingMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FmPlayerShooting selectFmPlayerShootingById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmPlayerShooting 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FmPlayerShooting> selectFmPlayerShootingList(FmPlayerShooting fmPlayerShooting);

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmPlayerShooting 【请填写功能名称】
     * @return 结果
     */
    public int insertFmPlayerShooting(FmPlayerShooting fmPlayerShooting);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmPlayerShooting 【请填写功能名称】
     * @return 结果
     */
    public int updateFmPlayerShooting(FmPlayerShooting fmPlayerShooting);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFmPlayerShootingById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFmPlayerShootingByIds(Long[] ids);
}
