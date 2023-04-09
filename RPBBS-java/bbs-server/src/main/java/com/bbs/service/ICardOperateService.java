package com.bbs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.dto.CardDto;
import com.bbs.domain.vo.CardReplyVo;
import com.bbs.domain.vo.CardVo;
import org.springframework.web.multipart.MultipartFile;

import java.net.UnknownHostException;
import java.util.List;

public interface ICardOperateService {
    /**
     * 帖子发布
     * @param cardDto
     * @return
     */
    public int addTotalCard(CardDto cardDto);

    /**
     * 分页帖子获取
     * @param
     * @return
     */
    public IPage<CardVo> cardTotalPage(Page page) throws UnknownHostException;

    public IPage<CardReplyVo> cardReplyPage(Page page, String cardId);
}
