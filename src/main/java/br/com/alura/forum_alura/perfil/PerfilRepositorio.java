package br.com.alura.forum_alura.perfil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PerfilRepositorio extends JpaRepository<Perfil, Long> {
    @Query("SELECT p FROM Perfil p WHERE UPPER(p.nome) = UPPER(:nome)")
    Optional<Perfil> procurarPerfilPeloNome(String nome);

}
