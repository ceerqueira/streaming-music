package br.com.streming.Streaming.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "musicas")
@Entity(name = "Musica")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties
@EqualsAndHashCode(of = "id")
public class Musica {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String artista;
    private String album;
    private String duracao;
    private String link;


    public void atualizaDados(Musica dados) {

        if (dados.getAlbum() != null) {
            this.album = dados.getAlbum();
        }
        if (dados.getArtista() != null) {
            this.artista = dados.getArtista();
        }
        if (dados.getDuracao() != null) {
            this.duracao = dados.getDuracao();
        }
        if (dados.getTitulo() != null) {
            this.titulo = dados.getTitulo();
        }
        if (dados.getLink() != null) {
            this.link = dados.getLink();
        }
    }

}
