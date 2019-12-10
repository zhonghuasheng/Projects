package com.zhonghuasheng.musicstore.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.zhonghuasheng.musicstore.common.JDBCUtils;
import com.zhonghuasheng.musicstore.dao.UserDAO;
import com.zhonghuasheng.musicstore.model.Gender;
import com.zhonghuasheng.musicstore.model.Role;
import com.zhonghuasheng.musicstore.model.User;

public class UserDAOImpl extends AbstractBaseDAOImpl<User> implements UserDAO {

    private static final String DELETE_USER = "UPDATE user_ SET deleted=true, active=false WHERE uuid=?";
    private final String GET_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM user_ WHERE email=? and password=? AND active=TRUE AND deleted=FALSE LIMIT 1";
    private final String CREATE_USER = "INSERT INTO user_(uuid, username, email, password, role, gender, active, deleted, create_time, last_modified_time, last_modified_by) VALUES(?, ?, ?, ?, ?, ?, true, false, ?, ?, ?)";
    private final String CHECK_EMAIL_EXISTED = "SELECT COUNT(1) FROM user_ WHERE email=?;";
    private final String GET_ALL_USERS = "SELECT * FROM user_";

    @Override
    public User create(User user) {
        Connection connection = JDBCUtils.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, String.valueOf(user.getUuid()));
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole().toString());
            preparedStatement.setString(6, user.getGender().toString());
            preparedStatement.setTimestamp(7, user.getCreateTime());
            preparedStatement.setTimestamp(8, user.getLastModifiedTime());
            preparedStatement.setString(9, user.getLastModifiedBy());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

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
                user.setActive(resultSet.getBoolean("active"));
                user.setDeleted(resultSet.getBoolean("deleted"));
                user.setCreateTime(resultSet.getTimestamp("create_time"));
                user.setLastModifiedTime(resultSet.getTimestamp("last_modified_time"));
                user.setLastModifiedBy(resultSet.getString("last_modified_by"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean isEmailExisted(String email) {
        Connection connection = JDBCUtils.getConnection();
        boolean result = false;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_EMAIL_EXISTED);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<User> list() {
        Connection connection = JDBCUtils.getConnection();
        List<User> users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_USERS);
            while (resultSet.next()) {
                User user = new User();
                user.setUuid(UUID.fromString(resultSet.getString("uuid")));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setGender(Gender.valueOf(resultSet.getString("gender")));
                user.setAvatar(resultSet.getString("avatar"));
                user.setActive(resultSet.getBoolean("active"));
                user.setDeleted(resultSet.getBoolean("deleted"));
                user.setCreateTime(resultSet.getTimestamp("create_time"));
                user.setLastModifiedTime(resultSet.getTimestamp("last_modified_time"));
                user.setLastModifiedBy(resultSet.getString("last_modified_by"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public boolean delete(String uuid) {
        Connection connection = JDBCUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setString(1, uuid);
            int result = preparedStatement.executeUpdate();

            if(result == 1) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
