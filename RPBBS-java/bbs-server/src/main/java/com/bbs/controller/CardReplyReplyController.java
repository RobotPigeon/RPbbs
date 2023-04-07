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

import com.bbs.domain.CardReplyReply;
import com.bbs.service.ICardReplyReplyService;

/**
 * 二级回复帖子Controller
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/reply_reply")
public class CardReplyReplyController
{
    @Autowired
    private ICardReplyReplyService cardReplyReplyService;

    /**
     * 查询二级回复帖子列表
     */
    @GetMapping("/list")
    public List list(CardReplyReply cardReplyReply)
    {
        List<CardReplyReply> list = cardReplyReplyService.selectCardReplyReplyList(cardReplyReply);
        return list;
    }

    /**
     * 获取二级回复帖子详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cardReplyReplyService.selectCardReplyReplyById(id));
    }

    @GetMapping(value = "/page")
    public AjaxResult page(@RequestBody Page<CardReplyReply> page) {
        IPage data = cardReplyReplyService.page(page);
        return AjaxResult.success(data);
    }

    /**
     * 新增二级回复帖子
     */
    @PostMapping
    public AjaxResult add(@RequestBody CardReplyReply cardReplyReply)
    {
        return cardReplyReplyService.insertCardReplyReply(cardReplyReply) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改二级回复帖子
     */
    @PutMapping
    public AjaxResult edit(@RequestBody CardReplyReply cardReplyReply)
    {
        return  cardReplyReplyService.updateCardReplyReply(cardReplyReply) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 删除二级回复帖子
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return cardReplyReplyService.deleteCardReplyReplyByIds(ids) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
