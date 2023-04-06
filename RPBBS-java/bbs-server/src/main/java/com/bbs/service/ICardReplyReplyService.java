package com.bbs.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.bbs.domain.CardReplyReply;

/**
 * 二级回复帖子Service接口
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
public interface ICardReplyReplyService extends IService<CardReplyReply>
{
    /**
     * 查询二级回复帖子
     * 
     * @param id 二级回复帖子主键
     * @return 二级回复帖子
     */
    public CardReplyReply selectCardReplyReplyById(Long id);

    /**
     * 查询二级回复帖子列表
     * 
     * @param cardReplyReply 二级回复帖子
     * @return 二级回复帖子集合
     */
    public List<CardReplyReply> selectCardReplyReplyList(CardReplyReply cardReplyReply);

    /**
     * 新增二级回复帖子
     * 
     * @param cardReplyReply 二级回复帖子
     * @return 结果
     */
    public int insertCardReplyReply(CardReplyReply cardReplyReply);

    /**
     * 修改二级回复帖子
     * 
     * @param cardReplyReply 二级回复帖子
     * @return 结果
     */
    public int updateCardReplyReply(CardReplyReply cardReplyReply);

    /**
     * 批量删除二级回复帖子
     * 
     * @param ids 需要删除的二级回复帖子主键集合
     * @return 结果
     */
    public int deleteCardReplyReplyByIds(Long[] ids);

    /**
     * 删除二级回复帖子信息
     * 
     * @param id 二级回复帖子主键
     * @return 结果
     */
    public int deleteCardReplyReplyById(Long id);
}
