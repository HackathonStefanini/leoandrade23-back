package com.stefanini.dto;

import com.stefanini.entity.Jogador;

import java.math.BigDecimal;

public class JogadorDTO {

    private Long id;
    private String nickname;
    private String password;
    private BigDecimal saldo;

    public JogadorDTO(){}

    public JogadorDTO(Jogador jogador){
        this.id = jogador.getId();
        this.nickname = jogador.getNickname();
        this.password = jogador.getPassword();
        this.saldo = jogador.getSaldo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
