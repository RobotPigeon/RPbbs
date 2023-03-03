package com.bbs.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.bbs.domain.msg.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbs.domain.UserInfo;
import com.bbs.service.IUserInfoService;

/**
 * 用户信息Controller
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/user_info")
public class UserInfoController
{
    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 查询用户信息列表
     */
    @GetMapping("/list")
    public List list(UserInfo userInfo)
    {
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        return list;
    }

    /**
     * 获取用户信息详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(userInfoService.selectUserInfoById(id));
    }

    /**
     * 新增用户信息
     */
    @PostMapping
    public AjaxResult add(@RequestBody UserInfo userInfo)
    {
        return userInfoService.insertUserInfo(userInfo) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改用户信息
     */
    @PutMapping
    public AjaxResult edit(@RequestBody UserInfo userInfo)
    {
        return userInfoService.updateUserInfo(userInfo) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 删除用户信息
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return userInfoService.deleteUserInfoByIds(ids) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
