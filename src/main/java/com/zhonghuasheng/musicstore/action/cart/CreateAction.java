package com.zhonghuasheng.musicstore.action.cart;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 * 添加到购物车类。普通用户将音乐添加到自己的购物车中。
 */
@WebServlet(urlPatterns = "/cart/create")
public class CreateAction extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}