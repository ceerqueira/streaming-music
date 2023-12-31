package br.com.streming.Streaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.streming.Streaming.domain.Autenticacao;
import br.com.streming.Streaming.domain.Usuario;
import br.com.streming.Streaming.infra.segurity.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid Autenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.getEmail(), dados.getSenha());
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok(tokenService.gerarToken((Usuario) authentication.getPrincipal()));

    }

}
