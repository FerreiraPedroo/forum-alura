package br.com.alura.forum_alura.repository;

import br.com.alura.forum_alura.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepositorio extends JpaRepository<Curso, Long> {

}
