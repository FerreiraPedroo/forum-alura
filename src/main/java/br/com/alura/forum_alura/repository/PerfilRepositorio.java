package br.com.alura.forum_alura.repository;

import br.com.alura.forum_alura.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PerfilRepositorio extends JpaRepository<Perfil, Long> {
    @Query("SELECT p FROM Perfil p WHERE UPPER(p.nome) = UPPER(:nome)")
    Optional<Perfil> procurarPerfilPeloNome(String nome);

}
