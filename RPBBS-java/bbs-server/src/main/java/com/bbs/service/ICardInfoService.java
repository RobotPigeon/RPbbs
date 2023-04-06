package com.bbs.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.bbs.domain.CardInfo;

/**
 * 帖子信息Service接口
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
public interface ICardInfoService extends IService<CardInfo>
{
    /**
     * 查询帖子信息
     * 
     * @param id 帖子信息主键
     * @return 帖子信息
     */
    public CardInfo selectCardInfoById(Long id);

    /**
     * 查询帖子信息列表
     * 
     * @param cardInfo 帖子信息
     * @return 帖子信息集合
     */
    public List<CardInfo> selectCardInfoList(CardInfo cardInfo);

    /**
     * 新增帖子信息
     * 
     * @param cardInfo 帖子信息
     * @return 结果
     */
    public int insertCardInfo(CardInfo cardInfo);

    /**
     * 修改帖子信息
     * 
     * @param cardInfo 帖子信息
     * @return 结果
     */
    public int updateCardInfo(CardInfo cardInfo);

    /**
     * 批量删除帖子信息
     * 
     * @param ids 需要删除的帖子信息主键集合
     * @return 结果
     */
    public int deleteCardInfoByIds(Long[] ids);

    /**
     * 删除帖子信息信息
     * 
     * @param id 帖子信息主键
     * @return 结果
     */
    public int deleteCardInfoById(Long id);
}
