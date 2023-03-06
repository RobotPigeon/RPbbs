package com.ruoyi.bbs.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.bbs.domain.CardReply;
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
import com.ruoyi.bbs.service.ICardReplyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 回复帖子Controller
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/reply")
public class CardReplyController extends BaseController
{
    @Autowired
    private ICardReplyService cardReplyService;

    /**
     * 查询回复帖子列表
     */
    @PreAuthorize("@ss.hasPermi('bbs:reply:list')")
    @GetMapping("/list")
    public TableDataInfo list(CardReply cardReply)
    {
        startPage();
        List<CardReply> list = cardReplyService.selectCardReplyList(cardReply);
        return getDataTable(list);
    }

    /**
     * 导出回复帖子列表
     */
    @PreAuthorize("@ss.hasPermi('bbs:reply:export')")
    @Log(title = "回复帖子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CardReply cardReply)
    {
        List<CardReply> list = cardReplyService.selectCardReplyList(cardReply);
        ExcelUtil<CardReply> util = new ExcelUtil<CardReply>(CardReply.class);
        util.exportExcel(response, list, "回复帖子数据");
    }

    /**
     * 获取回复帖子详细信息
     */
    @PreAuthorize("@ss.hasPermi('bbs:reply:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cardReplyService.selectCardReplyById(id));
    }

    /**
     * 新增回复帖子
     */
    @PreAuthorize("@ss.hasPermi('bbs:reply:add')")
    @Log(title = "回复帖子", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CardReply cardReply)
    {
        return toAjax(cardReplyService.insertCardReply(cardReply));
    }

    /**
     * 修改回复帖子
     */
    @PreAuthorize("@ss.hasPermi('bbs:reply:edit')")
    @Log(title = "回复帖子", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CardReply cardReply)
    {
        return toAjax(cardReplyService.updateCardReply(cardReply));
    }

    /**
     * 删除回复帖子
     */
    @PreAuthorize("@ss.hasPermi('bbs:reply:remove')")
    @Log(title = "回复帖子", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cardReplyService.deleteCardReplyByIds(ids));
    }
}
