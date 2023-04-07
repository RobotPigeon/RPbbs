package com.bbs.controller;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

import com.bbs.domain.Card;
import com.bbs.service.ICardService;


/**
 * 帖子Controller
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/card")
public class CardController
{
    @Autowired
    private ICardService cardService;

    /**
     * 查询帖子列表
     */
    @GetMapping("/list")
    public List list(Card card)
    {
        List<Card> list = cardService.selectCardList(card);
        return list;
    }

    /**
     * 获取帖子详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cardService.selectCardById(id));
    }

    @GetMapping(value = "/page")
    public AjaxResult page(@RequestBody Page<Card> page) {
        IPage<Card> data = cardService.page(page);
        return AjaxResult.success(data);
    }

    /**
     * 新增帖子
     */
    @PostMapping
    public AjaxResult add(@RequestBody Card card)
    {
        return cardService.insertCard(card)> 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改帖子
     */
    @PutMapping
    public AjaxResult edit(@RequestBody Card card)
    {
        return cardService.updateCard(card)> 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 删除帖子
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return cardService.deleteCardByIds(ids) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
