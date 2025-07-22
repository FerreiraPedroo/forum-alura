package br.com.alura.forum_alura.controller;

import br.com.alura.forum_alura.DTO.DadosUsuarioCadastrar;
import br.com.alura.forum_alura.DTO.DadosUsuarioLista;
import br.com.alura.forum_alura.model.Perfil;
import br.com.alura.forum_alura.model.Usuario;
import br.com.alura.forum_alura.repository.PerfilRepositorio;
import br.com.alura.forum_alura.repository.UsuarioRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio repositorio;
    @Autowired
    private PerfilRepositorio perfilRepositorio;


    @PostMapping
    @Transactional
    public ResponseEntity usuarioRegistrar(@RequestBody @Valid DadosUsuarioCadastrar dados) {
        try {
            Optional<Usuario> usuarioEncontrado = repositorio.procurarUsuarioPeloNome(dados.nome());
            Optional<Perfil> perfilEncontrado = perfilRepositorio.findById(dados.perfil());

            if (usuarioEncontrado.isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Nome ou email do usuário já cadastrado");
            } else if (!perfilEncontrado.isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Não existe o perfil para cadastro.");
            }
            Usuario usuario = new Usuario(dados);

            usuario.setPerfil(perfilEncontrado.get());

            repositorio.save(usuario);

            return ResponseEntity.ok("Usuário registrado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel efetuar o cadastro.");
        }
    }

    @GetMapping
    public ResponseEntity usuarioLista() {
        try {

            List<DadosUsuarioLista> listaUsuarios = repositorio.findAll()
                    .stream()
                    .map(DadosUsuarioLista::new).toList();

            return ResponseEntity.ok(listaUsuarios);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi obter a lista de tópicos.");
        }
    }

}
