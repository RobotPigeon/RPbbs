package com.bbs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bbs.mapper.CardReplyReplyMapper;
import com.bbs.domain.CardReplyReply;
import com.bbs.service.ICardReplyReplyService;

/**
 * 二级回复帖子Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Service
public class CardReplyReplyServiceImpl implements ICardReplyReplyService 
{
    @Autowired
    private CardReplyReplyMapper cardReplyReplyMapper;

    /**
     * 查询二级回复帖子
     * 
     * @param id 二级回复帖子主键
     * @return 二级回复帖子
     */
    @Override
    public CardReplyReply selectCardReplyReplyById(Long id)
    {
        return cardReplyReplyMapper.selectCardReplyReplyById(id);
    }

    /**
     * 查询二级回复帖子列表
     * 
     * @param cardReplyReply 二级回复帖子
     * @return 二级回复帖子
     */
    @Override
    public List<CardReplyReply> selectCardReplyReplyList(CardReplyReply cardReplyReply)
    {
        return cardReplyReplyMapper.selectCardReplyReplyList(cardReplyReply);
    }

    /**
     * 新增二级回复帖子
     * 
     * @param cardReplyReply 二级回复帖子
     * @return 结果
     */
    @Override
    public int insertCardReplyReply(CardReplyReply cardReplyReply)
    {
        return cardReplyReplyMapper.insertCardReplyReply(cardReplyReply);
    }

    /**
     * 修改二级回复帖子
     * 
     * @param cardReplyReply 二级回复帖子
     * @return 结果
     */
    @Override
    public int updateCardReplyReply(CardReplyReply cardReplyReply)
    {
        return cardReplyReplyMapper.updateCardReplyReply(cardReplyReply);
    }

    /**
     * 批量删除二级回复帖子
     * 
     * @param ids 需要删除的二级回复帖子主键
     * @return 结果
     */
    @Override
    public int deleteCardReplyReplyByIds(Long[] ids)
    {
        return cardReplyReplyMapper.deleteCardReplyReplyByIds(ids);
    }

    /**
     * 删除二级回复帖子信息
     * 
     * @param id 二级回复帖子主键
     * @return 结果
     */
    @Override
    public int deleteCardReplyReplyById(Long id)
    {
        return cardReplyReplyMapper.deleteCardReplyReplyById(id);
    }
}
