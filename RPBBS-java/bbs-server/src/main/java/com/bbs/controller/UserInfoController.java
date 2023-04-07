package com.bbs.controller;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.msg.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List list(@RequestParam("id") Long id
                    ,@RequestParam("userId") String userId
                    ,@RequestParam("level") Long level
                    ,@RequestParam("message") String message)
    {
        UserInfo userInfo = new UserInfo(id, userId, level, message);
        return userInfoService.selectUserInfoList(userInfo);
    }

    /**
     * 获取用户信息详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(userInfoService.selectUserInfoById(id));
    }

    @GetMapping(value = "/userId/{userId}")
    public AjaxResult getInfoByUserId(@PathVariable("userId")String userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        return AjaxResult.success(userInfoService.selectUserInfoList(userInfo));
    }

    @GetMapping(value = "/page")
    public AjaxResult page(@RequestParam("current") Long current, @RequestParam("size") Long size) {
        Page page = new Page<>(current, size);
        IPage data = userInfoService.page(page);
        return AjaxResult.success(data);
    }

    /**
     * 新增用户信息
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody UserInfo userInfo)
    {
        return userInfoService.insertUserInfo(userInfo) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改用户信息
     */
    @PutMapping("/edit")
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
