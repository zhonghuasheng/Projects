package com.zhonghuasheng.musicstore.dao.impl;

import com.zhonghuasheng.musicstore.common.JDBCUtils;
import com.zhonghuasheng.musicstore.dao.BaseDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractBaseDAOImpl<T> implements BaseDAO<T> {

    @Override
    public T create(T obj) {
        return null;
    }

    @Override
    public boolean delete(String uuid) {
        return false;
    }

    @Override
    public boolean update(T obj) {
        return false;
    }

    @Override
    public T get(String uuid) {
        return null;
    }

    protected int count(String sql) {
        Connection connection = JDBCUtils.getConnection();
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            result = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
