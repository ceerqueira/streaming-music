package br.com.streming.Streaming.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.streming.Streaming.domain.Musica;
import br.com.streming.Streaming.excepcion.MusicaAlreadyExistsException;
import br.com.streming.Streaming.repository.MusicaRepotory;
import br.com.streming.Streaming.service.MusicaService;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepotory repository;

    @Override
    public Musica cadastra(Musica dados) {
        if (!repository.existsByTitulo(dados.getTitulo())){
            throw new MusicaAlreadyExistsException("A música com nome " + dados.getTitulo() + " já existe");
        }
        return repository.save(dados);

    }

    @Override
    public List<Musica> listar() {
        return repository.findAll();
    }

    @Override
    public Musica buscarPorId(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void deletar(long id) {
        repository.deleteById(id);
    }
}
