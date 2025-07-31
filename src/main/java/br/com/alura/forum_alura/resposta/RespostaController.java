package br.com.alura.forum_alura.resposta;


import jakarta.validation.Valid;
import br.com.alura.forum_alura.topico.Topico;
import org.springframework.http.ResponseEntity;
import br.com.alura.forum_alura.usuario.Usuario;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.alura.forum_alura.topico.TopicoRepositorio;
import br.com.alura.forum_alura.usuario.UsuarioRepositorio;
import br.com.alura.forum_alura.resposta.DTO.DadosResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import br.com.alura.forum_alura.resposta.DTO.DadosRespostaAtualizar;
import br.com.alura.forum_alura.resposta.DTO.DadosRespostaCadastrar;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

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
    public ResponseEntity novaResposta(@RequestBody @Valid DadosRespostaCadastrar dados, UriComponentsBuilder uriBuilder) {
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
            return ResponseEntity.badRequest().body("Não foi possivel responder.");
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarResposta(@PathVariable Long id, @RequestBody @Valid DadosRespostaAtualizar dados, @AuthenticationPrincipal Usuario usuario) {
        try {
            Optional<Resposta> respostaEncontrada = repositorio.encontrarRespostaIdEUsuario(id, usuario);

            if (!respostaEncontrada.isPresent()) {
                return ResponseEntity.badRequest().body("Resposta que deseja atualizar não foi encontrada.");
            }

            Resposta resposta = respostaEncontrada.get();
            resposta.setMessagem(dados.mensagem());

            repositorio.save(resposta);

            return ResponseEntity.ok().body(new DadosResposta(resposta));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel atualizar o tópico.");
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirResposta(@PathVariable Long id, @AuthenticationPrincipal Usuario usuario) {
        try {
            Optional<Resposta> respostaEncontrada = repositorio.encontrarRespostaIdEUsuario(id, usuario);

            if (!respostaEncontrada.isPresent()) {
                return ResponseEntity.badRequest().body("Resposta não encontrado.");
            }

            repositorio.deleteById(id);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi excluir o tópico.");
        }
    }
}
