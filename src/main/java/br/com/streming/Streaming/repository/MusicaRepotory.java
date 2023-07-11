package br.com.streming.Streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.streming.Streaming.domain.Musica;
@Repository
public interface MusicaRepotory extends JpaRepository<Musica,Long> {
     boolean existsByTitulo(String titulo);
}
