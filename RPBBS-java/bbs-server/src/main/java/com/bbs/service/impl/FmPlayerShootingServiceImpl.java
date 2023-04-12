package com.bbs.service.impl;

import java.util.List;

import com.bbs.domain.fm.FmPlayerShooting;
import com.bbs.mapper.FmPlayerShootingMapper;
import com.bbs.service.IFmPlayerShootingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class FmPlayerShootingServiceImpl implements IFmPlayerShootingService
{
    @Autowired
    private FmPlayerShootingMapper fmPlayerShootingMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FmPlayerShooting selectFmPlayerShootingById(Long id)
    {
        return fmPlayerShootingMapper.selectFmPlayerShootingById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmPlayerShooting 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FmPlayerShooting> selectFmPlayerShootingList(FmPlayerShooting fmPlayerShooting)
    {
        return fmPlayerShootingMapper.selectFmPlayerShootingList(fmPlayerShooting);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmPlayerShooting 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFmPlayerShooting(FmPlayerShooting fmPlayerShooting)
    {
        return fmPlayerShootingMapper.insertFmPlayerShooting(fmPlayerShooting);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmPlayerShooting 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFmPlayerShooting(FmPlayerShooting fmPlayerShooting)
    {
        return fmPlayerShootingMapper.updateFmPlayerShooting(fmPlayerShooting);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmPlayerShootingByIds(Long[] ids)
    {
        return fmPlayerShootingMapper.deleteFmPlayerShootingByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmPlayerShootingById(Long id)
    {
        return fmPlayerShootingMapper.deleteFmPlayerShootingById(id);
    }
}
