package com.stefanini.service;

import com.stefanini.dto.StefamonDTO;
import com.stefanini.entity.Stefamon;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.repository.StefamonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class StefamonService {
    @Inject
    StefamonRepository stefamonRepository;

    public List<StefamonDTO> listarTodos(){
        List<Stefamon> stefamons = stefamonRepository.listAll();
        return stefamons.stream().map(StefamonDTO::new).collect(Collectors.toList());
    }

    public StefamonDTO pegarPorId(Long id) {
        Stefamon stefamon =  stefamonRepository.findById(id);
        if(Objects.isNull(stefamon)) {
            throw new RegraDeNegocioException("Não encontramos nada com o id " + id, Response.Status.NOT_FOUND);
        }
        return new StefamonDTO(stefamon);
    }

 }
