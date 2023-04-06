package com.bbs.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bbs.domain.Block;
import org.apache.ibatis.annotations.Mapper;

/**
 * 帖子板块Mapper接口
 * 
 * @author wws
 * @date 2023-02-27
 */
@Mapper
public interface BlockMapper extends BaseMapper<Block>
{
    /**
     * 查询帖子板块
     * 
     * @param id 帖子板块主键
     * @return 帖子板块
     */
    public Block selectBlockById(Long id);

    /**
     * 查询帖子板块列表
     * 
     * @param block 帖子板块
     * @return 帖子板块集合
     */
    public List<Block> selectBlockList(Block block);

    /**
     * 新增帖子板块
     * 
     * @param block 帖子板块
     * @return 结果
     */
    public int insertBlock(Block block);

    /**
     * 修改帖子板块
     * 
     * @param block 帖子板块
     * @return 结果
     */
    public int updateBlock(Block block);

    /**
     * 删除帖子板块
     * 
     * @param id 帖子板块主键
     * @return 结果
     */
    public int deleteBlockById(Long id);

    /**
     * 批量删除帖子板块
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBlockByIds(Long[] ids);
}
