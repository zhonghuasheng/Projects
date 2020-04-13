package com.zhonghuasheng.musicstore.service;

import java.util.List;

import com.zhonghuasheng.musicstore.model.Music;
import com.zhonghuasheng.musicstore.model.Pagination;

public interface MusicService {

    Music create(Music music);
    List<Music> find(Pagination pagination);
    int count();
    boolean delete(String uuid);
    Music get(String uuid);
}
