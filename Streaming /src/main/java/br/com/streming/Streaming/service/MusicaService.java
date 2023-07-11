package br.com.streming.Streaming.service;


import java.util.List;

import org.springframework.stereotype.Service;

import br.com.streming.Streaming.domain.Musica;


@Service
public interface MusicaService{
    Musica cadastra(Musica dados);
    List<Musica> listar();
    Musica buscarPorId(long id);
    void deletar(long id);
}
