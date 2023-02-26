package com.stefanini.entity;

import com.stefanini.dto.StefamonDTO;

import javax.persistence.*;

@Entity
@Table(name = "tb_stefamon")
public class Stefamon {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer vida;
    @Column(nullable = false)
    private Integer ataque;
    @Column(nullable = false)
    private Integer defesa;
    @Column(nullable = false)
    private Integer inteligencia;

    @Column(nullable = false)
    private Integer poder;
    @Column(nullable = false)
    private Integer velocidade;
    @Column(nullable = false)
    private String urlFoto;


    public Stefamon() {
    }

    public Stefamon(StefamonDTO stefamonDTO) {
        this.id = stefamonDTO.getId();
        this.nome = stefamonDTO.getNome();
        this.vida = stefamonDTO.getVida();
        this.ataque = stefamonDTO.getAtaque();
        this.defesa = stefamonDTO.getDefesa();
        this.inteligencia = stefamonDTO.getInteligencia();
        this.poder = stefamonDTO.getPoder();
        this.velocidade = stefamonDTO.getVelocidade();
        this.urlFoto = stefamonDTO.getUrlFoto();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }


}
