package com.zhonghuasheng.musicstore.action.cart;

import com.zhonghuasheng.musicstore.model.Cart;
import com.zhonghuasheng.musicstore.service.CartService;
import com.zhonghuasheng.musicstore.service.impl.CartServiceImpl;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;

/**
 * 添加到购物车类。普通用户将音乐添加到自己的购物车中。
 */
@WebServlet(urlPatterns = "/cart/create")
public class CreateAction extends HttpServlet {

    private CartService cartService = new CartServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        Cart cart = new Cart();
        cart.setLastModifiedBy("-1"); // TODO 通过session获取当前用户
        cart.setUserUuid(UUID.randomUUID());
        cart.setMusicUuid(UUID.fromString(uuid));
        Cart result = cartService.create(cart);
        if (result.getUuid() != null) {
            JSONObject jsonObject = new JSONObject(true);
            response.getWriter().write(jsonObject.toString());
        } else {
            response.getWriter().write("添加失败，请重试！");
        }
    }
}