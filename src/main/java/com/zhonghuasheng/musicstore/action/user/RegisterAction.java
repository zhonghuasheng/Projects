package com.zhonghuasheng.musicstore.action.user;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhonghuasheng.musicstore.common.Constants;
import com.zhonghuasheng.musicstore.model.User;
import com.zhonghuasheng.musicstore.service.UserService;
import com.zhonghuasheng.musicstore.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/user/register")
public class RegisterAction extends HttpServlet {

    private static final long serialVersionUID = 6200549743978870400L;

    public RegisterAction() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/html/user/register.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("birthday"));
        User user = new User();

        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        String birthday = request.getParameter("birthday");
        if (birthday != null && birthday != Constants.BLANK) {
            try {
                user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            user.setBirthday(new Date(2209017943000L));
        }

        UserService userService = new UserServiceImpl();
        User result = userService.create(user);

        if (result != null) {
            // request.getContextPath()值为/musicstore-jsp, context配置在server的module中
            response.sendRedirect(request.getContextPath() + "/user/login");
        } else {
            doGet(request, response);
        }
    }
}
