package com.bbs.service.impl;

import com.bbs.domain.Card;
import com.bbs.domain.CardInfo;
import com.bbs.domain.dto.CardDto;
import com.bbs.domain.vo.CardVo;
import com.bbs.service.ICardInfoService;
import com.bbs.service.ICardService;
import com.bbs.service.ICardManageService;
import com.bbs.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CardManageServiceImpl implements ICardManageService {
    @Autowired
    private ICardService cardService;

    @Autowired
    private ICardInfoService cardInfoService;

    @Override
    public int addTotalCard(CardDto cardDto) {
        Long current = System.currentTimeMillis();
        Date addDate = new Date(current);

        // save sourceFile
        String sourcePath = FileUtils.upload(cardDto.getSourceFile());
        if (sourcePath == null) {
            return -1;
        }
        cardDto.setSourcePath(sourcePath);

        // add Card
        Card card = new Card();
        card.setTitle(cardDto.getTitle());
        card.setCreateById(cardDto.getCreateById());
        card.setMessage(cardDto.getMessage());
        card.setBlockId(cardDto.getBlockId());
        card.setCreateTime(addDate);
        card.setUpdateTime(addDate);
        if (cardService.insertCard(card)<=0) {
            return -1;
        }
        Long cardId = cardService.selectCardList(card).get(0).getId();

        // add CardInfo
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardId(String.valueOf(cardId));
        cardInfo.setCardTypeId(cardDto.getCardTypeId());
        cardInfo.setRichtext(cardDto.getRichtext());
        cardInfo.setSourcePath(cardDto.getSourcePath());
        if (cardInfoService.insertCardInfo(cardInfo)<=0) {
            return -1;
        }

        return 0;
    }

    @Override
    public List<CardVo> cardList(int[] ids) {
        List list = new ArrayList<>();

//        Card card = new Card();
//        CardInfo cardInfo = new CardInfo();
//        List cardList = cardService.selectCardList(card);
//        List cardInfoList = cardInfoService.selectCardInfoList(cardInfo);

        /*
        帖子具体信息查询方案
         */

        return list;
    }
}
