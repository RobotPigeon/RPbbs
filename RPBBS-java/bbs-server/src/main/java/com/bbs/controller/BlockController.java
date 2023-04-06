package com.bbs.controller;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bbs.domain.msg.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public List list(Block block)
    {
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

    // page方法记得补全
//    public AjaxResult page() {
//        blockService.page();
//    }

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
