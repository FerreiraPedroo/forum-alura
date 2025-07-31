package br.com.alura.forum_alura.usuario;

import jakarta.validation.Valid;
import br.com.alura.forum_alura.perfil.Perfil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.alura.forum_alura.usuario.DTO.DadosUsuario;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.alura.forum_alura.usuario.DTO.DadosUsuarioAtualizar;
import br.com.alura.forum_alura.usuario.DTO.DadosUsuarioCadastrar;
import br.com.alura.forum_alura.perfil.PerfilRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
    public ResponseEntity usuarioRegistrar(@RequestBody @Valid DadosUsuarioCadastrar dados, UriComponentsBuilder uriBuilder) {
        try {
            Optional<Usuario> usuarioEncontrado = repositorio.procurarUsuarioPeloNomeOuEmail(dados.nome(), dados.email());
            Optional<Perfil> perfilEncontrado = perfilRepositorio.findById(dados.perfil());

            if (usuarioEncontrado.isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Nome ou email do usuário já cadastrado");
            } else if (!perfilEncontrado.isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Não existe o perfil para cadastro.");
            }

            Usuario usuario = new Usuario(dados);
            usuario.setPerfil(perfilEncontrado.get());

            repositorio.save(usuario);

            var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
            return ResponseEntity.created(uri).body(new DadosUsuario(usuario));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel efetuar o cadastro.");
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarUsuarios(@PathVariable Long id, @RequestBody @Valid DadosUsuarioAtualizar dados) {
        try {
            Optional<Usuario> usuarioEncontrado = repositorio.findByIdOrNome(id, dados.nome());

            if (!usuarioEncontrado.isPresent() || !id.equals(usuarioEncontrado.get().getId())) {
                return ResponseEntity.badRequest().body("Usuário que deseja atualizar não encontrado.");
            }

            if (dados.nome().equalsIgnoreCase(usuarioEncontrado.get().getNome())) {
                return ResponseEntity.badRequest().body("Existe um usuário com o mesmo nome.");
            }

            Usuario usuario = usuarioEncontrado.get();
            usuario.atualizarInformacoes(dados);

            repositorio.save(usuario);

            return ResponseEntity.ok().body(new DadosUsuario(usuario));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel atualizar o tópico.");
        }
    }

    @GetMapping
    public ResponseEntity usuarioLista() {
        try {
            List<DadosUsuario> listaUsuarios = repositorio.findAll()
                    .stream()
                    .map(DadosUsuario::new).toList();

            return ResponseEntity.ok(listaUsuarios);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi obter a lista de tópicos.");
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirUsuario(@PathVariable Long id) {
        try {
            Optional<Usuario> usuarioEncontrado = repositorio.findById(id);

            if (!usuarioEncontrado.isPresent()) {
                return ResponseEntity.badRequest().body("Usuario não encontrado.");
            }

            repositorio.deleteById(id);

            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi excluir o usuario.");
        }
    }

}
