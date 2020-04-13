package com.zhonghuasheng.musicstore.service.impl;

import com.zhonghuasheng.musicstore.dao.CartDao;
import com.zhonghuasheng.musicstore.dao.impl.CartDaoImpl;
import com.zhonghuasheng.musicstore.model.Cart;
import com.zhonghuasheng.musicstore.service.CartService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class CartServiceImpl implements CartService {

    private CartDao cartDao = new CartDaoImpl();

    @Override
    public Cart create(Cart cart) {
        cart.setUuid(UUID.randomUUID());
        cart.setCreateTime(new Timestamp((new Date()).getTime()));
        cart.setLastModifiedTime(new Timestamp((new Date()).getTime()));
        return cartDao.create(cart);
    }
}
