package com.zhonghuasheng.musicstore.dao.impl;

import com.zhonghuasheng.musicstore.dao.BaseDAO;

public abstract class AbstractBaseDAOImpl<T> implements BaseDAO<T> {
    @Override
    public T create(T obj) {
        return null;
    }

    @Override
    public void delete(String uuid) {
        
    }

    @Override
    public void update(T obj) {
        
    }

    @Override
    public T get(String uuid) {
        return null;
    }
}
