package com.bbs.controller;

import java.util.List;

import com.bbs.domain.fm.FmTeamPassing;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IFmTeamPassingService;
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
 * 足球传球数据Controller
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@RestController
@RequestMapping("/fm/team_passing")
public class FmTeamPassingController
{
    @Autowired
    private IFmTeamPassingService fmTeamPassingService;

    /**
     * 查询足球传球数据列表
     */
    @GetMapping("/list")
    public AjaxResult list(FmTeamPassing fmTeamPassing)
    {
        List<FmTeamPassing> list = fmTeamPassingService.selectFmTeamPassingList(fmTeamPassing);
        return AjaxResult.success(list);
    }

    /**
     * 获取足球传球数据详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fmTeamPassingService.selectFmTeamPassingById(id));
    }

    /**
     * 新增足球传球数据
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FmTeamPassing fmTeamPassing)
    {
        return AjaxResult.success(fmTeamPassingService.insertFmTeamPassing(fmTeamPassing));
    }

    /**
     * 修改足球传球数据
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody FmTeamPassing fmTeamPassing)
    {
        return AjaxResult.success(fmTeamPassingService.updateFmTeamPassing(fmTeamPassing));
    }

    /**
     * 删除足球传球数据
     */
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return AjaxResult.success(fmTeamPassingService.deleteFmTeamPassingByIds(ids));
    }
}
