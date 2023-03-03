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

import com.bbs.domain.CardInfo;
import com.bbs.service.ICardInfoService;


/**
 * 帖子信息Controller
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/card_info")
public class CardInfoController
{
    @Autowired
    private ICardInfoService cardInfoService;

    /**
     * 查询帖子信息列表
     */
    @GetMapping("/list")
    public List list(CardInfo cardInfo)
    {
        List<CardInfo> list = cardInfoService.selectCardInfoList(cardInfo);
        return  list;
    }

    /**
     * 获取帖子信息详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cardInfoService.selectCardInfoById(id));
    }

    /**
     * 新增帖子信息
     */
    @PostMapping
    public AjaxResult add(@RequestBody CardInfo cardInfo)
    {
        return cardInfoService.insertCardInfo(cardInfo) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改帖子信息
     */
    @PutMapping
    public AjaxResult edit(@RequestBody CardInfo cardInfo)
    {
        return cardInfoService.updateCardInfo(cardInfo) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 删除帖子信息
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return cardInfoService.deleteCardInfoByIds(ids) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
