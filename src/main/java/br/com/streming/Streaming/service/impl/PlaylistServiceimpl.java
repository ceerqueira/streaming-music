package br.com.streming.Streaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.streming.Streaming.domain.Playlist;
import br.com.streming.Streaming.domain.dados_playlists.DadosPlaylist;
import br.com.streming.Streaming.domain.dados_playlists.ImprimirPlaylist;
import br.com.streming.Streaming.excepcion.PlaylistAlreadyExistsException;
import br.com.streming.Streaming.repository.PlaylistMusicRepository;
import br.com.streming.Streaming.repository.PlaylistRepository;
import br.com.streming.Streaming.repository.UsuarioRepository;
import br.com.streming.Streaming.service.PlaylistService;

@Service
public class PlaylistServiceimpl implements PlaylistService {

    @Autowired
    private PlaylistRepository repository;

    @Autowired
    private UsuarioRepository usuarioReposisRepository;

    @Autowired
    private PlaylistMusicRepository playlistMusicRepository;

    @Override
    public Playlist criarPlaylist(DadosPlaylist dados) {
        if(repository.existsByNome(dados.nome())){
            throw new PlaylistAlreadyExistsException("A Playlist com nome " + dados.nome() + " já existe");
        }
        var usuario = usuarioReposisRepository.getReferenceById(dados.idUsuario());
        var playlist = new Playlist(usuario, dados);
        return repository.save(playlist);
    }

    @Override
    public List<ImprimirPlaylist> listar() {
        List<Playlist> playlistMusic = repository.findAll();
        List<ImprimirPlaylist> imprimirPlaylistMusicList = new ArrayList<>();
        for (Playlist teste : playlistMusic) {
            ImprimirPlaylist imprimir = new ImprimirPlaylist();
            imprimir.setNome(teste.getNome());
            imprimir.setDescricao(teste.getDescricao());
            imprimir.setUsuario(teste.getUsuario().getNome());
            imprimir.setEmail(teste.getUsuario().getEmail());
            imprimir.setIdPlaylist(teste.getId());
            imprimirPlaylistMusicList.add(imprimir);
        }
        return imprimirPlaylistMusicList;
    }

    @Override
    public Playlist buscarPorId(Long idPlaylist) {
        return repository.getReferenceById(idPlaylist);
    }

    @Override
    public void atualizarPlaylist(DadosPlaylist dados) {
        var playlist = repository.getReferenceById(dados.idPlaylist());
        var usuario = usuarioReposisRepository.getReferenceById(dados.idUsuario());
        playlist.atualiza(dados,usuario);
        
    }

    @Override
    public void deletar(DadosPlaylist dados) {
        List<Long> ids = playlistMusicRepository.findIdsByPlaylistId(dados.idPlaylist());
        playlistMusicRepository.deleteAllById(ids);
        repository.deleteById(dados.idPlaylist());
        
    }

}
