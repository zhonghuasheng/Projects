package com.zhonghuasheng.ms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhonghuasheng.ms.mapper.UserMapper;
import com.zhonghuasheng.ms.model.User;
import com.zhonghuasheng.ms.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
