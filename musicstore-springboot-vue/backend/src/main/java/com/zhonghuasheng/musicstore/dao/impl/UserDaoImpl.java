package com.zhonghuasheng.musicstore.dao.impl;

import com.zhonghuasheng.musicstore.dao.UserDao;
import com.zhonghuasheng.musicstore.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository(value = "userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

    private String statement = getSqlNameSpace(UserDaoImpl.class);

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("password", password);
        User user = this.getSqlSession().selectOne("com.zhonghuasheng.musicstore.dao.UserDao.getUserByEmailAndPassword", map);

        return user;
    }

    @Override
    public List<User> getActiveUsers() {
        List<User> users = new ArrayList<>();
        users = getSqlSession().selectList("com.zhonghuasheng.musicstore.dao.UserDao.getActiveUsers");

        return users;
    }
}
