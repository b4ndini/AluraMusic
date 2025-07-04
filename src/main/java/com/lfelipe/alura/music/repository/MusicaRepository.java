package com.lfelipe.alura.music.repository;

import com.lfelipe.alura.music.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {
}
