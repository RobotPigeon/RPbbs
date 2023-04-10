package com.bbs.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.CardInfo;
import com.bbs.domain.vo.CardInfoVo;

import java.util.List;

public interface ICardInfoVoService {
    public CardInfoVo selectCardInfoVoById(Long id);

    public List<CardInfoVo> selectCardInfoVoList(CardInfo cardInfo);

    public List<CardInfoVo> selectCardInfoVoByCardIds(Long[] ids);

    public IPage<CardInfoVo> page(Page page);

    public IPage<CardInfoVo> page(Page page, Wrapper wrapper);

}
