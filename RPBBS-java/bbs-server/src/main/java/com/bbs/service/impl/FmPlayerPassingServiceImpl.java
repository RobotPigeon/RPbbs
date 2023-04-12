package com.bbs.service.impl;

import java.util.List;

import com.bbs.domain.fm.FmPlayerPassing;
import com.bbs.mapper.FmPlayerPassingMapper;
import com.bbs.service.IFmPlayerPassingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class FmPlayerPassingServiceImpl implements IFmPlayerPassingService
{
    @Autowired
    private FmPlayerPassingMapper fmPlayerPassingMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FmPlayerPassing selectFmPlayerPassingById(Long id)
    {
        return fmPlayerPassingMapper.selectFmPlayerPassingById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fmPlayerPassing 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FmPlayerPassing> selectFmPlayerPassingList(FmPlayerPassing fmPlayerPassing)
    {
        return fmPlayerPassingMapper.selectFmPlayerPassingList(fmPlayerPassing);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param fmPlayerPassing 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFmPlayerPassing(FmPlayerPassing fmPlayerPassing)
    {
        return fmPlayerPassingMapper.insertFmPlayerPassing(fmPlayerPassing);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param fmPlayerPassing 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFmPlayerPassing(FmPlayerPassing fmPlayerPassing)
    {
        return fmPlayerPassingMapper.updateFmPlayerPassing(fmPlayerPassing);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmPlayerPassingByIds(Long[] ids)
    {
        return fmPlayerPassingMapper.deleteFmPlayerPassingByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFmPlayerPassingById(Long id)
    {
        return fmPlayerPassingMapper.deleteFmPlayerPassingById(id);
    }
}
