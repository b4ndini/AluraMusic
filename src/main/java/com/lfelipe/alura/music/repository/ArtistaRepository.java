package com.lfelipe.alura.music.repository;

import com.lfelipe.alura.music.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Integer> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nomeArtista);
}
