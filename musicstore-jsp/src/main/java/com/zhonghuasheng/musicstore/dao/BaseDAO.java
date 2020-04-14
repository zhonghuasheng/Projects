package com.zhonghuasheng.musicstore.dao;

public interface BaseDAO<T> {

    T create(T obj);
    boolean delete(String uuid);
    boolean update(T obj);
    T get(String uuid);
}
