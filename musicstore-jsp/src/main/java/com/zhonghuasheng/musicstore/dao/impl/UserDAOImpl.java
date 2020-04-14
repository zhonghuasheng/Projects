package com.zhonghuasheng.musicstore.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.zhonghuasheng.musicstore.common.JDBCUtils;
import com.zhonghuasheng.musicstore.dao.UserDAO;
import com.zhonghuasheng.musicstore.model.Gender;
import com.zhonghuasheng.musicstore.model.Pagination;
import com.zhonghuasheng.musicstore.model.Role;
import com.zhonghuasheng.musicstore.model.User;

public class UserDAOImpl extends AbstractBaseDAOImpl<User> implements UserDAO {

    private static final String DELETE_USER = "UPDATE user_ SET deleted=true, active=false WHERE uuid=?";
    private static final String GET_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM user_ WHERE email=? and password=? AND active=TRUE AND deleted=FALSE LIMIT 1";
    private static final String CREATE_USER = "INSERT INTO user_(uuid, username, email, password, role, birthday, gender, active, deleted, create_time, last_modified_time, last_modified_by) VALUES(?, ?, ?, ?, ?, ?, ?, true, false, ?, ?, ?)";
    private static final String CHECK_EMAIL_EXISTED = "SELECT COUNT(1) FROM user_ WHERE email=?";
    private static final String GET_USERS = "SELECT * FROM user_ WHERE username LIKE ? LIMIT ? OFFSET ?";
    private static final String GET_USER_BY_UUID = "SELECT * FROM user_ WHERE uuid=?";
    private static final String SELECT_COUNT = "SELECT COUNT(1) FROM user_";
    private static final String UPDATE_USER = "UPDATE user_ SET username=?, gender=?, birthday=?, last_modified_time=?, last_modified_by=? WHERE uuid=?";
    private static final String GET_NEW_TESTER = "SELECT * FROM user_ ORDER BY last_modified_time DESC LIMIT 6";

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

            if (user.getBirthday() != null) {
                preparedStatement.setDate(6, new Date(user.getBirthday().getTime()));
            } else {
                preparedStatement.setDate(6, null);
            }

            preparedStatement.setString(7, user.getGender().toString());
            preparedStatement.setTimestamp(8, user.getCreateTime());
            preparedStatement.setTimestamp(9, user.getLastModifiedTime());
            preparedStatement.setString(10, user.getLastModifiedBy());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getNewTester() {
        Connection connection = JDBCUtils.getConnection();
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_NEW_TESTER);
            while (resultSet.next()) {
                users.add(convertPOtoVO(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        if (email == null || email.equals("")) {
            return null;
        }
        if (password == null || password.equals("")) {
            return null;
        }

        Connection connection = JDBCUtils.getConnection();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                user = convertPOtoVO(resultSet);
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
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<User> list(Pagination pagination) {
        Connection connection = JDBCUtils.getConnection();
        List<User> users = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS);
            preparedStatement.setString(1, pagination.getKey());
            preparedStatement.setInt(2, pagination.getPageSize());
            preparedStatement.setInt(3, (pagination.getCurrentPage() - 1) * pagination.getPageSize());
            ResultSet resultSet = preparedStatement.executeQuery();
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
    public int count() {
        return count(SELECT_COUNT);
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

    @Override
    public User get(String uuid) {
        Connection connection = JDBCUtils.getConnection();
        User user = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_USER_BY_UUID);
            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                user = convertPOtoVO(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean update(User user) {
        Connection connection = JDBCUtils.getConnection();
        boolean result = false;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getGender().toString());

            if (user.getBirthday() != null) {
                preparedStatement.setDate(3, new Date(user.getBirthday().getTime()));
            } else {
                preparedStatement.setDate(3, null);
            }

            preparedStatement.setTimestamp(4, user.getLastModifiedTime());
            preparedStatement.setString(5, user.getLastModifiedBy());
            preparedStatement.setString(6, String.valueOf(user.getUuid()));
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private User convertPOtoVO(ResultSet resultSet) throws SQLException {
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

        return user;
    }
}
