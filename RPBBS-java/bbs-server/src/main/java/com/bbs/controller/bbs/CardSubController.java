package com.bbs.controller.bbs;

import com.bbs.domain.dto.CardDto;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.ICardManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 帖子发布之类的功能接口
 */
@Slf4j
@RestController
@RequestMapping("/bbs/card_center")
public class CardSubController {

    @Autowired
    private ICardManageService cardManageService;

    /**
     * 帖子发布
     * @param cardDto
     * @return
     */
    @PostMapping("/submit")
    public AjaxResult submit(@RequestBody CardDto cardDto) {
        if (cardManageService.addTotalCard(cardDto)>0) {
            log.info("帖子发布: "+cardDto.getTitle());
            return AjaxResult.success("发布成功");
        }
        return AjaxResult.error();
    }

    /**
     * 详细帖子信息查询
     * @return
     */
    public AjaxResult cardList(int... cardIds) {

        return AjaxResult.success();
    }
}
