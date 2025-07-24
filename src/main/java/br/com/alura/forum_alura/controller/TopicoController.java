package br.com.alura.forum_alura.controller;

import br.com.alura.forum_alura.DTO.*;
import br.com.alura.forum_alura.model.Curso;
import br.com.alura.forum_alura.model.Topico;
import br.com.alura.forum_alura.model.Usuario;
import br.com.alura.forum_alura.repository.CursoRepositorio;
import br.com.alura.forum_alura.repository.TopicoRepositorio;
import br.com.alura.forum_alura.repository.UsuarioRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepositorio repositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private CursoRepositorio cursoRepositorio;

    @PostMapping
    @Transactional
    public ResponseEntity novoTopico(@RequestBody @Valid DadosTopicoCadastrar dados) {

        try {
            Optional<Topico> topicoExistente = repositorio.procurarTopicoPeloTitulo(dados.titulo());
            Optional<Usuario> autor = usuarioRepositorio.findById(dados.autor());
            Optional<Curso> curso = cursoRepositorio.findById(dados.curso());

            if (topicoExistente.isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Existe um tópico com esse titulo");
            } else if (!autor.isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Usuario não encontrado para criar o topico");
            } else if (!curso.isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Curso não encontrado para criar o topico");
            }

            Topico topico = new Topico(dados);
            topico.setAutor(autor.get());
            topico.setCurso(curso.get());

            repositorio.save(topico);

            return ResponseEntity.ok("Topico criado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel criar o tpico.");
        }
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity atualizarTopicos(@PathVariable Long id, @RequestBody @Valid DadosTopicoAtualizar dados) {

        try {
            Optional<Topico> topicoEncontrado = repositorio.findById(id);

            if (!topicoEncontrado.isPresent()) {
                return ResponseEntity.badRequest().body("Topico que deseja atualizar não encontrado.");
            }
            Topico topico = topicoEncontrado.get();

            if (dados.curso() != null) {
                Optional<Curso> cursoEncontrado = cursoRepositorio.findById(dados.curso());
                if (!cursoEncontrado.isPresent()) {
                    return ResponseEntity.badRequest().body("Curso que deseja associar ao topico não encontrado");
                }
                Curso curso = cursoEncontrado.get();
                topico.setCurso(curso);
            }

            topico.atualizarInformacoes(dados);

            repositorio.save(topico);

            DadosTopicoAtualizado topicoAtualizado = new DadosTopicoAtualizado(topico);

            return ResponseEntity.ok(topicoAtualizado);


        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel atualizar o topico.");
        }
    }

    @GetMapping
    public ResponseEntity listarTopicos() {
        try {

            List<DadosTopico> listaTopicos = repositorio.findAll()
                    .stream()
                    .map(DadosTopico::new).toList();

            System.out.println(listaTopicos);

            return ResponseEntity.ok(listaTopicos);


        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi obter a lista de topicos.");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity detalhesDoTopico(@PathVariable Long id) {
        try {

            Optional<Topico> topicoEncontrado = repositorio.findById(id);

            if (!topicoEncontrado.isPresent()) {
                return ResponseEntity.badRequest().body("Topico não encontrado.");
            }

            Topico topico = topicoEncontrado.get();
            DadosTopico topicoDados = new DadosTopico(topico);

            return ResponseEntity.ok(topicoDados);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi obter o tópico.");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluirTopico(@PathVariable Long id) {
        try {

            Optional<Topico> topicoEncontrado = repositorio.findById(id);

            if (!topicoEncontrado.isPresent()) {
                return ResponseEntity.badRequest().body("Topico não encontrado.");
            }

            repositorio.deleteById(id);

            return ResponseEntity.ok("Topico exluido com sucesso.");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi excluir o tópico.");
        }
    }
}


