package com.ruoyi.bbs.service.impl;

import java.util.List;

import com.ruoyi.bbs.domain.Card;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bbs.mapper.CardMapper;
import com.ruoyi.bbs.service.ICardService;

/**
 * 帖子Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Service
public class CardServiceImpl implements ICardService 
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
        card.setCreateTime(DateUtils.getNowDate());
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
        card.setUpdateTime(DateUtils.getNowDate());
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
