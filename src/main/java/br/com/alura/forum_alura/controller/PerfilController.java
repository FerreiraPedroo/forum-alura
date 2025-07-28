package br.com.alura.forum_alura.controller;


import br.com.alura.forum_alura.DTO.DadosCurso;
import br.com.alura.forum_alura.DTO.DadosPerfilCadastrar;
import br.com.alura.forum_alura.DTO.DadosPerfil;
import br.com.alura.forum_alura.model.Curso;
import br.com.alura.forum_alura.model.Perfil;
import br.com.alura.forum_alura.repository.PerfilRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("perfil")
public class PerfilController {

    @Autowired
    private PerfilRepositorio repositorio;

    @PostMapping
    @Transactional
    public ResponseEntity novoPerfil(@RequestBody @Valid DadosPerfilCadastrar dados, UriComponentsBuilder uriBuilder) {

        try {
            Optional<Perfil> perfilExistente = repositorio.procurarPerfilPeloNome(dados.nome());

            if (perfilExistente.isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Existe um perfil com esse nome");
            }

            Perfil perfil = new Perfil(dados);
            repositorio.save(perfil);

            var uri = uriBuilder.path("/perfil/{id}").buildAndExpand(perfil.getId()).toUri();

            return ResponseEntity.created(uri).body(new DadosPerfil(perfil));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel criar o perfil.");
        }
    }

    @GetMapping
    public ResponseEntity listarPerfils() {
        try {
            List<DadosPerfil> listaPerfils = repositorio.findAll()
                    .stream()
                    .map(DadosPerfil::new).toList();

            return ResponseEntity.ok(listaPerfils);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi obter a lista de tópicos.");
        }
    }
}


