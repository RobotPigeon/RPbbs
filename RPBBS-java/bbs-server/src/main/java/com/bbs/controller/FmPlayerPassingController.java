package com.bbs.controller;

import java.util.List;

import com.bbs.domain.fm.FmPlayerPassing;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IFmPlayerPassingService;
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
@RequestMapping("/fm/player_passing")
public class FmPlayerPassingController
{
    @Autowired
    private IFmPlayerPassingService fmPlayerPassingService;

    /**
     * 查询列表
     */
    @GetMapping("/list")
    public AjaxResult list(FmPlayerPassing fmPlayerPassing)
    {
        List<FmPlayerPassing> list = fmPlayerPassingService.selectFmPlayerPassingList(fmPlayerPassing);
        return AjaxResult.success(list);
    }

    /**
     * 获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fmPlayerPassingService.selectFmPlayerPassingById(id));
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FmPlayerPassing fmPlayerPassing)
    {
        return AjaxResult.success(fmPlayerPassingService.insertFmPlayerPassing(fmPlayerPassing));
    }

    /**
     * 修改
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody FmPlayerPassing fmPlayerPassing)
    {
        return AjaxResult.success(fmPlayerPassingService.updateFmPlayerPassing(fmPlayerPassing));
    }

    /**
     * 删除
     */
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return AjaxResult.success(fmPlayerPassingService.deleteFmPlayerPassingByIds(ids));
    }
}
