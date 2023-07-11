package br.com.streming.Streaming.domain.dados_playlists;

public record DadosPlaylist(    
     String nome,
     String descricao,
     Long idUsuario,
     Long idPlaylist) {
    
}
