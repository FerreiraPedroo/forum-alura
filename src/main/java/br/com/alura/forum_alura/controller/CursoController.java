package br.com.alura.forum_alura.controller;


import br.com.alura.forum_alura.DTO.DadosCurso;
import br.com.alura.forum_alura.DTO.DadosCursoCadastrar;
import br.com.alura.forum_alura.model.Curso;
import br.com.alura.forum_alura.repository.CursoRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoRepositorio repositorio;

    @PostMapping
    public ResponseEntity novoCurso(@RequestBody @Valid DadosCursoCadastrar dados) {

        try {
            Optional<Curso> cursoExistente = repositorio.procurarCursoPeloNome(dados.nome());

            if (cursoExistente.isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Existe um curso com esse nome.");
            }

            repositorio.save(new Curso(dados));

            return ResponseEntity.ok("Curso criado com sucesso.");

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


