package com.bbs.controller;

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
import com.bbs.domain.Card;
import com.bbs.service.ICardService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 帖子Controller
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/card")
public class CardController extends BaseController
{
    @Autowired
    private ICardService cardService;

    /**
     * 查询帖子列表
     */
    @PreAuthorize("@ss.hasPermi('bbs:card:list')")
    @GetMapping("/list")
    public TableDataInfo list(Card card)
    {
        startPage();
        List<Card> list = cardService.selectCardList(card);
        return getDataTable(list);
    }

    /**
     * 导出帖子列表
     */
    @PreAuthorize("@ss.hasPermi('bbs:card:export')")
    @Log(title = "帖子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Card card)
    {
        List<Card> list = cardService.selectCardList(card);
        ExcelUtil<Card> util = new ExcelUtil<Card>(Card.class);
        util.exportExcel(response, list, "帖子数据");
    }

    /**
     * 获取帖子详细信息
     */
    @PreAuthorize("@ss.hasPermi('bbs:card:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cardService.selectCardById(id));
    }

    /**
     * 新增帖子
     */
    @PreAuthorize("@ss.hasPermi('bbs:card:add')")
    @Log(title = "帖子", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Card card)
    {
        return toAjax(cardService.insertCard(card));
    }

    /**
     * 修改帖子
     */
    @PreAuthorize("@ss.hasPermi('bbs:card:edit')")
    @Log(title = "帖子", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Card card)
    {
        return toAjax(cardService.updateCard(card));
    }

    /**
     * 删除帖子
     */
    @PreAuthorize("@ss.hasPermi('bbs:card:remove')")
    @Log(title = "帖子", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cardService.deleteCardByIds(ids));
    }
}
