package com.lfelipe.alura.music.repository;

import com.lfelipe.alura.music.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
}
