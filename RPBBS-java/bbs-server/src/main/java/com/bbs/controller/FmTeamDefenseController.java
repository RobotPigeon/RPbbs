package com.bbs.controller;

import java.util.List;

import com.bbs.domain.fm.FmTeamDefense;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IFmTeamDefenseService;
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
@RequestMapping("/fm/team_defense")
public class FmTeamDefenseController
{
    @Autowired
    private IFmTeamDefenseService fmTeamDefenseService;

    /**
     * 查询【请填写功能名称】列表
     */
    @GetMapping("/list")
    public AjaxResult list(FmTeamDefense fmTeamDefense)
    {
        List<FmTeamDefense> list = fmTeamDefenseService.selectFmTeamDefenseList(fmTeamDefense);
        return AjaxResult.success(list);
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fmTeamDefenseService.selectFmTeamDefenseById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FmTeamDefense fmTeamDefense)
    {
        return AjaxResult.success(fmTeamDefenseService.insertFmTeamDefense(fmTeamDefense));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody FmTeamDefense fmTeamDefense)
    {
        return AjaxResult.success(fmTeamDefenseService.updateFmTeamDefense(fmTeamDefense));
    }

    /**
     * 删除【请填写功能名称】
     */
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return AjaxResult.success(fmTeamDefenseService.deleteFmTeamDefenseByIds(ids));
    }
}
