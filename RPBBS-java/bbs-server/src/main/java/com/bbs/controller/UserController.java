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

import com.bbs.domain.User;
import com.bbs.service.IUserService;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2023-02-27
 */
@RestController
@RequestMapping("/bbs/user")
public class UserController
{
    @Autowired
    private IUserService userService;

    /**
     * 查询用户列表
     */
    @GetMapping("/list")
    public List list(User user)
    {
        List<User> list = userService.selectUserList(user);
        return list;
    }

    /**
     * 获取用户详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return  AjaxResult.success(userService.selectUserById(id));
    }

    /**
     * 新增用户
     */
    @PostMapping
    public AjaxResult add(@RequestBody User user)
    {
        return userService.insertUser(user) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改用户
     */
    @PutMapping
    public AjaxResult edit(@RequestBody User user)
    {
        return userService.updateUser(user) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 删除用户
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return userService.deleteUserByIds(ids) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
