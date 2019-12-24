package com.zhonghuasheng.musicstore.service.impl;

import com.zhonghuasheng.musicstore.dao.MusicDAO;
import com.zhonghuasheng.musicstore.dao.impl.MusicDAOImpl;
import com.zhonghuasheng.musicstore.model.Music;
import com.zhonghuasheng.musicstore.service.MusicService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class MusicServiceImpl implements MusicService {

    private MusicDAO musicDAO = new MusicDAOImpl();

    @Override
    public Music create(Music music) {
        music.setCreateTime(new Timestamp(new Date().getTime()));
        music.setLastModifiedTime(new Timestamp(new Date().getTime()));
        music.setLastModifiedBy("admin");
        music.setUuid(UUID.randomUUID());

        return musicDAO.create(music);
    }
}
