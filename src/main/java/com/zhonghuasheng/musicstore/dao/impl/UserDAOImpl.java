package com.zhonghuasheng.musicstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.zhonghuasheng.musicstore.common.JDBCUtils;
import com.zhonghuasheng.musicstore.dao.UserDAO;
import com.zhonghuasheng.musicstore.model.Gender;
import com.zhonghuasheng.musicstore.model.Role;
import com.zhonghuasheng.musicstore.model.User;

public class UserDAOImpl extends AbstractBaseDAOImpl<User> implements UserDAO {

    private final String GET_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM user_ WHERE email=? and password=? AND is_active=TRUE AND is_deleted=FALSE";
    private final String CREATE_USER = "INSERT user_(uuid, username, email, password, role, gender, is_active, is_deleted,"
            + " create_time, last_modified_time, last_modified_by) VALUES(?, ?, ?, ,? 'user', ?, true, false, now(), now(), '-1')";

    @Override
    public User create(User user) {
        Connection connection = JDBCUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        Connection connection = JDBCUtils.getConnection();
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setUuid(UUID.fromString(resultSet.getString("uuid")));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setGender(Gender.valueOf(resultSet.getString("gender")));
                user.setAvatar(resultSet.getString("avatar"));
                user.setActive(resultSet.getBoolean("is_active"));
                user.setDeleted(resultSet.getBoolean("is_deleted"));
                user.setCreateTime(resultSet.getDate("create_time"));
                user.setLastModifiedTime(resultSet.getDate("last_modified_time"));
                user.setLastModifiedBy(resultSet.getString("last_modified_by"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
