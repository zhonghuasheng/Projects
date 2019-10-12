package com.zhonghuasheng.musicstore.dao;

import com.zhonghuasheng.musicstore.model.User;

import java.util.List;

public interface UserDAO extends BaseDAO<User> {

    User getUserByEmailAndPassword(String email, String password);
    boolean isEmailExisted(String email);
    List<User> list();
}
