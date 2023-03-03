package com.bbs.controller;

import com.bbs.domain.msg.AjaxResult;
import com.bbs.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录验证
 */

@RestController
@RequestMapping("/bbs")
public class LoginController {
    @Autowired
    ILoginService loginService;


    @GetMapping("/login")
    public AjaxResult Login(@RequestParam("username") String username, @RequestParam("password") String password) {
        String token = loginService.login(username, password);
        return token != null ? AjaxResult.success("登录成功", new HashMap<String, String>(){{put("token", token);}}) : AjaxResult.error();
    }
}
