package com.bbs.domain.vo;

import com.bbs.domain.CardReply;
import com.bbs.domain.CardReplyReply;
import lombok.Data;

import java.util.List;

@Data
public class CardReplyVo extends CardReply {
    private List<CardReplyReply> cardReplyReplyList;

    public CardReplyVo() {}

    public CardReplyVo(CardReply cardReply) {
        super(cardReply.getId()
                ,cardReply.getCardId()
                ,cardReply.getCreateById()
                ,cardReply.getCardId()
                ,cardReply.getRank()
                ,cardReply.getStatus()
                ,cardReply.getCreateTime()
                ,cardReply.getUpdateTime());
    }
}
