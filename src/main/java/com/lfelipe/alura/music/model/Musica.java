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
