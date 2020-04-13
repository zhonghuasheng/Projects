package com.zhonghuasheng.musicstore.controller;

import com.zhonghuasheng.musicstore.model.User;
import com.zhonghuasheng.musicstore.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController(value = "User Component RESTFUL API")
@RequestMapping(value = "/user")
@Api(value = "User API List")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public User login(String email, String password) {
        User user = userService.getUserByEmailAndPassword(email, password);

        return user;
    }

    @GetMapping()
    public List<User> getActiveUsers() {
        List<User> users = userService.getActiveUsers();

        return users;
    }

    @GetMapping(value = "/{uuid}")
    public User getUserProfile(@PathVariable(value = "uuid") String uuid) {
        User user = userService.getUserById(uuid);

        return user;
    }

    @PostMapping(value = "/{uuid}")
    public String updateProfile(@PathVariable(value = "uuid") String uuid, @RequestBody User user) {
        boolean result = userService.update(user);

        return null;
    }

    @PostMapping(value = "/signup")
    public String signup(@RequestBody Map<String, Object> params) {
        User user = new User();
        boolean result = userService.create(user);

        return null;
    }
}
