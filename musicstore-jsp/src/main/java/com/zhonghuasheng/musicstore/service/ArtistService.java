package com.zhonghuasheng.musicstore.service;

import java.util.List;

import com.zhonghuasheng.musicstore.model.Artist;
import com.zhonghuasheng.musicstore.model.Pagination;

public interface ArtistService {

    Artist create(Artist artist);
    List<Artist> artists(Pagination pagination);
    Artist get(String uuid);
    boolean update(Artist artist);
    boolean delete(String uuid);
    int count();
    List<Artist> list();
    List<Artist> getRecommendArtist();
}
