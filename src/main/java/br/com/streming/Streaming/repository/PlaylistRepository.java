package br.com.streming.Streaming.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.streming.Streaming.domain.Playlist;
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>{
    boolean existsByNome(String Nome);
}
