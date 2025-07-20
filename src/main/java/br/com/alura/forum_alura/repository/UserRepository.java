package br.com.alura.forum_alura.repository;

import br.com.alura.forum_alura.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {
}
