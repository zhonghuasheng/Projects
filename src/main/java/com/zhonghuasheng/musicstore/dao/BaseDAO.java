package com.zhonghuasheng.musicstore.dao;

public interface BaseDAO<T> {

    T create(T obj);
    void delete(String uuid);
    void update(T obj);
    T get(String uuid);
}
