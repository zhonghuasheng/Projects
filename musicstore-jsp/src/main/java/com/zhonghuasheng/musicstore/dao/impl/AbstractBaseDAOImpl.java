package com.zhonghuasheng.musicstore.dao.impl;

import com.zhonghuasheng.musicstore.common.JDBCUtils;
import com.zhonghuasheng.musicstore.dao.BaseDAO;

import java.sql.*;

public abstract class AbstractBaseDAOImpl<T> implements BaseDAO<T> {

    @Override
    public T create(T obj) {
        return null;
    }

    @Override
    public boolean delete(String sql) {
        Connection connection = JDBCUtils.getConnection();
        boolean result = false;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean update(T obj) {
        return false;
    }

    @Override
    public T get(String sql) {
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
