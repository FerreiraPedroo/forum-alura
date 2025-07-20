package br.com.alura.forum_alura.repository;

import br.com.alura.forum_alura.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Topico findByTitulo(String titulo);
}
