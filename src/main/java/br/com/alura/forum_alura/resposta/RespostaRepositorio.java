package br.com.alura.forum_alura.resposta;

import java.util.List;
import java.util.Optional;
import br.com.alura.forum_alura.topico.Topico;
import br.com.alura.forum_alura.usuario.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepositorio extends JpaRepository<Resposta, Long> {

    @Query("SELECT r FROM Resposta r WHERE r.topico = :topico")
    List<Resposta> encontrarRespostPorTopicoId(Topico topico);

    @Query("SELECT r FROM Resposta r WHERE r.id = :id AND r.autor = :usuario")
    Optional<Resposta> encontrarRespostaIdEUsuario(Long id, Usuario usuario);
}
