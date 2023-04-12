package com.bbs.controller;

import java.util.List;

import com.bbs.domain.fm.FmTeamBasic;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IFmTeamBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@RestController
@RequestMapping("/fm/team_basic")
public class FmTeamBasicController
{
    @Autowired
    private IFmTeamBasicService fmTeamBasicService;

    /**
     * 查询【请填写功能名称】列表
     */
    @GetMapping("/list")
    public AjaxResult list(FmTeamBasic fmTeamBasic)
    {
        List<FmTeamBasic> list = fmTeamBasicService.selectFmTeamBasicList(fmTeamBasic);
        return AjaxResult.success(list);
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fmTeamBasicService.selectFmTeamBasicById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FmTeamBasic fmTeamBasic)
    {
        return AjaxResult.success(fmTeamBasicService.insertFmTeamBasic(fmTeamBasic));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody FmTeamBasic fmTeamBasic)
    {
        return AjaxResult.success(fmTeamBasicService.updateFmTeamBasic(fmTeamBasic));
    }

    /**
     * 删除【请填写功能名称】
     */
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return AjaxResult.success(fmTeamBasicService.deleteFmTeamBasicByIds(ids));
    }
}
