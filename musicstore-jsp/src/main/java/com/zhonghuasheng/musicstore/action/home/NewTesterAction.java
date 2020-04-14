package com.zhonghuasheng.musicstore.action.home;

import com.zhonghuasheng.musicstore.model.Pagination;
import com.zhonghuasheng.musicstore.model.User;
import com.zhonghuasheng.musicstore.service.UserService;
import com.zhonghuasheng.musicstore.service.impl.UserServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tester")
public class NewTesterAction extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.getNewTester();
        Pagination pagination = new Pagination();
        pagination.setData(users);
        resp.setContentType("application/json");
        JSONObject result = new JSONObject(pagination);
        resp.getWriter().write(result.toString());
    }
}
