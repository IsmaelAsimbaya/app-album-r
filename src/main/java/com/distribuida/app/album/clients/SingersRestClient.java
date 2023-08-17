package com.distribuida.app.album.clients;

import com.distribuida.app.album.dtos.SingerDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/singers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "singerRestClient")
public interface SingersRestClient {

    @GET
    List<SingerDto> findAll();

    @GET
    @Path("/{id}")
    SingerDto getById(@PathParam("id") Integer id);
}
