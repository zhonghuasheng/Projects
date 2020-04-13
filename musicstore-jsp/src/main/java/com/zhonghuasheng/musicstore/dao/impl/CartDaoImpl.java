package com.zhonghuasheng.musicstore.dao.impl;

import com.zhonghuasheng.musicstore.common.JDBCUtils;
import com.zhonghuasheng.musicstore.dao.CartDao;
import com.zhonghuasheng.musicstore.model.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartDaoImpl extends AbstractBaseDAOImpl<Cart> implements CartDao {

    private static final String INSERT_CART = "INSERT INTO cart" +
            "(uuid, user_uuid, music_uuid, create_time, last_modified_time, last_modified_by, deleted)" +
            "VALUES(?, ?, ?, ?, ?, ?, false);";

    @Override
    public Cart create(Cart cart) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_CART);
            preparedStatement.setString(1, String.valueOf(cart.getUuid()));
            preparedStatement.setString(2, String.valueOf(cart.getUserUuid()));
            preparedStatement.setString(3, String.valueOf(cart.getMusicUuid()));
            preparedStatement.setTimestamp(4, cart.getCreateTime());
            preparedStatement.setTimestamp(5, cart.getLastModifiedTime());
            preparedStatement.setString(6, cart.getLastModifiedBy());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return cart;
    }

    @Override
    public boolean delete(String uuid) {
        return false;
    }

    @Override
    public boolean update(Cart obj) {
        return false;
    }

    @Override
    public Cart get(String uuid) {
        return null;
    }
}
