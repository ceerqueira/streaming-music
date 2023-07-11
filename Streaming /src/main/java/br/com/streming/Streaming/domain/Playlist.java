package br.com.streming.Streaming.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.streming.Streaming.domain.dados_playlists.DadosPlaylist;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "playlists")
@Entity(name = "Playlist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties
public class Playlist {

    public Playlist(Usuario usuario2, DadosPlaylist dados) {
        this.usuario = usuario2;
        this.nome = dados.nome();
        this.descricao= dados.descricao();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;
    private String nome;
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public void atualiza(DadosPlaylist dados,Usuario usuario2) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (usuario2 != null){
            this.usuario = usuario2;
        }
    }

}
