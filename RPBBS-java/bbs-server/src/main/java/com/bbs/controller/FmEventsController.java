package com.bbs.controller;

import com.bbs.domain.fm.FmEvents;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IFmEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fm/events")
public class FmEventsController
{
    @Autowired
    private IFmEventsService fmEventsService;

    /**
     * 查询列表
     */
    @GetMapping("/list")
    public AjaxResult list(FmEvents fmEvents)
    {
        List<FmEvents> list = fmEventsService.selectFmEventsList(fmEvents);
        return AjaxResult.success(list);
    }


    /**
     * 获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fmEventsService.selectFmEventsById(id));
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FmEvents fmEvents)
    {
        return AjaxResult.success(fmEventsService.insertFmEvents(fmEvents));
    }

    /**
     * 修改
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody FmEvents fmEvents)
    {
        return AjaxResult.success(fmEventsService.updateFmEvents(fmEvents));
    }

    /**
     * 删除
     */
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return AjaxResult.success(fmEventsService.deleteFmEventsByIds(ids));
    }
}
