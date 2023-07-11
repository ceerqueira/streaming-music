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

import br.com.streming.Streaming.domain.Musica;
import br.com.streming.Streaming.service.MusicaService;



@RestController
@RequestMapping("musica") //Vai mapear essa URL para chamar esse controller
public class MusicaController {

    @Autowired
    private MusicaService service;


    @PostMapping
    @Transactional
    public ResponseEntity<Musica> cadastro(@RequestBody Musica dados){
        Musica musica = service.cadastra(dados);
        if(musica != null){
         return ResponseEntity.ok().body(musica);
        }
        return ResponseEntity.unprocessableEntity().build();

        //Aparecer a resposta do dados Refatorar o retorno 
    }

    @GetMapping
    public List<Musica> listar(){
        return service.listar();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualiza (@RequestBody Musica dados){
        var musica = service.buscarPorId(dados.getId());
        musica.atualizaDados(dados);
        return ResponseEntity.ok().body(musica);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deletar(@RequestBody Musica dados){
        service.deletar(dados.getId());
        return ResponseEntity.ok().body(null);
    }
}
