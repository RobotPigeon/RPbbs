package com.bbs.domain.vo;

import com.bbs.constant.AdressConst;
import com.bbs.domain.CardInfo;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class CardInfoVo extends CardInfo {
    private List<String> sourcePaths;

    public CardInfoVo(CardInfo cardInfo) {
        this.setId(cardInfo.getId());
        this.setCardId(cardInfo.getCardId());
        this.setCardTypeId(cardInfo.getCardTypeId());
        this.setLikeNum(cardInfo.getLikeNum());
        this.setRichtext(cardInfo.getRichtext());
        this.setSourcePath(cardInfo.getSourcePath());
        if (cardInfo.getSourcePath() != null && !cardInfo.getSourcePath().equals("")) {
            String[] sourcePathStrs = cardInfo.getSourcePath().split(";");
            this.sourcePaths = Arrays.asList(sourcePathStrs);
            for (int i = 0; i < this.sourcePaths.size(); i++) {
                this.sourcePaths.set(i, AdressConst.httpAdress + this.sourcePaths.get(i));
            }
        }
    }
}
