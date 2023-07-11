package br.com.streming.Streaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.streming.Streaming.domain.PlaylistMusic;
import br.com.streming.Streaming.domain.dados_playlists.DadosPlaylistMusic;
import br.com.streming.Streaming.domain.dados_playlists.ImprimirPlaylistMusic;
import br.com.streming.Streaming.repository.MusicaRepotory;
import br.com.streming.Streaming.repository.PlaylistMusicRepository;
import br.com.streming.Streaming.repository.PlaylistRepository;
import br.com.streming.Streaming.service.PlaylistMusicService;

@Service
public class PlaylistMusicServiceImpl implements PlaylistMusicService {

    @Autowired
    private PlaylistMusicRepository repository;

    @Autowired
    private MusicaRepotory repositoryMusic;

    @Autowired
    private PlaylistRepository repositoryPlaylist;


    @Override
    public PlaylistMusic adicionarMusica(DadosPlaylistMusic dados) {
        var musica = repositoryMusic.getReferenceById(dados.idMusica());

        var playlist = repositoryPlaylist.getReferenceById(dados.idPlaylist());

        var adcionarMusica = new PlaylistMusic(musica, playlist);
        return repository.save(adcionarMusica);

    }

    @Override
    public List<PlaylistMusic> listar() {
        return repository.findAll();
    }

    @Override
    public List<ImprimirPlaylistMusic> findByPlaylistId(Long id) {

        List<PlaylistMusic> playlistMusics = repository.findByPlaylistId(id);
        List<ImprimirPlaylistMusic> imprimirPlaylistMusicList = new ArrayList<>();

        var playlist = repositoryPlaylist.getReferenceById(id);
        var usuario = playlist.getUsuario();
        var dados = new ImprimirPlaylistMusic();
        dados.setUsuario(usuario.getNome());
        dados.setNomedaPlaylist(playlist.getNome());
        dados.setDescricao(playlist.getDescricao());
        imprimirPlaylistMusicList.add(dados);

        for(PlaylistMusic playlistMusic : playlistMusics){
        ImprimirPlaylistMusic imprimir = new ImprimirPlaylistMusic();
        imprimir.setLink(playlistMusic.getMusica().getLink());
        imprimir.setArtista(playlistMusic.getMusica().getArtista());
        imprimir.setTitulo(playlistMusic.getMusica().getTitulo()); 
        imprimir.setIdMusica(playlistMusic.getMusica().getId());
        imprimir.setIdPlaylistMusic(playlistMusic.getId());
        imprimirPlaylistMusicList.add(imprimir);
    }

    return imprimirPlaylistMusicList;
    }

    @Override
    public PlaylistMusic buscarPorId(Long idPlaylistMusic) {
        return repository.getReferenceById(idPlaylistMusic);
    }

    @Override
    public void deletar(Long idPlaylistMusic) {
        repository.deleteById(idPlaylistMusic);
    }

}
