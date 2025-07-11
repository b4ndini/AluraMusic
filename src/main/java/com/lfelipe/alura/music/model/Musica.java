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

    @Override
    public String toString() {
        return
                "duração = '" + duracao + '\'' +
                ", nome = '" + nome + '\'' +
                ", gênero = " + genero.toString() +
                ", Artista/Banda = " + getArtista().getNome();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String duracao;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @ManyToOne(fetch = FetchType.EAGER)
    private Artista artista;
}
