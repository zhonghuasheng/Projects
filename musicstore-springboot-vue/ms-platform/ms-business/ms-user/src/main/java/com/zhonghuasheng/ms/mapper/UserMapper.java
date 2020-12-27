package com.zhonghuasheng.ms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhonghuasheng.ms.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
