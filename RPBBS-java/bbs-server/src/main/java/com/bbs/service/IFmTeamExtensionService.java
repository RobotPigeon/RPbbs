package com.bbs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.fm.FmPlayerBasic;
import com.bbs.domain.fm.FmTeamBasic;
import com.bbs.domain.vo.FmTeamVo;

import java.util.List;

public interface IFmTeamExtensionService {

    /**
     * 根据球队名称获取该全队全部球员信息
     * @param param 球队名称
     * @return
     */
    List<FmPlayerBasic> selectFmPlayerBasicByFmTeamBasicSquad(String param);

    List<FmTeamVo> selectFmTeamVoListWithFmplayerBasic();

    IPage<FmTeamVo> selectFmTeamVoPageWithFmplayerBasic(Page page);
}
