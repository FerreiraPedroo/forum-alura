package br.com.alura.forum_alura.resposta;


import br.com.alura.forum_alura.resposta.DTO.DadosResposta;
import br.com.alura.forum_alura.resposta.DTO.DadosRespostaCadastrar;

import br.com.alura.forum_alura.topico.Topico;
import br.com.alura.forum_alura.topico.TopicoRepositorio;
import br.com.alura.forum_alura.usuario.Usuario;
import br.com.alura.forum_alura.usuario.UsuarioRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RespostaRepositorio repositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private TopicoRepositorio topicoRepositorio;

    @PostMapping
    @Transactional
    public ResponseEntity novoTopico(@RequestBody @Valid DadosRespostaCadastrar dados, UriComponentsBuilder uriBuilder) {

        try {
            Optional<Topico> topico = topicoRepositorio.findById(dados.topico());
            Optional<Usuario> autor = usuarioRepositorio.findById(dados.autor());

            if (!topico.isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Tópico não encontrado.");
            } else if (!autor.isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Usuario não encontrado para criar o tópico");
            }

            Resposta resposta = new Resposta(dados);
            resposta.setAutor(autor.get());
            resposta.setTopico(topico.get());

            repositorio.save(resposta);

            var uri = uriBuilder.path("/topico/{topicoId}").buildAndExpand(topico.get().getId()).toUri();

            return ResponseEntity.created(uri).body(new DadosResposta(resposta));

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body("Não foi possivel criar o tópico.");
        }
    }
    
}
