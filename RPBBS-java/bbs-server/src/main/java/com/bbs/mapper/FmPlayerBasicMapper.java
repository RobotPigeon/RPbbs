package com.bbs.mapper;

import com.bbs.domain.fm.FmPlayerBasic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FmPlayerBasicMapper 
{
    /**
     * 查询
     */
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
     * 删除
     */
    public int deleteFmPlayerBasicById(Long id);

    /**
     * 批量删除
     */
    public int deleteFmPlayerBasicByIds(Long[] ids);
}
