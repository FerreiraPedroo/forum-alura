package br.com.alura.forum_alura.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE UPPER(u.nome) = UPPER(:nome) OR UPPER(u.email) = UPPER(:email) ")
    public Optional<Usuario> procurarUsuarioPeloNomeOuEmail(String nome, String email );

    UserDetails findByEmail(String email);

    Optional<Usuario> findByNome(String nome);

    Optional<Usuario> findByIdOrNome(Long id, String nome);
}
