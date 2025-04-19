package com.erick.salvamusica.repository;

import com.erick.salvamusica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
    List<Musica> findByNomeContainingIgnoreCase(String nome);

    Optional<Musica> findByNomeAndArtista(String title, String name);
}
