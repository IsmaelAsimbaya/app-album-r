package com.distribuida.app.album.dtos;

import java.util.Date;

public class AlbumDto {

    private Integer id;
    private Integer singer_id;
    private String title;
    private Date release_date;
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSinger_id() {
        return singer_id;
    }

    public void setSinger_id(Integer singer_id) {
        this.singer_id = singer_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "AlbumDto{" +
                "id=" + id +
                ", singer_id=" + singer_id +
                ", title='" + title + '\'' +
                ", release_date=" + release_date +
                ", version=" + version +
                '}';
    }
}
