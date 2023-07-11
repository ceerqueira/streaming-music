package br.com.streming.Streaming.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.streming.Streaming.domain.Usuario;
import br.com.streming.Streaming.excepcion.PlaylistAlreadyExistsException;
import br.com.streming.Streaming.repository.UsuarioRepository;
import br.com.streming.Streaming.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario cadastro(Usuario dados) {
        if(repository.existsByEmail(dados.getEmail())){
             throw new PlaylistAlreadyExistsException("O Usuario com o email " + dados.getEmail() + " já existe");
        }
        return repository.save(dados);
    }

    @Override
    public void deletar(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @Override
    public Usuario atualiza(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public UserDetails encontrarPorEmail(String email) {

        
        return repository.encontrarPorEmail(email);
    }


    
}
