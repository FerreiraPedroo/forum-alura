package br.com.alura.forum_alura.controller;


import br.com.alura.forum_alura.DTO.DadosCurso;
import br.com.alura.forum_alura.DTO.DadosCursoCadastrar;
import br.com.alura.forum_alura.model.Curso;
import br.com.alura.forum_alura.repository.CursoRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoRepositorio repositorio;

    @PostMapping
    @Transactional
    public ResponseEntity novoCurso(@RequestBody @Valid DadosCursoCadastrar dados, UriComponentsBuilder uriBuilder) {
        try {
            Optional<Curso> cursoExistente = repositorio.procurarCursoPeloNome(dados.nome());

            if (cursoExistente.isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Existe um curso com esse nome.");
            }

            Curso curso = new Curso(dados);
            repositorio.save(curso);

            var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

            return ResponseEntity.created(uri).body(new DadosCurso(curso));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel criar o curso.");
        }
    }

    @GetMapping
    public ResponseEntity listarCursos() {
        try {
            List<DadosCurso> listaCursos = repositorio.findAll()
                    .stream()
                    .map(DadosCurso::new).toList();

            return ResponseEntity.ok(listaCursos);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi obter a lista de tópicos.");
        }
    }
}


