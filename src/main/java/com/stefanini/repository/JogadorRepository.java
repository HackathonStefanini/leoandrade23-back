package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.dto.JogadorDTO;
import com.stefanini.entity.Jogador;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<Jogador> login(JogadorDTO jogadorDTO){
        Query nativeQuery = this.createNativeQuery("SELECT * FROM jogador WHERE nickname = ? AND password = ?");
        nativeQuery.setParameter(1, jogadorDTO.getNickname());
        nativeQuery.setParameter(2, jogadorDTO.getPassword());
        List<Jogador> jogadorLogin = nativeQuery.getResultList();
        return jogadorLogin;
    }
}
