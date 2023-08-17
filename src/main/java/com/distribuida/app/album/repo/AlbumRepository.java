package com.distribuida.app.album.repo;

import com.distribuida.app.album.db.Album;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlbumRepository implements PanacheRepositoryBase<Album, Integer> {
}
