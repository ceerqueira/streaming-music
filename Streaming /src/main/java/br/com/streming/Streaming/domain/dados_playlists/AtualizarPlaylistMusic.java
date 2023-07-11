package br.com.streming.Streaming.domain.dados_playlists;

import jakarta.validation.constraints.NotBlank;

public record AtualizarPlaylistMusic(    
    @NotBlank
    Long idPlaylistMusic,
    @NotBlank
    Long idMusica,
    @NotBlank
    Long idPlaylist) {
    
}
