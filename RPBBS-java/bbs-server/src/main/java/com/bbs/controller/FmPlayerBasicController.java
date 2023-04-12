package com.bbs.controller;

import java.util.List;

import com.bbs.domain.fm.FmPlayerBasic;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IFmPlayerBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fm/player_basic")
public class FmPlayerBasicController
{
    @Autowired
    private IFmPlayerBasicService fmPlayerBasicService;

    /**
     * 查询列表
     */
    @GetMapping("/list")
    public AjaxResult list(FmPlayerBasic fmPlayerBasic)
    {
        List<FmPlayerBasic> list = fmPlayerBasicService.selectFmPlayerBasicList(fmPlayerBasic);
        return AjaxResult.success(list);
    }

    /**
     * 获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fmPlayerBasicService.selectFmPlayerBasicById(id));
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FmPlayerBasic fmPlayerBasic)
    {
        return AjaxResult.success(fmPlayerBasicService.insertFmPlayerBasic(fmPlayerBasic));
    }

    /**
     * 修改
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody FmPlayerBasic fmPlayerBasic)
    {
        return AjaxResult.success(fmPlayerBasicService.updateFmPlayerBasic(fmPlayerBasic));
    }

    /**
     * 删除
     */
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return AjaxResult.success(fmPlayerBasicService.deleteFmPlayerBasicByIds(ids));
    }
}
