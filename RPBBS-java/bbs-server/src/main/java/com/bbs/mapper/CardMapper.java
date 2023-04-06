package com.bbs.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bbs.domain.Card;
import org.apache.ibatis.annotations.Mapper;

/**
 * 帖子Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@Mapper
public interface CardMapper extends BaseMapper<Card>
{
    /**
     * 查询帖子
     * 
     * @param id 帖子主键
     * @return 帖子
     */
    public Card selectCardById(Long id);

    /**
     * 查询帖子列表
     * 
     * @param card 帖子
     * @return 帖子集合
     */
    public List<Card> selectCardList(Card card);

    /**
     * 新增帖子
     * 
     * @param card 帖子
     * @return 结果
     */
    public int insertCard(Card card);

    /**
     * 修改帖子
     * 
     * @param card 帖子
     * @return 结果
     */
    public int updateCard(Card card);

    /**
     * 删除帖子
     * 
     * @param id 帖子主键
     * @return 结果
     */
    public int deleteCardById(Long id);

    /**
     * 批量删除帖子
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCardByIds(Long[] ids);
}
