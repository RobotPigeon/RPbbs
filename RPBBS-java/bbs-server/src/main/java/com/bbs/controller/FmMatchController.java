package com.bbs.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.bbs.domain.fm.FmMatch;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IFmMatchService;
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
@RequestMapping("/fm/match")
public class FmMatchController
{
    @Autowired
    private IFmMatchService fmMatchService;

    /**
     * 查询列表
     */
    @GetMapping("/list")
    public AjaxResult list(FmMatch fmMatch)
    {
        List<FmMatch> list = fmMatchService.selectFmMatchList(fmMatch);
        return AjaxResult.success(list);
    }

    /**
     * 获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(fmMatchService.selectFmMatchById(id));
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FmMatch fmMatch)
    {
        return AjaxResult.success(fmMatchService.insertFmMatch(fmMatch));
    }

    /**
     * 修改
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody FmMatch fmMatch)
    {
        return AjaxResult.success(fmMatchService.updateFmMatch(fmMatch));
    }

    /**
     * 删除
     */
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return AjaxResult.success(fmMatchService.deleteFmMatchByIds(ids));
    }
}
