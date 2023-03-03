package com.bbs.controller;

import java.util.List;

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

import com.bbs.domain.CardReply;
import com.bbs.service.ICardReplyService;


/**
 * 回复帖子Controller
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/reply")
public class CardReplyController
{
    @Autowired
    private ICardReplyService cardReplyService;

    /**
     * 查询回复帖子列表
     */
    @GetMapping("/list")
    public List list(CardReply cardReply)
    {
        List<CardReply> list = cardReplyService.selectCardReplyList(cardReply);
        return list;
    }

    /**
     * 获取回复帖子详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cardReplyService.selectCardReplyById(id));
    }

    /**
     * 新增回复帖子
     */
    @PostMapping
    public AjaxResult add(@RequestBody CardReply cardReply)
    {
        return cardReplyService.insertCardReply(cardReply) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改回复帖子
     */
    @PutMapping
    public AjaxResult edit(@RequestBody CardReply cardReply)
    {
        return cardReplyService.updateCardReply(cardReply) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 删除回复帖子
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return cardReplyService.deleteCardReplyByIds(ids) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
