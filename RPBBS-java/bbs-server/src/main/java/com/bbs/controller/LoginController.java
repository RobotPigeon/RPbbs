package com.bbs.controller;

import com.bbs.service.ILoginService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录验证
 */

@RestController
@RequestMapping("/bbs")
public class LoginController {
    @Autowired
    ILoginService loginService;


    @GetMapping("/login")
    public AjaxResult Login(@RequestParam String username,@RequestParam String password) {
        String token = loginService.login(username, password);
        return token != null ? AjaxResult.success(token) : AjaxResult.error();
    }
}
