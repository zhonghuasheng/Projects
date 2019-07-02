package com.zhonghuasheng.musicstore.dao;

import java.util.List;

import com.zhonghuasheng.musicstore.model.Artist;

public interface ArtistDAO extends BaseDAO<Artist> {

    List<Artist> list();
}
