package com.zhonghuasheng.musicstore.action.user;

import com.zhonghuasheng.musicstore.model.Artist;
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

@WebServlet(urlPatterns = {"/admin/user/list", "/admin/user", "/admin/user/search"})
public class ListAction extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/html/user/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pagination pagination = new Pagination();
        int currentPage = 1;
        int pageSize = 10;

        try {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        } catch (NumberFormatException nfe) {
        }

        try {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        } catch (NumberFormatException nfe) {
        }

        pagination.setCurrentPage(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setKey(request.getParameter("key"));

        List<User> users = userService.users(pagination);
        pagination.setData(users);
        pagination.setTotalPage((userService.count()  + pagination.getPageSize() - 1) / pagination.getPageSize());
        JSONObject result = new JSONObject(pagination);
        response.getWriter().write(result.toString());
    }
}