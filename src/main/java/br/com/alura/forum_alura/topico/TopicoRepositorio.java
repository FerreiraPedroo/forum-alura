package br.com.alura.forum_alura.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepositorio extends JpaRepository<Topico, Long> {
    @Query("SELECT t FROM Topico t WHERE UPPER(t.titulo) = UPPER(:titulo) OR UPPER(t.mensagem) = UPPER(:mensagem)")
    Optional<Topico> procurarTopicoPeloTituloOuMensagem(String titulo, String mensagem);

    @Query("SELECT t FROM Topico t WHERE UPPER(t.titulo) LIKE UPPER(CONCAT('%', :titulo, '%'))")
    Page<Topico> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);

}
