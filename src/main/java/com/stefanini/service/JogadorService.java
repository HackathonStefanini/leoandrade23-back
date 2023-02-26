package com.stefanini.service;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.repository.JogadorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class JogadorService {
    @Inject
    JogadorRepository jogadorRepository;
    public List<JogadorDTO> listarTodos() {
        List<Jogador> jogadores = jogadorRepository.listAll();
        return jogadores.stream().map(JogadorDTO::new).collect(Collectors.toList());
    }
    public JogadorDTO pegarPorId(Long id) {
        Jogador jogador = jogadorRepository.findById(id);
        if(Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("Ocorreu um erro ao buscar o Jogador de id " + id, Response.Status.NOT_FOUND);
        }
        return new JogadorDTO(jogador);
    }

    public JogadorDTO salvar(JogadorDTO jogadorDTO) {
        // Criptografar Senha
        return jogadorRepository.salvarUsuario(jogadorDTO);
    }


    public JogadorDTO alterar(JogadorDTO jogadorDTO) {
        return jogadorRepository.alterarUsuario(jogadorDTO);
    }

    public void deletar(Long id) {
        jogadorRepository.delete(id);
    }

}
