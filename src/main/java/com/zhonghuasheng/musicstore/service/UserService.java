package com.zhonghuasheng.musicstore.service;

import com.zhonghuasheng.musicstore.model.User;

import java.util.List;

public interface UserService {

    User getUserByEmailAndPassword(String email, String password);
    User create(User user);
    User signUp(User user);
    boolean isEmailExisted(String email);
    List<User> users();
}
