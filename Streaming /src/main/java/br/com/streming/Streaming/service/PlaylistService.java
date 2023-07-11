package br.com.streming.Streaming.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.streming.Streaming.domain.Playlist;
import br.com.streming.Streaming.domain.dados_playlists.DadosPlaylist;
import br.com.streming.Streaming.domain.dados_playlists.ImprimirPlaylist;

@Service
public interface PlaylistService {

    Playlist criarPlaylist(DadosPlaylist dados);

    List<ImprimirPlaylist> listar();

    Playlist buscarPorId(Long idPlaylist);

    void atualizarPlaylist(DadosPlaylist dados);

    void deletar(DadosPlaylist dados);

}
