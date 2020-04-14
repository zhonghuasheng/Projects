package com.zhonghuasheng.seckill.dao;

import com.zhonghuasheng.seckill.domain.SecKillUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SecKillUserDao {

    @Select("SELECT * FROM seckill_user WHERE id = #{id}")
    SecKillUser getById(@Param("id") long id);
}
