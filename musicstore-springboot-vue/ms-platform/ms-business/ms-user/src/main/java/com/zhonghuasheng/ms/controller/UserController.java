package com.zhonghuasheng.ms.controller;

import com.zhonghuasheng.ms.model.User;
import com.zhonghuasheng.ms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getById(userId);
    }
}
