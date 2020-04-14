package com.zhonghuasheng.musicstore.dao;

import com.zhonghuasheng.musicstore.model.User;

import java.util.List;

public interface UserDao {
    User getUserByEmailAndPassword(String email, String password);
    List<User> getActiveUsers();
}
