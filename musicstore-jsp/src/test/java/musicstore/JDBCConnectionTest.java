package musicstore;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.zhonghuasheng.musicstore.common.JDBCUtils;
import com.zhonghuasheng.musicstore.dao.UserDAO;
import com.zhonghuasheng.musicstore.dao.impl.UserDAOImpl;
import com.zhonghuasheng.musicstore.model.Gender;
import com.zhonghuasheng.musicstore.model.Role;
import com.zhonghuasheng.musicstore.model.User;

public class JDBCConnectionTest {

    @Test
    public void testJDBCConnection() {
        Connection connection = JDBCUtils.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void tesGetUserByEmailAndPassword() {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUserByEmailAndPassword("test@126.com", "testpwd");
        Assert.assertEquals("Equals", "test@126.com", user.getEmail());
    }

    @Test
    public void testCreateUser() {

        User user = new User();
        user.setUuid(UUID.randomUUID());
        user.setUsername("Luke");
        user.setEmail("xiaoyong@126.com");
        user.setPassword("123456");
        user.setBirthday(new Date());
        user.setRole(Role.USER);
        user.setGender(Gender.MALE);
        user.setCreateTime(new Timestamp(new Date().getTime()));
        user.setLastModifiedTime(new Timestamp(new Date().getTime()));
        user.setLastModifiedBy("-1");

        UserDAO userDAO = new UserDAOImpl();
        User result = userDAO.create(user);
        Assert.assertEquals(user.getUuid(), result.getUuid());
    }
}
