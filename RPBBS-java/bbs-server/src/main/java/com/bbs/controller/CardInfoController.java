package com.bbs.controller;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.Card;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.domain.vo.CardInfoVo;
import com.bbs.service.ICardInfoVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ICardInfoVoService cardInfoVoService;

    /**
     * 查询帖子信息列表
     */
    @GetMapping("/list")
    public List listOri(CardInfo cardInfo)
    {
        List<CardInfo> list = cardInfoService.selectCardInfoList(cardInfo);
        return  list;
    }

    /**
     * 获取帖子信息详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfoOri(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cardInfoService.selectCardInfoById(id));
    }

    @GetMapping(value = "/page")
    public AjaxResult pageOri(@RequestParam Long current, @RequestParam Long size) {
        Page page = new Page<>(current,size);
        IPage<CardInfo> data = cardInfoService.page(page);
        return AjaxResult.success(data);
    }

    @GetMapping("/vo/list")
    public AjaxResult list(CardInfo cardInfo) {
        List<CardInfoVo> list = cardInfoVoService.selectCardInfoVoList(cardInfo);
        return AjaxResult.success(list);
    }

    @GetMapping(value = "/vo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(cardInfoVoService.selectCardInfoVoById(id));
    }

    @GetMapping(value = "/vo/page")
    public AjaxResult page(@RequestParam Long current, @RequestParam Long size) {
        Page page = new Page<>(current,size);
        IPage<CardInfoVo> data = cardInfoVoService.page(page);
        return AjaxResult.success(data);
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
