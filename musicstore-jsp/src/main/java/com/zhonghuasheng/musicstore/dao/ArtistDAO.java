package com.zhonghuasheng.musicstore.dao;

import java.util.List;

import com.zhonghuasheng.musicstore.model.Artist;
import com.zhonghuasheng.musicstore.model.Pagination;

public interface ArtistDAO extends BaseDAO<Artist> {

    List<Artist> list(Pagination pagination);
    List<Artist> list();
    int count();
    List<Artist> getRecommendArtist();
}
