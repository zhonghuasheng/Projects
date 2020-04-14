package com.zhonghuasheng.musicstore.model;

import java.sql.Timestamp;

public class Music extends BaseModel {

    private String title;
    private String artistUuid;
    private Timestamp publishDate;
    private String publishCompany;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistUuid() {
        return artistUuid;
    }

    public void setArtistUuid(String artistUuid) {
        this.artistUuid = artistUuid;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishCompany() {
        return publishCompany;
    }

    public void setPublishCompany(String publishCompany) {
        this.publishCompany = publishCompany;
    }

}
