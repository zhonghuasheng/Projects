package com.zhonghuasheng.musicstore.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhonghuasheng.musicstore.common.Constants;
import com.zhonghuasheng.musicstore.model.User;
import com.zhonghuasheng.musicstore.service.UserService;
import com.zhonghuasheng.musicstore.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends HttpServlet {

    private static final long serialVersionUID = 109110977079706841L;

    public LoginAction() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(Constants.LOGIN_PAGE).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        UserService userService = new UserServiceImpl();
        User user = userService.login(email, password);

        if (user != null) {
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("error", "账号或者密码错误！");
            request.getRequestDispatcher(Constants.LOGIN_PAGE).forward(request,response);
        }
    }
}
