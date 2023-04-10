package com.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.Card;
import com.bbs.domain.CardInfo;
import com.bbs.domain.CardReply;
import com.bbs.domain.CardReplyReply;
import com.bbs.domain.dto.CardDto;
import com.bbs.domain.vo.CardReplyVo;
import com.bbs.domain.vo.CardVo;
import com.bbs.service.*;
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
    private ICardReplyReplyService cardReplyReplyService;

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

        // get address
        String address = null;
        try {
            address = "http://"+InetAddress.getLocalHost().getHostAddress()+":"+serverProperties.getPort();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        // add CardInfo
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardId(String.valueOf(cardId));
        cardInfo.setCardTypeId(cardDto.getCardTypeId());
        cardInfo.setRichtext(cardDto.getRichtext());
        for (int i=0;i<cardDto.getSourcePath().size();i++) {
//            log.info(cardDto.getSourcePath().get(i));
            cardDto.getSourcePath().set(i, cardDto.getSourcePath().get(i).replaceFirst(address, ""));
//            log.info(cardDto.getSourcePath().get(i));
        }

        String sourcePath = String.join(";",cardDto.getSourcePath());
        cardInfo.setSourcePath(sourcePath);
        if (cardInfoService.insertCardInfo(cardInfo)<=0) {
            return -1;
        }

        return 0;
    }

    @Override
    public IPage<CardVo> cardTotalPage(Page page) throws UnknownHostException {
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

        String address = InetAddress.getLocalHost().getHostAddress()+":"+serverProperties.getPort();
        // 修改sourcePath
        for (int i=0;i<cardVoList.size();i++) {
            CardVo cv = cardVoList.get(i);
            List<String> sourcePaths = cv.getSourcePath();
            for (int j=0;j<sourcePaths.size();j++) {
                sourcePaths.set(j, address+sourcePaths.get(j));
//                cv.setSourcePath(InetAddress.getLocalHost().getHostAddress()+":"+serverProperties.getPort()+cv.getSourcePath());
            }

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

    @Override
    public IPage<CardReplyVo> cardReplyPage(Page page, String cardId) {
        QueryWrapper<CardReply> cardReplyQueryWrapper = new QueryWrapper<>();
        cardReplyQueryWrapper.eq("card_id", cardId);
        IPage<CardReply> replyPage = cardReplyService.page(page, cardReplyQueryWrapper);

        CardReplyReply cardReplyReply = new CardReplyReply();
        cardReplyReply.setCardId(cardId);
        List<CardReplyReply> cardReplyReplyList = cardReplyReplyService.selectCardReplyReplyList(cardReplyReply);

        List<CardReplyVo> cardReplyVoList = new ArrayList<>();

        for (CardReply cr:replyPage.getRecords()) {
            CardReplyVo cardReplyVo = new CardReplyVo(cr);
            List<CardReplyReply> cardReplyVoInnerList = new ArrayList<>();
            for (CardReplyReply crr:cardReplyReplyList) {
                if (crr.getReplyId().equals(cr.getId().toString())) {
                    cardReplyVoInnerList.add(crr);
                }
            }
            cardReplyVo.setCardReplyReplyList(cardReplyVoInnerList);
            cardReplyVoList.add(cardReplyVo);
        }

        Page<CardReplyVo> cardReplyVoIPage = new Page(page.getCurrent(), page.getSize());
        cardReplyVoIPage.setRecords(cardReplyVoList);

        return cardReplyVoIPage;
    }
}
