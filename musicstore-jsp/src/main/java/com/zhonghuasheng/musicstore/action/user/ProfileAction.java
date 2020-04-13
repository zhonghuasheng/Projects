package com.zhonghuasheng.musicstore.action.user;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhonghuasheng.musicstore.model.Gender;
import com.zhonghuasheng.musicstore.model.User;
import com.zhonghuasheng.musicstore.service.UserService;
import com.zhonghuasheng.musicstore.service.impl.UserServiceImpl;

@WebServlet("/profile")
public class ProfileAction extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserService userService = new UserServiceImpl();

    public ProfileAction() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        User user = userService.get(uuid);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/html/user/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String uuid = request.getParameter("uuid");

        User user = new User();
        user.setUsername(username);
        user.setGender(Gender.valueOf(gender));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setUuid(UUID.fromString(uuid));

        boolean result = userService.update(user);
        if (result == true) {
            response.sendRedirect(request.getContextPath() + "/profile?uuid=" + uuid);
        }

    }
}
