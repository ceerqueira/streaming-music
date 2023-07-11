package br.com.streming.Streaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.streming.Streaming.domain.Playlist;
import br.com.streming.Streaming.domain.dados_playlists.DadosPlaylist;
import br.com.streming.Streaming.domain.dados_playlists.ImprimirPlaylist;
import br.com.streming.Streaming.service.PlaylistService;

@RestController
@RequestMapping("playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService service;

    // criar playlista
    @PostMapping
    @Transactional
    public ResponseEntity criarPlaylist(@RequestBody DadosPlaylist dados) {
        Playlist playlist = service.criarPlaylist(dados);
        if(playlist == null){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<ImprimirPlaylist> listar() {
        return service.listar();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualiza(@RequestBody DadosPlaylist dados) {
        service.atualizarPlaylist(dados);
        var playlist = service.buscarPorId(dados.idPlaylist());
        return ResponseEntity.ok().body(playlist);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deletar(@RequestBody DadosPlaylist dados) {
        service.deletar(dados);
        
        return ResponseEntity.ok().body(null);
    }

}
