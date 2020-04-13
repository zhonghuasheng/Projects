package com.zhonghuasheng.musicstore.dao;

import java.util.List;

import com.zhonghuasheng.musicstore.model.Music;
import com.zhonghuasheng.musicstore.model.Pagination;

public interface MusicDAO extends BaseDAO<Music> {

    int count();
    List<Music> find(Pagination pagination);
}
