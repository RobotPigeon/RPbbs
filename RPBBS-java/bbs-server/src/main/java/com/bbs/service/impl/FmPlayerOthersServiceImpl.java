package com.bbs.service.impl;

import java.util.List;

import com.bbs.domain.fm.FmPlayerOthers;
import com.bbs.mapper.FmPlayerOthersMapper;
import com.bbs.service.IFmPlayerOthersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class FmPlayerOthersServiceImpl implements IFmPlayerOthersService
{
    @Autowired
    private FmPlayerOthersMapper fmPlayerOthersMapper;

    /**
     * 查询
     */
    @Override
    public FmPlayerOthers selectFmPlayerOthersById(Long id)
    {
        return fmPlayerOthersMapper.selectFmPlayerOthersById(id);
    }

    @Override
    public List<FmPlayerOthers> selectFmPlayerOthersList(FmPlayerOthers fmPlayerOthers)
    {
        return fmPlayerOthersMapper.selectFmPlayerOthersList(fmPlayerOthers);
    }

    /**
     * 新增
     */
    @Override
    public int insertFmPlayerOthers(FmPlayerOthers fmPlayerOthers)
    {
        return fmPlayerOthersMapper.insertFmPlayerOthers(fmPlayerOthers);
    }

    /**
     * 修改
     */
    @Override
    public int updateFmPlayerOthers(FmPlayerOthers fmPlayerOthers)
    {
        return fmPlayerOthersMapper.updateFmPlayerOthers(fmPlayerOthers);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleteFmPlayerOthersByIds(Long[] ids)
    {
        return fmPlayerOthersMapper.deleteFmPlayerOthersByIds(ids);
    }

    /**
     * 删除信息
     */
    @Override
    public int deleteFmPlayerOthersById(Long id)
    {
        return fmPlayerOthersMapper.deleteFmPlayerOthersById(id);
    }
}
