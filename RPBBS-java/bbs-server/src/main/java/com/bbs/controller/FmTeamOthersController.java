package com.bbs.controller;

import java.util.List;

import com.bbs.domain.fm.FmTeamOthers;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IFmTeamOthersService;
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
 * 存储球队其他现Controller
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@RestController
@RequestMapping("/fm/team_others")
public class FmTeamOthersController
{
    @Autowired
    private IFmTeamOthersService fmTeamOthersService;

    /**
     * 查询存储球队其他现列表
     */
    @GetMapping("/list")
    public AjaxResult list(FmTeamOthers fmTeamOthers)
    {
        List<FmTeamOthers> list = fmTeamOthersService.selectFmTeamOthersList(fmTeamOthers);
        return AjaxResult.success(list);
    }


    /**
     * 获取存储球队其他现详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fmTeamOthersService.selectFmTeamOthersById(id));
    }

    /**
     * 新增存储球队其他现
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FmTeamOthers fmTeamOthers)
    {
        return AjaxResult.success(fmTeamOthersService.insertFmTeamOthers(fmTeamOthers));
    }

    /**
     * 修改存储球队其他现
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody FmTeamOthers fmTeamOthers)
    {
        return AjaxResult.success(fmTeamOthersService.updateFmTeamOthers(fmTeamOthers));
    }

    /**
     * 删除存储球队其他现
     */
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return AjaxResult.success(fmTeamOthersService.deleteFmTeamOthersByIds(ids));
    }
}
