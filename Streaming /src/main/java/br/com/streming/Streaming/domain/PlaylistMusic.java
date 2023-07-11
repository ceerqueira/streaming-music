package br.com.streming.Streaming.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.streming.Streaming.domain.dados_playlists.AtualizarPlaylistMusic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "musicas_playlist")
@Entity(name = "PlaylistMusic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties
public class PlaylistMusic {



    public PlaylistMusic(Musica musicaDados, Playlist playlistDados) {
        this.musica = musicaDados;
        this.playlist = playlistDados;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "musica_id")
    private Musica musica;

    @OneToOne(fetch = FetchType .LAZY)
    @JoinColumn(name = "playlist_id") 
    private Playlist playlist;

    public void atualizaDados(Musica musicas, Playlist playlists) {
        if (musica != null){
            this.musica = musicas;
        }
        if(playlist != null){
            this.playlist = playlists;
        }

    }

    


}
