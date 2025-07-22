package br.com.alura.forum_alura.repository;

import br.com.alura.forum_alura.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepositorio extends JpaRepository<Topico, Long> {
    @Query("SELECT t FROM Topico t WHERE UPPER(t.titulo) = UPPER(:titulo)")
    Optional<Topico> procurarTopicoPeloTitulo(String titulo);

}
