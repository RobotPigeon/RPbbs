package com.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.CardInfo;
import com.bbs.domain.vo.CardInfoVo;
import com.bbs.mapper.CardInfoMapper;
import com.bbs.service.ICardInfoVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardInfoVoServiceImpl implements ICardInfoVoService {

    @Autowired
    private CardInfoMapper cardInfoMapper;

    @Override
    public CardInfoVo selectCardInfoVoById(Long id) {
        CardInfo cardInfo = cardInfoMapper.selectCardInfoById(id);
        CardInfoVo cardInfoVo = new CardInfoVo(cardInfo);
//        if (cardInfo.getSourcePath() != null && !cardInfo.getSourcePath().equals("")) {
//            cardInfo.setSourcePath(AdressConst.httpAdress+cardInfo.getSourcePath());
//        }
        return cardInfoVo;
    }

    @Override
    public List<CardInfoVo> selectCardInfoVoList(CardInfo cardInfo) {
        List<CardInfo> cardInfos = cardInfoMapper.selectCardInfoList(cardInfo);
        List<CardInfoVo> list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getSourcePath() != null && !list.get(i).getSourcePath().equals("")) {
//                list.get(i).setSourcePath(AdressConst.httpAdress+list.get(i).getSourcePath());
//            }
            list.add(new CardInfoVo(cardInfos.get(i)));
        }
        return list;
    }

    @Override
    public List<CardInfoVo> selectCardInfoVoByCardIds(Long[] ids) {
        List<CardInfo> cardInfos = cardInfoMapper.selectCardInfoByCardIds(ids);
        List<CardInfoVo> list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getSourcePath() != null && !list.get(i).getSourcePath().equals("")) {
//                list.get(i).setSourcePath(AdressConst.httpAdress+list.get(i).getSourcePath());
//            }
            list.add(new CardInfoVo(cardInfos.get(i)));
        }
        return list;
    }

    @Override
    public IPage<CardInfoVo> page(Page page) {
        IPage<CardInfo> cardInfoPage = cardInfoMapper.selectPage(page, new QueryWrapper<>());
        Page<CardInfoVo> cardInfoVoPage = new Page<>(page.getCurrent(),page.getSize());
        List<CardInfoVo> cardInfoVoRecords = new ArrayList<>();
        for (int i = 0; i < cardInfoPage.getRecords().size(); i++) {
            cardInfoVoRecords.add(new CardInfoVo(cardInfoPage.getRecords().get(i)));
        }
        cardInfoVoPage.setRecords(cardInfoVoRecords);

        // page setting inherit
        cardInfoVoPage.setTotal(cardInfoPage.getTotal());
        cardInfoVoPage.setOrders(cardInfoPage.orders());
        cardInfoVoPage.setOptimizeCountSql(cardInfoPage.optimizeCountSql());
        cardInfoVoPage.setSearchCount(cardInfoPage.searchCount());
        cardInfoVoPage.setMaxLimit(cardInfoPage.maxLimit());
        cardInfoVoPage.setCountId(cardInfoPage.countId());
        cardInfoVoPage.setPages(cardInfoPage.getPages());

        return cardInfoVoPage;
    }

    @Override
    public IPage<CardInfoVo> page(Page page, Wrapper wrapper) {
        IPage<CardInfo> cardInfoPage = cardInfoMapper.selectPage(page, wrapper);
        Page<CardInfoVo> cardInfoVoPage = new Page<>(page.getCurrent(),page.getSize());
        List<CardInfoVo> cardInfoVoRecords = new ArrayList<>();
        for (int i = 0; i < cardInfoPage.getRecords().size(); i++) {
            cardInfoVoRecords.add(new CardInfoVo(cardInfoPage.getRecords().get(i)));
        }
        cardInfoVoPage.setRecords(cardInfoVoRecords);

        // page setting inherit
        cardInfoVoPage.setTotal(cardInfoPage.getTotal());
        cardInfoVoPage.setOrders(cardInfoPage.orders());
        cardInfoVoPage.setOptimizeCountSql(cardInfoPage.optimizeCountSql());
        cardInfoVoPage.setSearchCount(cardInfoPage.searchCount());
        cardInfoVoPage.setMaxLimit(cardInfoPage.maxLimit());
        cardInfoVoPage.setCountId(cardInfoPage.countId());
        cardInfoVoPage.setPages(cardInfoPage.getPages());

        return cardInfoVoPage;
    }
}
