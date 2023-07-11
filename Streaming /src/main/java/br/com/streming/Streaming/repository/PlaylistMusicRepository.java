package br.com.streming.Streaming.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.streming.Streaming.domain.PlaylistMusic;
@Repository
public interface PlaylistMusicRepository extends JpaRepository<PlaylistMusic,Long>{
    List<PlaylistMusic> findByPlaylistId(Long playlistId);
    
    @Query("SELECT pm.id FROM PlaylistMusic pm WHERE pm.playlist.id = :playlistId")
    List<Long> findIdsByPlaylistId(Long playlistId);

    
    
}
