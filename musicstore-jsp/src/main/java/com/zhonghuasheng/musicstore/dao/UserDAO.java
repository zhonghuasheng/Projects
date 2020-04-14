package com.zhonghuasheng.musicstore.dao;

import java.util.List;

import com.zhonghuasheng.musicstore.model.Pagination;
import com.zhonghuasheng.musicstore.model.User;

public interface UserDAO extends BaseDAO<User> {

    boolean isEmailExisted(String email);
    List<User> list(Pagination pagination);
    int count();
    User getUserByEmailAndPassword(String email, String password);
    List<User> getNewTester();
}
