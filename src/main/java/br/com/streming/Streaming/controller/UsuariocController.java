package br.com.streming.Streaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.streming.Streaming.domain.Usuario;
import br.com.streming.Streaming.service.UsuarioService;

@RestController
@RequestMapping("cadastro")
public class UsuariocController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody Usuario dados) {
        var usuario = service.cadastro(dados);
        if ( usuario == null){
        return ResponseEntity.unprocessableEntity().build();
       }
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Usuario dados) {

        var usuario = service.atualiza(dados.getId());
        usuario.atualizarDados(dados);
        return ResponseEntity.ok().body(usuario);

    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deletar(@RequestBody Usuario dados) {
        service.deletar(dados.getId());
        return ResponseEntity.ok().body(null);
    }
}
