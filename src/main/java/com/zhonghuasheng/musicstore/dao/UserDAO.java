package com.zhonghuasheng.musicstore.dao;

import com.zhonghuasheng.musicstore.model.User;

public interface UserDAO extends BaseDAO<User> {

    User getUserByEmailAndPassword(String email, String password);
}
