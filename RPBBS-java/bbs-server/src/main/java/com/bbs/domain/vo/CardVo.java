package com.bbs.domain.vo;

import com.bbs.domain.Card;
import com.bbs.domain.CardInfo;
import com.bbs.domain.dto.CardDto;
import lombok.Data;

@Data
public class CardVo extends CardDto {
    private Long commentNum;

    public CardVo() {}

    public CardVo(Card card, CardInfo cardInfo) {
        super(card, cardInfo);
    }
}
