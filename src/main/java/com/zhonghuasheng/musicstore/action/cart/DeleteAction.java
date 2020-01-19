package com.zhonghuasheng.musicstore.action.cart;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 * 删除购物车类。普通用户从购物车中移除选中的音乐。
 */
@WebServlet(urlPatterns = "/cart/delete")
public class DeleteAction extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}