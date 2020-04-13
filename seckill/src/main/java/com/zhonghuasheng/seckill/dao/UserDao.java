package com.zhonghuasheng.seckill.dao;

import com.zhonghuasheng.seckill.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student getById(int id);

    @Insert("INSERT INTO student(id, name, age) VALUES(#{id}, #{name}, #{age})")
    int insert(Student user2);
}
