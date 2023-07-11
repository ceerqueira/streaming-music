package br.com.streming.Streaming.domain.dados_playlists;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImprimirPlaylistMusic {
    private String usuario;
    private String nomedaPlaylist;
    private String descricao;
    private String titulo;
    private String artista;
    private String link;
    private Long idMusica;
    private Long idPlaylistMusic;
}
