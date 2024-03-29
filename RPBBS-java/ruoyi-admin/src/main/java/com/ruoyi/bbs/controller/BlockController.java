package com.ruoyi.bbs.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.bbs.domain.Block;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.bbs.service.IBlockService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 帖子板块Controller
 * 
 * @author wws
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/block")
public class BlockController extends BaseController
{
    @Autowired
    private IBlockService blockService;

    /**
     * 查询帖子板块列表
     */
    @PreAuthorize("@ss.hasPermi('bbs:block:list')")
    @GetMapping("/list")
    public TableDataInfo list(Block block)
    {
        startPage();
        List<Block> list = blockService.selectBlockList(block);
        return getDataTable(list);
    }

    /**
     * 导出帖子板块列表
     */
    @PreAuthorize("@ss.hasPermi('bbs:block:export')")
    @Log(title = "帖子板块", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Block block)
    {
        List<Block> list = blockService.selectBlockList(block);
        ExcelUtil<Block> util = new ExcelUtil<Block>(Block.class);
        util.exportExcel(response, list, "帖子板块数据");
    }

    /**
     * 获取帖子板块详细信息
     */
    @PreAuthorize("@ss.hasPermi('bbs:block:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(blockService.selectBlockById(id));
    }

    /**
     * 新增帖子板块
     */
    @PreAuthorize("@ss.hasPermi('bbs:block:add')")
    @Log(title = "帖子板块", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Block block)
    {
        return toAjax(blockService.insertBlock(block));
    }

    /**
     * 修改帖子板块
     */
    @PreAuthorize("@ss.hasPermi('bbs:block:edit')")
    @Log(title = "帖子板块", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Block block)
    {
        return toAjax(blockService.updateBlock(block));
    }

    /**
     * 删除帖子板块
     */
    @PreAuthorize("@ss.hasPermi('bbs:block:remove')")
    @Log(title = "帖子板块", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(blockService.deleteBlockByIds(ids));
    }
}
