package com.zhonghuasheng.musicstore.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.zhonghuasheng.musicstore.dao.ArtistDAO;
import com.zhonghuasheng.musicstore.dao.impl.ArtistDAOImpl;
import com.zhonghuasheng.musicstore.model.Artist;
import com.zhonghuasheng.musicstore.model.Pagination;
import com.zhonghuasheng.musicstore.service.ArtistService;

public class ArtistServiceImpl implements ArtistService {

    private ArtistDAO artistDao = new ArtistDAOImpl();

    @Override
    public Artist create(Artist artist) {
        artist.setUuid(UUID.randomUUID());
        artist.setCreateTime(new Timestamp(new Date().getTime()));
        artist.setDeleted(false);
        artist.setLastModifiedBy("-1");
        artist.setLastModifiedTime(new Timestamp(new Date().getTime()));

        return artistDao.create(artist);
    }

    @Override
    public List<Artist> artists(Pagination pagination) {
        pagination.setKey("%" + pagination.getKey() + "%");
        return artistDao.list(pagination);
    }

    @Override
    public Artist get(String uuid) {
        return artistDao.get(uuid);
    }

    @Override
    public boolean update(Artist artist) {
        artist.setLastModifiedBy("-1");
        artist.setLastModifiedTime(new Timestamp(new Date().getTime()));

        return artistDao.update(artist);
    }

    @Override
    public boolean delete(String uuid) {
        return artistDao.delete(uuid);
    }

    @Override
    public int count() {
        return artistDao.count();
    }
}
