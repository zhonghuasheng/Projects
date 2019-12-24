package com.zhonghuasheng.musicstore.dao.impl;

import com.zhonghuasheng.musicstore.common.JDBCUtils;
import com.zhonghuasheng.musicstore.dao.MusicDAO;
import com.zhonghuasheng.musicstore.model.Music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MusicDAOImpl extends AbstractBaseDAOImpl<Music> implements MusicDAO {

    private static final String CREATE_MUSIC = "INSERT INTO music (uuid, title, artist_uuid, publish_date, publish_company, create_time, last_modified_time, last_modified_by, deleted) VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0)";

    @Override
    public Music create(Music music) {
        Connection connection = JDBCUtils.getConnection();
        boolean result = false;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_MUSIC);
            preparedStatement.setString(1, String.valueOf(music.getUuid()));
            preparedStatement.setString(2, music.getTitle());
            preparedStatement.setString(3, String.valueOf(music.getArtistUuid()));
            preparedStatement.setTimestamp(4, music.getPublishDate());
            preparedStatement.setString(5, music.getPublishCompany());
            preparedStatement.setTimestamp(6, music.getCreateTime());
            preparedStatement.setTimestamp(7, music.getLastModifiedTime());
            preparedStatement.setString(8, music.getLastModifiedBy());
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result == true ? music : null;
    }
}
