package com.zhonghuasheng.musicstore.dao.impl;

import com.zhonghuasheng.musicstore.common.JDBCUtils;
import com.zhonghuasheng.musicstore.dao.MusicDAO;
import com.zhonghuasheng.musicstore.model.Music;
import com.zhonghuasheng.musicstore.model.Pagination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MusicDAOImpl extends AbstractBaseDAOImpl<Music> implements MusicDAO {

    private static final String CREATE_MUSIC = "INSERT INTO music (uuid, title, artist_uuid, publish_date, publish_company, create_time, last_modified_time, last_modified_by, deleted) VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0)";
    private static final String FIND_MUSICS = "SELECT m.uuid, m.title, a.name AS artist_uuid, m.publish_date, m.publish_company, m.create_time, m.deleted, m.last_modified_by, m.last_modified_time " +
            "FROM music m INNER JOIN artist a ON m.artist_uuid = a.uuid WHERE m.title LIKE ? LIMIT ? OFFSET ?;";
    private static final String SELECT_COUNT = "SELECT COUNT(1) FROM music";
    private static final String DELETE_MUSIC = "UPDATE music SET deleted = FALSE WHERE uuid=%s;";
    private static final String GET_MUSIC = "SELECT * FROM music WHERE uuid=?";

    @Override
    public Music create(Music music) {
        Connection connection = JDBCUtils.getConnection();

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
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return music;
    }

    @Override
    public int count() {
        return count(SELECT_COUNT);
    }

    @Override
    public List<Music> find(Pagination pagination) {
        Connection connection = JDBCUtils.getConnection();
        List<Music> musics = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_MUSICS);
            preparedStatement.setString(1, pagination.getKey());
            preparedStatement.setInt(2, pagination.getPageSize());
            preparedStatement.setInt(3, (pagination.getCurrentPage() - 1) * pagination.getPageSize());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                musics.add(convertPOtoVO(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return musics;
    }

    @Override
    public boolean delete(String uuid) {
        return super.delete(String.format(DELETE_MUSIC, uuid));
    }

    @Override
    public Music get(String uuid) {
        Connection connection = JDBCUtils.getConnection();
        Music music = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MUSIC);
            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            music = convertPOtoVO(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return music;
    }

    private Music convertPOtoVO(ResultSet resultSet) throws SQLException {
        Music music = new Music();
        music.setUuid(UUID.fromString(resultSet.getString("uuid")));
        music.setTitle(resultSet.getString("title"));
        music.setArtistUuid(resultSet.getString("artist_uuid"));
        music.setCreateTime(resultSet.getTimestamp("create_time"));
        music.setDeleted(resultSet.getBoolean("deleted"));
        music.setLastModifiedBy(resultSet.getString("last_modified_by"));
        music.setLastModifiedTime(resultSet.getTimestamp("last_modified_time"));
        music.setPublishCompany(resultSet.getString("publish_company"));
        music.setPublishDate(resultSet.getTimestamp("publish_date"));

        return music;
    }
}
