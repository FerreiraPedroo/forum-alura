package br.com.alura.forum_alura.controller;


import br.com.alura.forum_alura.DTO.DadosNovoTopico;
import br.com.alura.forum_alura.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topico")
public class TopicoController {

    @Autowired
    private TopicoRepository repositorio;

    @PostMapping
    public ResponseEntity novoTopico(@RequestBody @Valid DadosNovoTopico dados){
            var topicoExistente = repositorio.findByTitulo(dados.titulo());
        System.out.println(topicoExistente);
        try{

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
return ResponseEntity.ok("topicoExistente");
    }
}
