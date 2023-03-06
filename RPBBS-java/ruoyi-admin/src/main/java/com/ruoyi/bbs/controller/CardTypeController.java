package com.ruoyi.bbs.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.bbs.domain.CardType;
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
import com.ruoyi.bbs.service.ICardTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 帖子类型Controller
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/c_type")
public class CardTypeController extends BaseController
{
    @Autowired
    private ICardTypeService cardTypeService;

    /**
     * 查询帖子类型列表
     */
    @PreAuthorize("@ss.hasPermi('bbs:c_type:list')")
    @GetMapping("/list")
    public TableDataInfo list(CardType cardType)
    {
        startPage();
        List<CardType> list = cardTypeService.selectCardTypeList(cardType);
        return getDataTable(list);
    }

    /**
     * 导出帖子类型列表
     */
    @PreAuthorize("@ss.hasPermi('bbs:c_type:export')")
    @Log(title = "帖子类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CardType cardType)
    {
        List<CardType> list = cardTypeService.selectCardTypeList(cardType);
        ExcelUtil<CardType> util = new ExcelUtil<CardType>(CardType.class);
        util.exportExcel(response, list, "帖子类型数据");
    }

    /**
     * 获取帖子类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('bbs:c_type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cardTypeService.selectCardTypeById(id));
    }

    /**
     * 新增帖子类型
     */
    @PreAuthorize("@ss.hasPermi('bbs:c_type:add')")
    @Log(title = "帖子类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CardType cardType)
    {
        return toAjax(cardTypeService.insertCardType(cardType));
    }

    /**
     * 修改帖子类型
     */
    @PreAuthorize("@ss.hasPermi('bbs:c_type:edit')")
    @Log(title = "帖子类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CardType cardType)
    {
        return toAjax(cardTypeService.updateCardType(cardType));
    }

    /**
     * 删除帖子类型
     */
    @PreAuthorize("@ss.hasPermi('bbs:c_type:remove')")
    @Log(title = "帖子类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cardTypeService.deleteCardTypeByIds(ids));
    }
}
