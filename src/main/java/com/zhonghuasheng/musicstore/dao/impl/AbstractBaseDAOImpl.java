package com.zhonghuasheng.musicstore.dao.impl;

import com.zhonghuasheng.musicstore.dao.BaseDAO;

public abstract class AbstractBaseDAOImpl<T> implements BaseDAO<T> {
    @Override
    public T create(T obj) {
        return null;
    }

    @Override
    public boolean delete(String uuid) {
        return false;
    }

    @Override
    public boolean update(T obj) {
        return false;
    }

    @Override
    public T get(String uuid) {
        return null;
    }
}
