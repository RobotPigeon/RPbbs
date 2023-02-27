package com.bbs.service;

import java.util.List;
import com.bbs.domain.CardType;

/**
 * 帖子类型Service接口
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
public interface ICardTypeService 
{
    /**
     * 查询帖子类型
     * 
     * @param id 帖子类型主键
     * @return 帖子类型
     */
    public CardType selectCardTypeById(Long id);

    /**
     * 查询帖子类型列表
     * 
     * @param cardType 帖子类型
     * @return 帖子类型集合
     */
    public List<CardType> selectCardTypeList(CardType cardType);

    /**
     * 新增帖子类型
     * 
     * @param cardType 帖子类型
     * @return 结果
     */
    public int insertCardType(CardType cardType);

    /**
     * 修改帖子类型
     * 
     * @param cardType 帖子类型
     * @return 结果
     */
    public int updateCardType(CardType cardType);

    /**
     * 批量删除帖子类型
     * 
     * @param ids 需要删除的帖子类型主键集合
     * @return 结果
     */
    public int deleteCardTypeByIds(Long[] ids);

    /**
     * 删除帖子类型信息
     * 
     * @param id 帖子类型主键
     * @return 结果
     */
    public int deleteCardTypeById(Long id);
}
