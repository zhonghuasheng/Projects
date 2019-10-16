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
import com.zhonghuasheng.musicstore.common.Utils;
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
        request.getRequestDispatcher("/WEB-INF/html/user/register.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        if (!validateParameters(request, response, user)) {
            request.setAttribute("user", user);
            doGet(request, response);
            // 不加return的话后面的代码还会继续执行
            return;
        }

        UserService userService = new UserServiceImpl();
        if (userService.isEmailExisted(user.getEmail())) {
            request.setAttribute("user", user);
            request.setAttribute("msg-email", Constants.EMAIL_EXISTED);
            doGet(request, response);
            return;
        } else {
            User result = userService.signUp(user);

            if (result != null) {
                response.sendRedirect(request.getContextPath() + "/user/login");
            } else {
                doGet(request, response);
            }
        }
    }

    public static boolean validateParameters(HttpServletRequest request, HttpServletResponse response, User user) {
        boolean isVerifyPassed = true;

        String username = request.getParameter("username");
        if (Utils.isNullOrEmpty(username)) {
            isVerifyPassed = false;
            request.setAttribute("msg-username", Constants.EMPTY_USERNAME);
        } else {
            user.setUsername(username);
        }

        String email = request.getParameter("email");
        if (Utils.isNullOrEmpty(email)) {
            isVerifyPassed = false;
            request.setAttribute("msg-email", Constants.EMPTY_EMAIL);
        } else {
            if (!Utils.isEmailAddressFormat(email)) {
                isVerifyPassed = false;
                request.setAttribute("msg-email", Constants.INVALID_EMAIL_FORMAT);
            } else {
                user.setEmail(email);
            }
        }

        String password = request.getParameter("password");
        if (Utils.isNullOrEmpty(password)) {
            request.setAttribute("msg-password", Constants.EMPTY_PASSWORD);
            isVerifyPassed = false;
        } else {
            if (password.trim().length() < 6 || password.trim().length() > 12) {
                isVerifyPassed = false;
                request.setAttribute("msg-password", Constants.INVAILD_PASSWORD_LENGTH);
            }
        }

        String confirmPassword = request.getParameter("confirmPassword");
        if (Utils.isNullOrEmpty(confirmPassword)) {
            isVerifyPassed = false;
            request.setAttribute("msg-confirmPassword", Constants.EMPTY_CONFIRM_PASSWORD);
        } else {
            if (!Utils.assertEquals(password, confirmPassword)) {
                isVerifyPassed = false;
                request.setAttribute("msg-confirmPassword", Constants.CONFIRM_PASSWORD_NOT_EQUALS_PASSWORD);
            } else {
                user.setPassword(confirmPassword);
            }
        }

        String birthday = request.getParameter("birthday");
        if (birthday != null && birthday != Constants.BLANK) {
            try {
                user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
                request.setAttribute("birthday", birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                user.setBirthday(new Date(2209017943000L));
            }
        } else {
            user.setBirthday(new Date(2209017943000L));
        }

        return isVerifyPassed;
    }
}
