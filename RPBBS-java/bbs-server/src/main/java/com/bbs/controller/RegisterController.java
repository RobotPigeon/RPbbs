package com.bbs.controller;

import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bbs/register")
public class RegisterController {

    @Autowired
    private IRegisterService registerService;

    @PostMapping("/add_user")
    public AjaxResult register(@RequestParam String message) {
        return registerService.addUser(message) == true ? AjaxResult.success("注册成功！") : AjaxResult.error("register fail!");
    }
}
