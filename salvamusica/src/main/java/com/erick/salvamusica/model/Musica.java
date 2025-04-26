package com.erick.salvamusica.model;

import com.erick.salvamusica.dto.MusicaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String artista;
    private String genero;
    private int duracao;
    @ManyToMany(mappedBy = "favoritas")
    @JsonIgnore
    private List<Usuario> usuarios = new ArrayList<>();

    public Musica(){}

    public Musica(MusicaDTO musicaDTO) {
        this.nome = musicaDTO.title();
        this.artista = musicaDTO.artist().name();
        this.duracao = musicaDTO.duration();
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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String  artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
