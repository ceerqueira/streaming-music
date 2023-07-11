package br.com.streming.Streaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.streming.Streaming.domain.PlaylistMusic;
import br.com.streming.Streaming.domain.dados_playlists.DadosPlaylistMusic;
import br.com.streming.Streaming.domain.dados_playlists.ImprimirPlaylistMusic;

@Service
public interface PlaylistMusicService {

    PlaylistMusic adicionarMusica( DadosPlaylistMusic musica);

    List<PlaylistMusic> listar();

    List<ImprimirPlaylistMusic> findByPlaylistId(Long id);

    PlaylistMusic buscarPorId(Long idPlaylistMusic);

    void deletar(Long idPlaylist);

}
