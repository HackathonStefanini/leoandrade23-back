package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.dto.JogadorDTO;
import com.stefanini.entity.Jogador;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class JogadorRepository extends GenericDAO<Jogador, Long> {

    @Transactional
    public JogadorDTO salvarUsuario(JogadorDTO jogadorDTO){
        Jogador jogador = new Jogador(jogadorDTO);
        this.save(jogador);
        return new JogadorDTO(jogador);
    }

    @Transactional
    public JogadorDTO alterarUsuario(JogadorDTO jogadorDTO){
        Jogador jogador = this.findById(jogadorDTO.getId());
        jogador = new Jogador(jogadorDTO);
        this.update(jogador);
        return new JogadorDTO(jogador);
    }
}
