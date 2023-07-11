package br.com.streming.Streaming.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.streming.Streaming.domain.Usuario;

@Service
public interface UsuarioService {
    
    Usuario cadastro(Usuario dados);

    void deletar(long id);

    List<Usuario> listar();

    Usuario atualiza(long id);

    
    UserDetails encontrarPorEmail(String email);



}
