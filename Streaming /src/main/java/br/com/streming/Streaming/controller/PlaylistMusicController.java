package br.com.streming.Streaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.streming.Streaming.domain.dados_playlists.AtualizarPlaylistMusic;
import br.com.streming.Streaming.domain.dados_playlists.DadosPlaylistMusic;
import br.com.streming.Streaming.domain.dados_playlists.ImprimirPlaylistMusic;
import br.com.streming.Streaming.service.MusicaService;
import br.com.streming.Streaming.service.PlaylistMusicService;
import br.com.streming.Streaming.service.PlaylistService;

@RestController
@RequestMapping("playlistmusic")
public class PlaylistMusicController {

    @Autowired
    private PlaylistMusicService service;

    @Autowired
    private MusicaService serviceMusica;

    @Autowired
    private PlaylistService servicePlaylist;

    @PostMapping
    @Transactional
    public ResponseEntity adicionarMusicPlaylist(@RequestBody DadosPlaylistMusic dados) {
       var playlistmusic = service.adicionarMusica(dados);
       if ( playlistmusic == null){
        return ResponseEntity.unprocessableEntity().build();
       }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public List<ImprimirPlaylistMusic> getPlaylistById(@PathVariable Long id) {
        return service.findByPlaylistId(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualiza(@RequestBody AtualizarPlaylistMusic dados) {
        var playlistMusic = service.buscarPorId(dados.idPlaylistMusic());
        var musica = serviceMusica.buscarPorId(dados.idMusica());
        var playlist = servicePlaylist.buscarPorId(dados.idPlaylist());
        playlistMusic.atualizaDados(musica, playlist);
        return ResponseEntity.ok().body(playlistMusic);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deletar(@RequestBody AtualizarPlaylistMusic dados) {
        service.deletar(dados.idPlaylistMusic());
        return ResponseEntity.ok().body(null);
    }

}
