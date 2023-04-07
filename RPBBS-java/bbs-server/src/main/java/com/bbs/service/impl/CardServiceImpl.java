package com.bbs.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bbs.mapper.CardMapper;
import com.bbs.domain.Card;
import com.bbs.service.ICardService;

/**
 * 帖子Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements ICardService
{
    @Autowired
    private CardMapper cardMapper;

    /**
     * 查询帖子
     * 
     * @param id 帖子主键
     * @return 帖子
     */
    @Override
    public Card selectCardById(Long id)
    {
        return cardMapper.selectCardById(id);
    }

    /**
     * 查询帖子列表
     * 
     * @param card 帖子
     * @return 帖子
     */
    @Override
    public List<Card> selectCardList(Card card)
    {
        return cardMapper.selectCardList(card);
    }

    /**
     * 新增帖子
     * 
     * @param card 帖子
     * @return 结果
     */
    @Override
    public int insertCard(Card card)
    {
        return cardMapper.insertCard(card);
    }

    /**
     * 修改帖子
     * 
     * @param card 帖子
     * @return 结果
     */
    @Override
    public int updateCard(Card card)
    {
        return cardMapper.updateCard(card);
    }

    /**
     * 批量删除帖子
     * 
     * @param ids 需要删除的帖子主键
     * @return 结果
     */
    @Override
    public int deleteCardByIds(Long[] ids)
    {
        return cardMapper.deleteCardByIds(ids);
    }

    /**
     * 删除帖子信息
     * 
     * @param id 帖子主键
     * @return 结果
     */
    @Override
    public int deleteCardById(Long id)
    {
        return cardMapper.deleteCardById(id);
    }
}
