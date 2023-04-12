package com.bbs.controller.fm;

import com.bbs.domain.msg.AjaxResult;
import com.bbs.domain.vo.FmPlayerVo;
import com.bbs.service.IFmPlayerExtensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fm/player")
public class FmPlayerExtensionController {

    @Autowired
    private IFmPlayerExtensionService fmPlayerExtensionService;

    @GetMapping("/{id}")
    public AjaxResult get(@PathVariable("id") Long id) {
        FmPlayerVo data = fmPlayerExtensionService.selectFmPlayerVoById(id);
        if (data == null) {
            return AjaxResult.error("没有获取到数据");
        }
        return AjaxResult.success(data);
    }
}
