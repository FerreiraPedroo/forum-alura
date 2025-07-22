package br.com.alura.forum_alura.repository;

import br.com.alura.forum_alura.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    @Query("SELECT u AS u FROM Usuario u WHERE UPPER(u.nome) = UPPER(:usuarioNome) ")
    public Optional<Usuario> procurarUsuarioPeloNome(String usuarioNome);


}
