package com.zhonghuasheng.musicstore.action.user;

import com.zhonghuasheng.musicstore.model.User;
import com.zhonghuasheng.musicstore.service.UserService;
import com.zhonghuasheng.musicstore.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/user/list", "/admin/user", "/admin/user/search"})
public class ListAction extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object search = request.getAttribute("search");
        Object pageNum = request.getAttribute("pageNum");

        if (search == null && pageNum == null) {
            List<User> users = userService.users();
            request.setAttribute("users", users);
            request.setAttribute("totalPages", 20);
            request.getRequestDispatcher("/WEB-INF/html/user/list.jsp").forward(request, response);
        } else {
            String keyWorld = "%%";
            int currentPage = 1;

            if (search != null) {
                keyWorld = "%" + search.toString() + "%";
            }

            if (pageNum != null) {
                currentPage = Integer.valueOf(pageNum.toString());
            }


        }
    }
}