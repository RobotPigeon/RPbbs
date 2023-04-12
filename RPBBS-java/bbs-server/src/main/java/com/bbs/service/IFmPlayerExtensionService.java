package com.bbs.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.fm.FmPlayerBasic;
import com.bbs.domain.vo.FmPlayerVo;

import java.util.List;

/**
 * 球员扩展数据获取业务
 */
public interface IFmPlayerExtensionService {

    /**
     * 通过球员id获取球员完整数据
     * @param id
     * @return
     */
    FmPlayerVo selectFmPlayerVoById(Long id);

    /**
     * 通过球员basic来条件查询出完整数据表
     * @param body
     * @return
     */
    // 不使用
    List<FmPlayerVo> selectFmPlayerVoList(FmPlayerBasic body);

    /**
     * 分页查询
     * @param page
     * @return
     */
    // 不使用
    IPage<FmPlayerVo> selectFmPlayerVoPage(Page page);

    /**
     * 带查询条件的page分页查询
     * @param page
     * @param wrapper
     * @return
     */
    // 不使用
    IPage<FmPlayerVo> selectFmPlayerVoPage(Page page, Wrapper wrapper);
}
