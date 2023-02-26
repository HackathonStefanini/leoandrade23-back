package com.stefanini.resources;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.service.JogadorService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/jogador")
public class JogadorResource {

    @Inject
    JogadorService jogadorService;

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id){
        JogadorDTO jogadorDTO = jogadorService.pegarPorId(id);
        return Response.status(Response.Status.OK).entity(jogadorDTO).build();
    }

    @GET
    @Path("/todos")
    public Response listarTodos(){
        List<JogadorDTO> listaJogadores = jogadorService.listarTodos();
        return Response.status(Response.Status.OK).entity(listaJogadores).build();
    }

    @POST
    public Response salvar(@Valid JogadorDTO jogadorDTO) {
        return Response.status(Response.Status.CREATED).entity(jogadorService.salvar(jogadorDTO)).build();
    }

    @PUT
    public Response alterar(@Valid JogadorDTO jogadorDTO) {
        return Response.status(Response.Status.OK).entity(jogadorService.alterar(jogadorDTO)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        jogadorService.deletar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
