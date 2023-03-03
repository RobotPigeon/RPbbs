package com.bbs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bbs.mapper.BlockMapper;
import com.bbs.domain.Block;
import com.bbs.service.IBlockService;

/**
 * 帖子板块Service业务层处理
 * 
 * @author wws
 * @date 2023-02-27
 */
@Service
public class BlockServiceImpl implements IBlockService 
{
    @Autowired
    private BlockMapper blockMapper;

    /**
     * 查询帖子板块
     * 
     * @param id 帖子板块主键
     * @return 帖子板块
     */
    @Override
    public Block selectBlockById(Long id)
    {
        return blockMapper.selectBlockById(id);
    }

    /**
     * 查询帖子板块列表
     * 
     * @param block 帖子板块
     * @return 帖子板块
     */
    @Override
    public List<Block> selectBlockList(Block block)
    {
        return blockMapper.selectBlockList(block);
    }

    /**
     * 新增帖子板块
     * 
     * @param block 帖子板块
     * @return 结果
     */
    @Override
    public int insertBlock(Block block)
    {
        return blockMapper.insertBlock(block);
    }

    /**
     * 修改帖子板块
     * 
     * @param block 帖子板块
     * @return 结果
     */
    @Override
    public int updateBlock(Block block)
    {
        return blockMapper.updateBlock(block);
    }

    /**
     * 批量删除帖子板块
     * 
     * @param ids 需要删除的帖子板块主键
     * @return 结果
     */
    @Override
    public int deleteBlockByIds(Long[] ids)
    {
        return blockMapper.deleteBlockByIds(ids);
    }

    /**
     * 删除帖子板块信息
     * 
     * @param id 帖子板块主键
     * @return 结果
     */
    @Override
    public int deleteBlockById(Long id)
    {
        return blockMapper.deleteBlockById(id);
    }
}
