package com.distribuida.app.album.rest;

import com.distribuida.app.album.clients.SingersRestClient;
import com.distribuida.app.album.db.Album;
import com.distribuida.app.album.dtos.AlbumDto;
import com.distribuida.app.album.dtos.SingerDto;
import com.distribuida.app.album.repo.AlbumRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Path("/albums")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@ApplicationScoped
public class AlbumRest {

    @Inject
    AlbumRepository rep;

    @Inject
    @RestClient
    SingersRestClient clientSinger;

    static AlbumDto fromAlbum(Album obj) {
        AlbumDto dto = new AlbumDto();

        dto.setId(obj.getId());
        dto.setTitle(obj.getTitle());
        dto.setRelease_date(obj.getRelease_date());
        dto.setVersion(obj.getVersion());

        return dto;
    }

    @GET
    public List<AlbumDto> findAll() {

        return rep.streamAll()
                .map(AlbumRest::fromAlbum)
                .map(dto->{
                    SingerDto singerDto = clientSinger.getById(dto.getSinger_id());
                    dto.setSinger_id(singerDto.getSinger_id());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        var album = rep.findByIdOptional(id);

        if (album.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Album obj = album.get();

        AlbumDto dto = new AlbumDto();

        SingerDto singerDto = clientSinger.getById(obj.getSinger_id());

        dto.setId(obj.getId());
        dto.setTitle(obj.getTitle());
        dto.setRelease_date(obj.getRelease_date());
        dto.setVersion(obj.getVersion());
        dto.setSinger_id(singerDto.getSinger_id());

        return Response.ok(dto).build();
    }

    @POST
    public Response create(Album a) {
        rep.persist(a);

        return Response.status(Response.Status.CREATED.getStatusCode(), "Album created").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, Album albumObj) {
        Album album = rep.findById(id);

        album.setTitle(albumObj.getTitle());
        album.setSinger_id(albumObj.getSinger_id());
        album.setRelease_date(albumObj.getRelease_date());
        album.setVersion(albumObj.getVersion());

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        rep.deleteById(id);

        return Response.ok( )
                .build();
    }






}
