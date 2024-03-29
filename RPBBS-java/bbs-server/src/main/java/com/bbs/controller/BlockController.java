package com.bbs.controller;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.CardReply;
import com.bbs.domain.msg.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bbs.domain.Block;
import com.bbs.service.IBlockService;


/**
 * 帖子板块Controller
 * 
 * @author wws
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/block")
public class  BlockController
{
    @Autowired
    private IBlockService blockService;

    /**
     * 查询帖子板块列表
     */
    @GetMapping("/list")
    public List list(@RequestParam Long id,
                     @RequestParam String blockName,
                     @RequestParam Long status,
                     @RequestParam Date createTime,
                     @RequestParam Date updateTime)
    {
        Block block = new Block(id,blockName,status,createTime,updateTime);
        List<Block> list = blockService.selectBlockList(block);
        return list;
    }

    /**
     * 获取帖子板块详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(blockService.selectBlockById(id));
    }

    @GetMapping(value = "/page")
    public AjaxResult page(@RequestParam("current") Long current,
                           @RequestParam("size") Long size) {
        Page page = new Page<>(current, size);
        IPage data = blockService.page(page);
        return AjaxResult.success(data);
    }

    /**
     * 新增帖子板块
     */
    @PostMapping
    public AjaxResult add(@RequestBody Block block)
    {
        return blockService.insertBlock(block) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改帖子板块
     */
    @PutMapping
    public AjaxResult edit(@RequestBody Block block)
    {
        return blockService.updateBlock(block) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 删除帖子板块
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return blockService.deleteBlockByIds(ids) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
