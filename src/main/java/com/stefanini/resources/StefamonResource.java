package com.stefanini.resources;

import com.stefanini.dto.StefamonDTO;
import com.stefanini.service.StefamonService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/stefamon")
public class StefamonResource {

    @Inject
    StefamonService stefamonService;

    @GET
    @Path("/todos")
    public Response listarTodos() {
        List<StefamonDTO> listaStefamons = stefamonService.listarTodos();
        return Response.status(Response.Status.OK).entity(listaStefamons).build();
    }

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(stefamonService.pegarPorId(id)).build();
    }

}
