package br.com.streming.Streaming.domain.dados_playlists;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImprimirPlaylist {
    private String nome; 
    private String descricao;
    private String usuario;
    private String email;
    private Long idPlaylist;
    

    
    
}
