package com.zhonghuasheng.musicstore.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zhonghuasheng.musicstore.common.JDBCUtils;
import com.zhonghuasheng.musicstore.dao.ArtistDAO;
import com.zhonghuasheng.musicstore.model.Artist;

public class ArtistDAOImpl extends AbstractBaseDAOImpl<Artist> implements ArtistDAO {

    private final String CREATE_ARTIST = "INSERT INTO artist(uuid, name, birthday, region, experience, avatar, create_time, last_modified_time, last_modified_by, is_deleted)"
            + " VALUES (?,?,?,?,?,?,?,?,?,?);";

    @Override
    public Artist create(Artist artist) {
        Connection connection = JDBCUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ARTIST);
            preparedStatement.setString(1, String.valueOf(artist.getUuid()));
            preparedStatement.setString(2, artist.getName());
            preparedStatement.setDate(3, new Date(artist.getBirthday().getTime()));
            preparedStatement.setString(4, artist.getRegion());
            preparedStatement.setString(5, artist.getExperience());
            preparedStatement.setString(6, artist.getAvtar());
            preparedStatement.setTimestamp(7, artist.getCreateTime());
            preparedStatement.setTimestamp(8, artist.getLastModifiedTime());
            preparedStatement.setString(9, artist.getLastModifiedBy());
            preparedStatement.setBoolean(10, artist.isDeleted());
            boolean result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artist;
    }
}
