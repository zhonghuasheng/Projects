package com.zhonghuasheng.musicstore.service;

import java.util.List;

import com.zhonghuasheng.musicstore.model.Artist;

public interface ArtistService {

    Artist create(Artist artist);
    List<Artist> artists();
}
