package com.zhonghuasheng.musicstore.action.user;

import com.zhonghuasheng.musicstore.model.User;
import com.zhonghuasheng.musicstore.service.UserService;
import com.zhonghuasheng.musicstore.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

@WebServlet(urlPatterns = "/admin/user/view")
public class ViewAction extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        User user = userService.get(uuid);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/html/user/view.jsp").forward(request, response);
    }
}