package com.ruoyi.bbs.service.impl;

import java.util.List;

import com.ruoyi.bbs.domain.CardType;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bbs.mapper.CardTypeMapper;
import com.ruoyi.bbs.service.ICardTypeService;

/**
 * 帖子类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Service
public class CardTypeServiceImpl implements ICardTypeService 
{
    @Autowired
    private CardTypeMapper cardTypeMapper;

    /**
     * 查询帖子类型
     * 
     * @param id 帖子类型主键
     * @return 帖子类型
     */
    @Override
    public CardType selectCardTypeById(Long id)
    {
        return cardTypeMapper.selectCardTypeById(id);
    }

    /**
     * 查询帖子类型列表
     * 
     * @param cardType 帖子类型
     * @return 帖子类型
     */
    @Override
    public List<CardType> selectCardTypeList(CardType cardType)
    {
        return cardTypeMapper.selectCardTypeList(cardType);
    }

    /**
     * 新增帖子类型
     * 
     * @param cardType 帖子类型
     * @return 结果
     */
    @Override
    public int insertCardType(CardType cardType)
    {
        cardType.setCreateTime(DateUtils.getNowDate());
        return cardTypeMapper.insertCardType(cardType);
    }

    /**
     * 修改帖子类型
     * 
     * @param cardType 帖子类型
     * @return 结果
     */
    @Override
    public int updateCardType(CardType cardType)
    {
        cardType.setUpdateTime(DateUtils.getNowDate());
        return cardTypeMapper.updateCardType(cardType);
    }

    /**
     * 批量删除帖子类型
     * 
     * @param ids 需要删除的帖子类型主键
     * @return 结果
     */
    @Override
    public int deleteCardTypeByIds(Long[] ids)
    {
        return cardTypeMapper.deleteCardTypeByIds(ids);
    }

    /**
     * 删除帖子类型信息
     * 
     * @param id 帖子类型主键
     * @return 结果
     */
    @Override
    public int deleteCardTypeById(Long id)
    {
        return cardTypeMapper.deleteCardTypeById(id);
    }
}
