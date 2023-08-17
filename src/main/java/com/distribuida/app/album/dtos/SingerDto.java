package com.distribuida.app.album.dtos;

public class SingerDto {

    private Integer singer_id;

    public Integer getSinger_id() {
        return singer_id;
    }

    public void setSinger_id(Integer singer_id) {
        this.singer_id = singer_id;
    }

    @Override
    public String toString() {
        return "SingerDto{" +
                "singer_id=" + singer_id +
                '}';
    }
}
