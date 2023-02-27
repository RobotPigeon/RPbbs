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
import com.bbs.domain.CardInfo;
import com.bbs.service.ICardInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 帖子信息Controller
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/card_info")
public class CardInfoController extends BaseController
{
    @Autowired
    private ICardInfoService cardInfoService;

    /**
     * 查询帖子信息列表
     */
    @PreAuthorize("@ss.hasPermi('bbs:card_info:list')")
    @GetMapping("/list")
    public TableDataInfo list(CardInfo cardInfo)
    {
        startPage();
        List<CardInfo> list = cardInfoService.selectCardInfoList(cardInfo);
        return getDataTable(list);
    }

    /**
     * 导出帖子信息列表
     */
    @PreAuthorize("@ss.hasPermi('bbs:card_info:export')")
    @Log(title = "帖子信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CardInfo cardInfo)
    {
        List<CardInfo> list = cardInfoService.selectCardInfoList(cardInfo);
        ExcelUtil<CardInfo> util = new ExcelUtil<CardInfo>(CardInfo.class);
        util.exportExcel(response, list, "帖子信息数据");
    }

    /**
     * 获取帖子信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('bbs:card_info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cardInfoService.selectCardInfoById(id));
    }

    /**
     * 新增帖子信息
     */
    @PreAuthorize("@ss.hasPermi('bbs:card_info:add')")
    @Log(title = "帖子信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CardInfo cardInfo)
    {
        return toAjax(cardInfoService.insertCardInfo(cardInfo));
    }

    /**
     * 修改帖子信息
     */
    @PreAuthorize("@ss.hasPermi('bbs:card_info:edit')")
    @Log(title = "帖子信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CardInfo cardInfo)
    {
        return toAjax(cardInfoService.updateCardInfo(cardInfo));
    }

    /**
     * 删除帖子信息
     */
    @PreAuthorize("@ss.hasPermi('bbs:card_info:remove')")
    @Log(title = "帖子信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cardInfoService.deleteCardInfoByIds(ids));
    }
}
