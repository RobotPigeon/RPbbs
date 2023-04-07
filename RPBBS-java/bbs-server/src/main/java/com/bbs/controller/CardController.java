package com.bbs.controller;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.msg.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List list(@RequestParam Long id,
                     @RequestParam String title,
                     @RequestParam String createById,
                     @RequestParam String blockId,
                     @RequestParam Long status,
                     @RequestParam Date createTime,
                     @RequestParam Date updateTime)
    {
        Card card = new Card(id,title,createById,blockId,status,createTime,updateTime);
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
    public AjaxResult page(@RequestParam Long size, @RequestParam Long current) {
        Page page = new Page<>(current, size);
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
