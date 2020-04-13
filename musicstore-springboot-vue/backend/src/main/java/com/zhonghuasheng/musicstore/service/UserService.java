package com.zhonghuasheng.musicstore.service;

import com.zhonghuasheng.musicstore.model.User;

import java.util.List;

public interface UserService {
    User getUserByEmailAndPassword(String email, String password);
    List<User> getActiveUsers();
    boolean update(User user);
    boolean create(User user);
    User getUserById(String uuid);
}
