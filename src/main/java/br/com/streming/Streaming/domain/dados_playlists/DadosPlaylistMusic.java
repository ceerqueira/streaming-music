package br.com.streming.Streaming.domain.dados_playlists;

import jakarta.validation.constraints.NotBlank;

public record DadosPlaylistMusic (
    @NotBlank
    Long idMusica,
    @NotBlank
    Long idPlaylist
){


    
}
