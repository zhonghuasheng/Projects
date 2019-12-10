package com.zhonghuasheng.musicstore.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.zhonghuasheng.musicstore.common.Constants;
import com.zhonghuasheng.musicstore.dao.UserDAO;
import com.zhonghuasheng.musicstore.dao.impl.UserDAOImpl;
import com.zhonghuasheng.musicstore.model.Gender;
import com.zhonghuasheng.musicstore.model.Role;
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
        user.setUuid(UUID.randomUUID());
        user.setAvatar(Constants.BLANK);
        user.setRole(Role.USER);
        user.setGender(Gender.UNKNOW);
        user.setCreateTime(new Timestamp(new Date().getTime()));
        user.setLastModifiedTime(new Timestamp(new Date().getTime()));
        user.setLastModifiedBy(user.getUuid().toString());

        return userDao.create(user);
    }

    @Override
    public User signUp(User user) {
        user.setUuid(UUID.randomUUID());
        user.setAvatar(Constants.BLANK);
        user.setRole(Role.USER);
        user.setGender(Gender.UNKNOW);
        user.setCreateTime(new Timestamp(new Date().getTime()));
        user.setLastModifiedTime(new Timestamp(new Date().getTime()));
        user.setLastModifiedBy(user.getUuid().toString());

        return userDao.create(user);
    }

    @Override
    public boolean isEmailExisted(String email) {
        return userDao.isEmailExisted(email);
    }

    @Override
    public boolean delete(String uuid) {
        return userDao.delete(uuid);
    }

    @Override
    public User get(String uuid) {
        return userDao.get(uuid);
    }

    @Override
    public List<User> users() {
        return userDao.list();
    }


}
