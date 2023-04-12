package com.bbs.controller;

import java.util.List;

import com.bbs.domain.fm.FmPlayerDefense;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IFmPlayerDefenseService;
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
@RequestMapping("/fm/player_defense")
public class FmPlayerDefenseController
{
    @Autowired
    private IFmPlayerDefenseService fmPlayerDefenseService;

    /**
     * 查询列表
     */
    @GetMapping("/list")
    public AjaxResult list(FmPlayerDefense fmPlayerDefense)
    {
        List<FmPlayerDefense> list = fmPlayerDefenseService.selectFmPlayerDefenseList(fmPlayerDefense);
        return AjaxResult.success(list);
    }

    /**
     * 获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fmPlayerDefenseService.selectFmPlayerDefenseById(id));
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FmPlayerDefense fmPlayerDefense)
    {
        return AjaxResult.success(fmPlayerDefenseService.insertFmPlayerDefense(fmPlayerDefense));
    }

    /**
     * 修改
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody FmPlayerDefense fmPlayerDefense)
    {
        return AjaxResult.success(fmPlayerDefenseService.updateFmPlayerDefense(fmPlayerDefense));
    }

    /**
     * 删除
     */
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return AjaxResult.success(fmPlayerDefenseService.deleteFmPlayerDefenseByIds(ids));
    }
}
