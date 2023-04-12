package com.bbs.service;

import com.bbs.domain.fm.FmPlayerBasic;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
public interface IFmPlayerBasicService 
{
    public FmPlayerBasic selectFmPlayerBasicById(Long id);

    /**
     * 查询列表
     */
    public List<FmPlayerBasic> selectFmPlayerBasicList(FmPlayerBasic fmPlayerBasic);

    /**
     * 新增
     */
    public int insertFmPlayerBasic(FmPlayerBasic fmPlayerBasic);

    /**
     * 修改
     */
    public int updateFmPlayerBasic(FmPlayerBasic fmPlayerBasic);

    /**
     * 批量删除
     */
    public int deleteFmPlayerBasicByIds(Long[] ids);

    /**
     * 删除
     */
    public int deleteFmPlayerBasicById(Long id);
}
