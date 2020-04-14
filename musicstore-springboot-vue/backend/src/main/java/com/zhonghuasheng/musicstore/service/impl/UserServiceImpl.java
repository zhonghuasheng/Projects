package com.zhonghuasheng.musicstore.service.impl;

import com.zhonghuasheng.musicstore.dao.UserDao;
import com.zhonghuasheng.musicstore.model.User;
import com.zhonghuasheng.musicstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return userDao.getUserByEmailAndPassword(email, password);
    }

    @Override
    public List<User> getActiveUsers() {
        return userDao.getActiveUsers();
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public User getUserById(String uuid) {
        return null;
    }
}
