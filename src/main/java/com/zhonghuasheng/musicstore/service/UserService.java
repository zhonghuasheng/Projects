package com.zhonghuasheng.musicstore.service;

import com.zhonghuasheng.musicstore.model.User;

public interface UserService {

    User getUserByEmailAndPassword(String email, String password);
}
