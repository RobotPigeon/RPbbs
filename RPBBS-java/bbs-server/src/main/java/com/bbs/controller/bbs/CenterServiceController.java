package com.bbs.controller.bbs;

import com.bbs.domain.msg.AjaxResult;
import com.bbs.domain.req.CaptchaReq;
import com.bbs.service.ICaptchaService;
import com.bbs.service.IMailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bbs/centerService")
public class CenterServiceController {

    @Autowired
    private IMailService mailService;

    /**
     * 发送验证邮箱
     * @param mailTo
     */
    @ApiOperation(value = "发送验证码至邮箱")
    @GetMapping("/userSetting/sendMail")
    public AjaxResult sendMail(@RequestParam String mailTo) {
        return AjaxResult.success().put("uuid", mailService.sendCheckMail(mailTo));
    }

    @PostMapping("/userSetting/verify")
    public AjaxResult verify(@RequestBody CaptchaReq captchaReq, @RequestParam("userId") String userId) {
        switch (mailService.verifyAndUpdate(captchaReq.getUuid(), captchaReq.getText(), userId)) {
            case 0: {
                return AjaxResult.success("绑定成功");
            } default:{}
        }
        return AjaxResult.error();
    }
}
