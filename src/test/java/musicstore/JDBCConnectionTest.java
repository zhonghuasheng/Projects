package musicstore;

import java.sql.Connection;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.zhonghuasheng.musicstore.common.JDBCUtils;
import com.zhonghuasheng.musicstore.dao.UserDAO;
import com.zhonghuasheng.musicstore.dao.impl.UserDAOImpl;
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
}
