package com.zhonghuasheng.seckill.service;

import com.zhonghuasheng.seckill.dao.UserDao;
import com.zhonghuasheng.seckill.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Student getById(int id) {
        return userDao.getById(id);
    }

    @Transactional
    public boolean tx() {
        Student user1 = new Student();
        user1.setId(10002);
        user1.setName("TestUser2");
        user1.setAge(18);
        userDao.insert(user1);

        Student user2 = new Student();
        user2.setId(10004);
        user2.setName("TestUser3");
        user2.setAge(19);
        userDao.insert(user2);

        return true;
    }
}
