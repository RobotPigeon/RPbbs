package com.bbs.controller;

import java.util.List;

import com.bbs.domain.fm.FmPlayerGoalkeeping;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IFmPlayerGoalkeepingService;
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
@RequestMapping("/fm/player_goalkeeping")
public class FmPlayerGoalkeepingController
{
    @Autowired
    private IFmPlayerGoalkeepingService fmPlayerGoalkeepingService;

    /**
     * 查询列表
     */
    @GetMapping("/list")
    public AjaxResult list(FmPlayerGoalkeeping fmPlayerGoalkeeping)
    {
        List<FmPlayerGoalkeeping> list = fmPlayerGoalkeepingService.selectFmPlayerGoalkeepingList(fmPlayerGoalkeeping);
        return AjaxResult.success(list);
    }

    /**
     * 获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fmPlayerGoalkeepingService.selectFmPlayerGoalkeepingById(id));
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FmPlayerGoalkeeping fmPlayerGoalkeeping)
    {
        return AjaxResult.success(fmPlayerGoalkeepingService.insertFmPlayerGoalkeeping(fmPlayerGoalkeeping));
    }

    /**
     * 修改
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody FmPlayerGoalkeeping fmPlayerGoalkeeping)
    {
        return AjaxResult.success(fmPlayerGoalkeepingService.updateFmPlayerGoalkeeping(fmPlayerGoalkeeping));
    }

    /**
     * 删除
     */
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return AjaxResult.success(fmPlayerGoalkeepingService.deleteFmPlayerGoalkeepingByIds(ids));
    }
}
