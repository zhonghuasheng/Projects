package com.zhonghuasheng.musicstore.service.impl;

import com.zhonghuasheng.musicstore.dao.UserDAO;
import com.zhonghuasheng.musicstore.dao.impl.UserDAOImpl;
import com.zhonghuasheng.musicstore.model.User;
import com.zhonghuasheng.musicstore.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDao = new UserDAOImpl();

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return userDao.getUserByEmailAndPassword(email, password);
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

}
