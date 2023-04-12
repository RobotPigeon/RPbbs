package com.bbs.service.impl;

import java.util.List;

import com.bbs.domain.fm.FmPlayerBasic;
import com.bbs.mapper.FmPlayerBasicMapper;
import com.bbs.service.IFmPlayerBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FmPlayerBasicServiceImpl implements IFmPlayerBasicService
{
    @Autowired
    private FmPlayerBasicMapper fmPlayerBasicMapper;

    /**
     * 查询
     */
    @Override
    public FmPlayerBasic selectFmPlayerBasicById(Long id)
    {
        return fmPlayerBasicMapper.selectFmPlayerBasicById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<FmPlayerBasic> selectFmPlayerBasicList(FmPlayerBasic fmPlayerBasic)
    {
        return fmPlayerBasicMapper.selectFmPlayerBasicList(fmPlayerBasic);
    }

    /**
     * 新增
     */
    @Override
    public int insertFmPlayerBasic(FmPlayerBasic fmPlayerBasic)
    {
        return fmPlayerBasicMapper.insertFmPlayerBasic(fmPlayerBasic);
    }

    /**
     * 修改
     */
    @Override
    public int updateFmPlayerBasic(FmPlayerBasic fmPlayerBasic)
    {
        return fmPlayerBasicMapper.updateFmPlayerBasic(fmPlayerBasic);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleteFmPlayerBasicByIds(Long[] ids)
    {
        return fmPlayerBasicMapper.deleteFmPlayerBasicByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deleteFmPlayerBasicById(Long id)
    {
        return fmPlayerBasicMapper.deleteFmPlayerBasicById(id);
    }
}
