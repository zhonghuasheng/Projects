package com.zhonghuasheng.musicstore.service;

import java.util.List;

import com.zhonghuasheng.musicstore.model.Pagination;
import com.zhonghuasheng.musicstore.model.User;

public interface UserService {

    User login(String email, String password);
    User create(User user);
    User signUp(User user);
    boolean isEmailExisted(String email);
    List<User> users(Pagination pagination);
    boolean delete(String uuid);
    User get(String uuid);
    int count();
}
