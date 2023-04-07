package com.bbs.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.CardReply;
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

import com.bbs.domain.CardType;
import com.bbs.service.ICardTypeService;

/**
 * 帖子类型Controller
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/c_type")
public class CardTypeController
{
    @Autowired
    private ICardTypeService cardTypeService;

    /**
     * 查询帖子类型列表
     */
    @GetMapping("/list")
    public List list(CardType cardType)
    {
        List<CardType> list = cardTypeService.selectCardTypeList(cardType);
        return list;
    }

    /**
     * 获取帖子类型详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cardTypeService.selectCardTypeById(id));
    }

    @GetMapping(value = "/page")
    public AjaxResult page(@RequestBody Page<CardType> page) {
        IPage data = cardTypeService.page(page);
        return AjaxResult.success(data);
    }

    /**
     * 新增帖子类型
     */
    @PostMapping
    public AjaxResult add(@RequestBody CardType cardType)
    {
        return cardTypeService.insertCardType(cardType) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改帖子类型
     */
    @PutMapping
    public AjaxResult edit(@RequestBody CardType cardType)
    {
        return cardTypeService.updateCardType(cardType) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 删除帖子类型
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return cardTypeService.deleteCardTypeByIds(ids) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
