package com.ruoyi.bbs.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.bbs.domain.CardReplyReply;
import com.ruoyi.bbs.service.ICardReplyReplyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 二级回复帖子Controller
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/reply_reply")
public class CardReplyReplyController extends BaseController
{
    @Autowired
    private ICardReplyReplyService cardReplyReplyService;

    /**
     * 查询二级回复帖子列表
     */
    @PreAuthorize("@ss.hasPermi('system:reply_reply:list')")
    @GetMapping("/list")
    public TableDataInfo list(CardReplyReply cardReplyReply)
    {
        startPage();
        List<CardReplyReply> list = cardReplyReplyService.selectCardReplyReplyList(cardReplyReply);
        return getDataTable(list);
    }

    /**
     * 导出二级回复帖子列表
     */
    @PreAuthorize("@ss.hasPermi('system:reply_reply:export')")
    @Log(title = "二级回复帖子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CardReplyReply cardReplyReply)
    {
        List<CardReplyReply> list = cardReplyReplyService.selectCardReplyReplyList(cardReplyReply);
        ExcelUtil<CardReplyReply> util = new ExcelUtil<CardReplyReply>(CardReplyReply.class);
        util.exportExcel(response, list, "二级回复帖子数据");
    }

    /**
     * 获取二级回复帖子详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:reply_reply:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cardReplyReplyService.selectCardReplyReplyById(id));
    }

    /**
     * 新增二级回复帖子
     */
    @PreAuthorize("@ss.hasPermi('system:reply_reply:add')")
    @Log(title = "二级回复帖子", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CardReplyReply cardReplyReply)
    {
        return toAjax(cardReplyReplyService.insertCardReplyReply(cardReplyReply));
    }

    /**
     * 修改二级回复帖子
     */
    @PreAuthorize("@ss.hasPermi('system:reply_reply:edit')")
    @Log(title = "二级回复帖子", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CardReplyReply cardReplyReply)
    {
        return toAjax(cardReplyReplyService.updateCardReplyReply(cardReplyReply));
    }

    /**
     * 删除二级回复帖子
     */
    @PreAuthorize("@ss.hasPermi('system:reply_reply:remove')")
    @Log(title = "二级回复帖子", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cardReplyReplyService.deleteCardReplyReplyByIds(ids));
    }
}
