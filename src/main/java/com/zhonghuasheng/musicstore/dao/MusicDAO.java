package com.zhonghuasheng.musicstore.dao;

import com.zhonghuasheng.musicstore.model.Artist;
import com.zhonghuasheng.musicstore.model.Music;
import com.zhonghuasheng.musicstore.model.Pagination;

import java.util.List;

public interface MusicDAO extends BaseDAO<Music> {
    int count();
    List<Music> find(Pagination pagination);
}
