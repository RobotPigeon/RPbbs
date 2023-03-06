package com.ruoyi.bbs.mapper;

import java.util.List;
import com.ruoyi.bbs.domain.CardReply;

/**
 * 回复帖子Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
public interface CardReplyMapper 
{
    /**
     * 查询回复帖子
     * 
     * @param id 回复帖子主键
     * @return 回复帖子
     */
    public CardReply selectCardReplyById(Long id);

    /**
     * 查询回复帖子列表
     * 
     * @param cardReply 回复帖子
     * @return 回复帖子集合
     */
    public List<CardReply> selectCardReplyList(CardReply cardReply);

    /**
     * 新增回复帖子
     * 
     * @param cardReply 回复帖子
     * @return 结果
     */
    public int insertCardReply(CardReply cardReply);

    /**
     * 修改回复帖子
     * 
     * @param cardReply 回复帖子
     * @return 结果
     */
    public int updateCardReply(CardReply cardReply);

    /**
     * 删除回复帖子
     * 
     * @param id 回复帖子主键
     * @return 结果
     */
    public int deleteCardReplyById(Long id);

    /**
     * 批量删除回复帖子
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCardReplyByIds(Long[] ids);
}
