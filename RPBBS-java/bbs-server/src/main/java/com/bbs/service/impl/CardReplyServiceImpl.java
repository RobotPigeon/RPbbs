package com.bbs.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bbs.mapper.CardReplyMapper;
import com.bbs.domain.CardReply;
import com.bbs.service.ICardReplyService;

/**
 * 回复帖子Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Service
public class CardReplyServiceImpl extends ServiceImpl<CardReplyMapper, CardReply> implements ICardReplyService
{
    @Autowired
    private CardReplyMapper cardReplyMapper;

    /**
     * 查询回复帖子
     * 
     * @param id 回复帖子主键
     * @return 回复帖子
     */
    @Override
    public CardReply selectCardReplyById(Long id)
    {
        return cardReplyMapper.selectCardReplyById(id);
    }

    /**
     * 查询回复帖子列表
     * 
     * @param cardReply 回复帖子
     * @return 回复帖子
     */
    @Override
    public List<CardReply> selectCardReplyList(CardReply cardReply)
    {
        return cardReplyMapper.selectCardReplyList(cardReply);
    }

    /**
     * 新增回复帖子
     * 
     * @param cardReply 回复帖子
     * @return 结果
     */
    @Override
    public int insertCardReply(CardReply cardReply)
    {
        return cardReplyMapper.insertCardReply(cardReply);
    }

    /**
     * 修改回复帖子
     * 
     * @param cardReply 回复帖子
     * @return 结果
     */
    @Override
    public int updateCardReply(CardReply cardReply)
    {
        return cardReplyMapper.updateCardReply(cardReply);
    }

    /**
     * 批量删除回复帖子
     * 
     * @param ids 需要删除的回复帖子主键
     * @return 结果
     */
    @Override
    public int deleteCardReplyByIds(Long[] ids)
    {
        return cardReplyMapper.deleteCardReplyByIds(ids);
    }

    /**
     * 删除回复帖子信息
     * 
     * @param id 回复帖子主键
     * @return 结果
     */
    @Override
    public int deleteCardReplyById(Long id)
    {
        return cardReplyMapper.deleteCardReplyById(id);
    }
}
