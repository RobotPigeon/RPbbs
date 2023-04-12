package com.bbs.controller;

import java.util.List;

import com.bbs.domain.fm.FmTeamGoalkeeping;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IFmTeamGoalkeepingService;
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
 * 球队守门员现Controller
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@RestController
@RequestMapping("/fm/team_goalkeeping")
public class FmTeamGoalkeepingController
{
    @Autowired
    private IFmTeamGoalkeepingService fmTeamGoalkeepingService;

    /**
     * 查询球队守门员现列表
     */
    @GetMapping("/list")
    public AjaxResult list(FmTeamGoalkeeping fmTeamGoalkeeping)
    {
        List<FmTeamGoalkeeping> list = fmTeamGoalkeepingService.selectFmTeamGoalkeepingList(fmTeamGoalkeeping);
        return AjaxResult.success(list);
    }

    /**
     * 获取球队守门员现详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fmTeamGoalkeepingService.selectFmTeamGoalkeepingById(id));
    }

    /**
     * 新增球队守门员现
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FmTeamGoalkeeping fmTeamGoalkeeping)
    {
        return AjaxResult.success(fmTeamGoalkeepingService.insertFmTeamGoalkeeping(fmTeamGoalkeeping));
    }

    /**
     * 修改球队守门员现
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody FmTeamGoalkeeping fmTeamGoalkeeping)
    {
        return AjaxResult.success(fmTeamGoalkeepingService.updateFmTeamGoalkeeping(fmTeamGoalkeeping));
    }

    /**
     * 删除球队守门员现
     */
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return AjaxResult.success(fmTeamGoalkeepingService.deleteFmTeamGoalkeepingByIds(ids));
    }
}
