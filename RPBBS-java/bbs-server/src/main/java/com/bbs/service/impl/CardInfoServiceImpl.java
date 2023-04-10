package com.bbs.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbs.constant.AdressConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bbs.mapper.CardInfoMapper;
import com.bbs.domain.CardInfo;
import com.bbs.service.ICardInfoService;

/**
 * 帖子信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Service
public class CardInfoServiceImpl extends ServiceImpl<CardInfoMapper, CardInfo> implements ICardInfoService
{
    @Autowired
    private CardInfoMapper cardInfoMapper;

    /**
     * 查询帖子信息
     * 
     * @param id 帖子信息主键
     * @return 帖子信息
     */
    @Override
    public CardInfo selectCardInfoById(Long id)
    {
        CardInfo cardInfo = cardInfoMapper.selectCardInfoById(id);
        cardInfo.setSourcePath(AdressConst.httpAdress+cardInfo.getSourcePath());
        return cardInfo;
    }

    /**
     * 查询帖子信息列表
     * 
     * @param cardInfo 帖子信息
     * @return 帖子信息
     */
    @Override
    public List<CardInfo> selectCardInfoList(CardInfo cardInfo)
    {
        List<CardInfo> list = cardInfoMapper.selectCardInfoList(cardInfo);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setSourcePath(AdressConst.httpAdress+list.get(i).getSourcePath());
        }
        return list;
    }

    @Override
    public List<CardInfo> selectCardInfoByCardIds(Long[] ids) {
        List<CardInfo> list = cardInfoMapper.selectCardInfoByCardIds(ids);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setSourcePath(AdressConst.httpAdress+list.get(i).getSourcePath());
        }
        return list;
    }

    /**
     * 新增帖子信息
     * 
     * @param cardInfo 帖子信息
     * @return 结果
     */
    @Override
    public int insertCardInfo(CardInfo cardInfo)
    {
        return cardInfoMapper.insertCardInfo(cardInfo);
    }

    /**
     * 修改帖子信息
     * 
     * @param cardInfo 帖子信息
     * @return 结果
     */
    @Override
    public int updateCardInfo(CardInfo cardInfo)
    {
        return cardInfoMapper.updateCardInfo(cardInfo);
    }

    /**
     * 批量删除帖子信息
     * 
     * @param ids 需要删除的帖子信息主键
     * @return 结果
     */
    @Override
    public int deleteCardInfoByIds(Long[] ids)
    {
        return cardInfoMapper.deleteCardInfoByIds(ids);
    }

    /**
     * 删除帖子信息信息
     * 
     * @param id 帖子信息主键
     * @return 结果
     */
    @Override
    public int deleteCardInfoById(Long id)
    {
        return cardInfoMapper.deleteCardInfoById(id);
    }
}
