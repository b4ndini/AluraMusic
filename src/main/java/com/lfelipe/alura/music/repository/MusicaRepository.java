package com.lfelipe.alura.music.repository;

import com.lfelipe.alura.music.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {

    //com derived queries
    List<Musica> getMusicaByArtistaNomeContainingIgnoreCase(String artista);

    //com jpql
    @Query("select m from Musica m where m.artista.nome ILIKE %:artista%")
    List<Musica> getMusicasPorArtistaComJPQL(String artista);
}
