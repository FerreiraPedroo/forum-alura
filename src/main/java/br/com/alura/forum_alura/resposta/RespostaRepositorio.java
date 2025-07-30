package br.com.alura.forum_alura.resposta;

import br.com.alura.forum_alura.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RespostaRepositorio extends JpaRepository<Resposta, Long> {

    @Query("SELECT m FROM Resposta m WHERE m.topico = :topico")
    List<Resposta> encontrarRespostPorTopicoId(Topico topico);
}
