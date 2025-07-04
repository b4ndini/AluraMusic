package com.lfelipe.alura.music.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Musica {

    public Musica(String nome, String duracao, Genero genero, Artista artista){
        this.nome = nome;
        this.duracao = duracao;
        this.genero = genero;
        this.artista = artista;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String duracao;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @ManyToOne(fetch = FetchType.LAZY)
    private Artista artista;
}
