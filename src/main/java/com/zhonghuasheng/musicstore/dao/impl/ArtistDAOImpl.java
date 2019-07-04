package com.zhonghuasheng.musicstore.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.zhonghuasheng.musicstore.common.JDBCUtils;
import com.zhonghuasheng.musicstore.dao.ArtistDAO;
import com.zhonghuasheng.musicstore.model.Artist;

public class ArtistDAOImpl extends AbstractBaseDAOImpl<Artist> implements ArtistDAO {

    private static final String SELECT_ARTISTS = "SELECT * FROM artist;";
    private static final String CREATE_ARTIST = "INSERT INTO artist(uuid, name, birthday, region, experience, avatar, create_time, last_modified_time, last_modified_by, deleted)"
            + " VALUES (?,?,?,?,?,?,?,?,?,?);";
    private static final String GET_ARTIST = "SELECT * FROM artist WHERE uuid = ?;";

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
            preparedStatement.setString(6, artist.getAvatar());
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

    @Override
    public List<Artist> list() {
        Connection connection = JDBCUtils.getConnection();
        List<Artist> artists = new ArrayList<Artist>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ARTISTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setUuid(UUID.fromString(resultSet.getString("uuid")));
                artist.setAvatar(resultSet.getString("avatar"));
                artist.setBirthday(resultSet.getDate("birthday"));
                artist.setCreateTime(resultSet.getTimestamp("create_time"));
                artist.setDeleted(resultSet.getBoolean("deleted"));
                artist.setExperience(resultSet.getString("experience"));
                artist.setLastModifiedBy(resultSet.getString("last_modified_by"));
                artist.setLastModifiedTime(resultSet.getTimestamp("last_modified_time"));
                artist.setName(resultSet.getString("name"));
                artist.setRegion(resultSet.getString("region"));
                artists.add(artist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artists;
    }

    @Override
    public Artist get(String uuid) {
        Connection connection = JDBCUtils.getConnection();
        Artist result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ARTIST);
            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = convertPOtoVO(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Artist convertPOtoVO(ResultSet resultSet) throws SQLException {
        Artist artist = new Artist();
        artist.setUuid(UUID.fromString(resultSet.getString("uuid")));
        artist.setAvatar(resultSet.getString("avatar"));
        artist.setBirthday(resultSet.getDate("birthday"));
        artist.setCreateTime(resultSet.getTimestamp("create_time"));
        artist.setDeleted(resultSet.getBoolean("deleted"));
        artist.setExperience(resultSet.getString("experience"));
        artist.setLastModifiedBy(resultSet.getString("last_modified_by"));
        artist.setLastModifiedTime(resultSet.getTimestamp("last_modified_time"));
        artist.setName(resultSet.getString("name"));
        artist.setRegion(resultSet.getString("region"));

        return artist;
    }
}
