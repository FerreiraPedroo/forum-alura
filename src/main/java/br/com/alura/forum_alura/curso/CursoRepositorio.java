package br.com.alura.forum_alura.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CursoRepositorio extends JpaRepository<Curso, Long> {
    @Query("SELECT c FROM Curso c WHERE UPPER(c.nome) = UPPER(:nome)")
    Optional<Curso> procurarCursoPeloNome(String nome);
}
