package com.bbs.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.Card;
import com.bbs.domain.CardInfo;
import com.bbs.domain.dto.CardDto;
import com.bbs.domain.vo.CardVo;
import com.bbs.service.ICardInfoService;
import com.bbs.service.ICardReplyService;
import com.bbs.service.ICardService;
import com.bbs.service.ICardOperateService;
import com.bbs.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CardOperateServiceImpl implements ICardOperateService {
    @Autowired
    private ICardService cardService;

    @Autowired
    private ICardInfoService cardInfoService;

    @Autowired
    private ICardReplyService cardReplyService;

    @Autowired
    private ServerProperties serverProperties;

    @Override
    public int addTotalCard(CardDto cardDto) {
        Long current = System.currentTimeMillis();
        Date addDate = new Date(current);

//        // save sourceFile
//        String sourcePath = FileUtils.upload(cardDto.getSourceFile());
//        if (sourcePath == null) {
//            return -1;
//        }
//        cardDto.setSourcePath(sourcePath);

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
    public IPage<CardVo> cardTotalList(Page page) throws UnknownHostException {
        IPage<Card> cardList = cardService.page(page);

        // get cardId
        List<Long> cardIdList = new ArrayList<>();
        for (Card c: cardList.getRecords()) {
            cardIdList.add(c.getId());
        }
        log.info("get cards' id: { "+cardIdList.toString()+" }");

        // get rel cardInfo
        List<CardInfo> cardInfoList = cardInfoService.selectCardInfoByCardIds((Long[]) cardIdList.toArray(new Long[cardIdList.size()]));

        // create cardVo
        List<CardVo> cardVoList = new ArrayList<>();
        for (Card c : cardList.getRecords()) {
            for (CardInfo ci: cardInfoList) {
                if (ci.getCardId().equals(c.getId().toString())) {
                    cardVoList.add(new CardVo(c,ci));
                }
            }
        }

        // get commintNum
        for (int i=0; i<cardVoList.size(); i++) {
            CardVo cardVoToGetCommitNum = cardVoList.get(i);
            Long commitNum = cardReplyService.countCardReplyByCardId(cardVoToGetCommitNum.getCardId());
            cardVoToGetCommitNum.setCommentNum(commitNum);
        }

        //
        for (int i=0;i<cardVoList.size();i++) {
            CardVo cv = cardVoList.get(i);
            cv.setSourcePath(InetAddress.getLocalHost().getHostAddress()+":"+serverProperties.getPort()+cv.getSourcePath());
        }
        // create return Page<CardVo>
        Page<CardVo> cardVoPage = new Page<>(page.getCurrent(),page.getSize());
        cardVoPage.setRecords(cardVoList);

//        Card card = new Card();
//        CardInfo cardInfo = new CardInfo();
//        List cardList = cardService.selectCardList(card);
//        List cardInfoList = cardInfoService.selectCardInfoList(cardInfo);

        return cardVoPage;
    }
}
