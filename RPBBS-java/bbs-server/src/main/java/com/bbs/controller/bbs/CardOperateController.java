package com.bbs.controller.bbs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.CardReply;
import com.bbs.domain.CardReplyReply;
import com.bbs.domain.dto.CardDto;
import com.bbs.domain.dto.ReplyDto;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.domain.vo.CardReplyVo;
import com.bbs.domain.vo.CardVo;
import com.bbs.service.ICardOperateService;
import com.bbs.service.ICardReplyReplyService;
import com.bbs.service.ICardReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.Date;

/**
 * 帖子发布之类的功能接口
 */
@Slf4j
@RestController
@RequestMapping("/bbs/card_center")
public class CardOperateController {

    @Autowired
    private ICardOperateService cardOperateService;

    @Autowired
    private ICardReplyService cardReplyService;

    @Autowired
    private ICardReplyReplyService cardReplyReplyService;

    /**
     * 帖子发布
     * @param cardDto
     * @return
     */
    @PostMapping("/submit")
    public AjaxResult submit(@RequestBody CardDto cardDto
//                            , @RequestParam("sourceFile") MultipartFile file
    ) {
//        // save source
//        if (file != null && !file.equals("")) {
//            String sourcePath = FileUtils.upload(file);
//            if (sourcePath==null){
//                return AjaxResult.error("资源文件上传失败");
//            }
//            cardDto.setSourcePath(sourcePath);
//        }

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
    public AjaxResult cardList(@RequestParam Long current, @RequestParam Long size, @RequestParam String blockId) throws UnknownHostException {
        Page page = new Page<>(current, size);
        IPage<CardVo> cardVoPage = cardOperateService.cardTotalPage(page, blockId);

        if (cardVoPage != null) {
            return AjaxResult.success(cardVoPage);
        }
        return AjaxResult.error();
    }

    @GetMapping("/reply/page")
    public AjaxResult replyPage(@RequestParam Long current, @RequestParam Long size, @RequestParam String cardId) {
        if (cardId.equals("") || cardId == null) {
            return AjaxResult.error("没有帖子id(cardId)");
        }
        Page page = new Page(current,size);
        IPage<CardReplyVo> cardReplyVoPage = cardOperateService.cardReplyPage(page, cardId);
        if (cardReplyVoPage != null) {
            return AjaxResult.success(cardReplyVoPage);
        }
        return AjaxResult.error();
    }

    @PostMapping("/reply")
    @ResponseBody
    public AjaxResult cardReply(ReplyDto replyDto) {
        if (replyDto.getCardId().isEmpty()) {
            return AjaxResult.error("没有cardId");
        }
        CardReply cardReply = replyDto;
        Long current = System.currentTimeMillis();
        cardReply.setCreateTime(new Date(current));
        cardReply.setUpdateTime(new Date(current));
        if (cardReplyService.insertCardReply(cardReply)>0) {
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    @PostMapping("/reply/reply")
    @ResponseBody
    public AjaxResult cardReplyReply(CardReplyReply cardReplyReply) {
        if (cardReplyReply.getCardId().isEmpty()) {
            return AjaxResult.error("没有cardId");
        }

        Long current = System.currentTimeMillis();
        cardReplyReply.setCreateTime(new Date(current));
        cardReplyReply.setUpdateTime(new Date(current));
        if (cardReplyReplyService.insertCardReplyReply(cardReplyReply)>0) {
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }
}
