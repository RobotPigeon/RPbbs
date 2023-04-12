package com.bbs.controller.fm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IFmTeamExtensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fm/team")
public class FmTeamExtensionController {

    @Autowired
    private IFmTeamExtensionService fmTeamExtensionService;

    @GetMapping("/get_players")
    public AjaxResult getPlayerBasicByTeamBasicSquad(@RequestParam("Squad") String Squad) {
        List list = fmTeamExtensionService.selectFmPlayerBasicByFmTeamBasicSquad(Squad);
        if (list.isEmpty()){
            return AjaxResult.error("未获得数据");
        }
        return AjaxResult.success(list);
    }

    @GetMapping("/list")
    public AjaxResult getTeamTotalList() {
        List list = fmTeamExtensionService.selectFmTeamVoListWithFmplayerBasic();
        return AjaxResult.success(list);
    }

    @GetMapping("/page")
    public AjaxResult getTeamTotalPage(@RequestParam Long current, @RequestParam Long size) {
        Page page = new Page(current,size);
        IPage datas = fmTeamExtensionService.selectFmTeamVoPageWithFmplayerBasic(page);
        return AjaxResult.success(datas);
    }
}
