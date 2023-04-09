package com.bbs.controller.bbs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.dto.CardDto;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.domain.vo.CardVo;
import com.bbs.service.ICardOperateService;
import com.bbs.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.UnknownHostException;

/**
 * 帖子发布之类的功能接口
 */
@Slf4j
@RestController
@RequestMapping("/bbs/card_center")
public class CardOperateController {

    @Autowired
    private ICardOperateService cardOperateService;

    /**
     * 帖子发布
     * @param cardDto
     * @return
     */
    @PostMapping("/submit")
    @ResponseBody
    public AjaxResult submit(CardDto cardDto, @RequestParam("sourceFile") MultipartFile file) {
        // save source
        String sourcePath = FileUtils.upload(file);
        if (sourcePath==null){
            return AjaxResult.error("资源文件上传失败");
        }

        cardDto.setSourcePath(sourcePath);

        if (cardOperateService.addTotalCard(cardDto)>=0) {
            log.info("帖子发布: "+cardDto.getTitle());
            return AjaxResult.success("发布成功");
        }
        return AjaxResult.error();
    }

    /**
     * 详细帖子信息查询
     * @return
     */
    @GetMapping("/page")
    public AjaxResult cardList(@RequestParam Long current, @RequestParam Long size) throws UnknownHostException {
        Page page = new Page<>(current, size);
        IPage<CardVo> cardVoPage = cardOperateService.cardTotalList(page);

        if (cardVoPage != null) {
            return AjaxResult.success(cardVoPage);
        }
        return AjaxResult.error();
    }
}
