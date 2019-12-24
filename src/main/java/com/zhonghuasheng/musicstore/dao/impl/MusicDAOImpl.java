package com.zhonghuasheng.musicstore.dao.impl;

import com.zhonghuasheng.musicstore.dao.MusicDAO;
import com.zhonghuasheng.musicstore.model.Music;

public class MusicDAOImpl extends AbstractBaseDAOImpl<Music> implements MusicDAO {

    @Override
    public Music create(Music music) {
        return music;
    }
}
