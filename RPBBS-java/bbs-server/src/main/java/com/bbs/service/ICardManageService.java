package com.bbs.service;

import com.bbs.domain.dto.CardDto;
import com.bbs.domain.vo.CardVo;

import java.util.List;

public interface ICardManageService {
    /**
     * 帖子发布
     * @param cardDto
     * @return
     */
    public int addTotalCard(CardDto cardDto);

    /**
     * 帖子获取
     * @param ids
     * @return
     */
    public List<CardVo> cardList(int[] ids);
}
