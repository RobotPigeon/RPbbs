package com.bbs.controller;

import java.util.List;

import com.bbs.domain.fm.FmPlayerOthers;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IFmPlayerOthersService;
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
@RequestMapping("/fm/player_others")
public class FmPlayerOthersController
{
    @Autowired
    private IFmPlayerOthersService fmPlayerOthersService;

    /**
     * 查询列表
     */
    @GetMapping("/list")
    public AjaxResult list(FmPlayerOthers fmPlayerOthers)
    {
        List<FmPlayerOthers> list = fmPlayerOthersService.selectFmPlayerOthersList(fmPlayerOthers);
        return AjaxResult.success(list);
    }

    /**
     * 获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fmPlayerOthersService.selectFmPlayerOthersById(id));
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FmPlayerOthers fmPlayerOthers)
    {
        return AjaxResult.success(fmPlayerOthersService.insertFmPlayerOthers(fmPlayerOthers));
    }

    /**
     * 修改
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody FmPlayerOthers fmPlayerOthers)
    {
        return AjaxResult.success(fmPlayerOthersService.updateFmPlayerOthers(fmPlayerOthers));
    }

    /**
     * 删除
     */
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return AjaxResult.success(fmPlayerOthersService.deleteFmPlayerOthersByIds(ids));
    }
}
