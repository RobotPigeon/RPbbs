package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bbs/register")
public class RegisterController {

    @Autowired
    private IRegisterService registerService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody User message) {
        switch (registerService.addUser(message)) {
            case 0: {
                return AjaxResult.success("注册成功");
            }
            case 1: {
                return AjaxResult.error("用户名重复");
            }
            default: {
                return AjaxResult.error("注册失败，未知原因");
            }
        }
    }

}
