package br.com.alura.forum_alura.DTO;

import br.com.alura.forum_alura.model.Curso;
import br.com.alura.forum_alura.model.Topico;
import br.com.alura.forum_alura.model.Usuario;

public record DadosTopicoLista(
        String titulo,
        String mensagem,
        String data_criacao,
        String status,
        DadosUsuarioLista autor,
        DadosCurso curso
) {
    public DadosTopicoLista(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getData_criacao(),
                topico.getStatus(),
                new DadosUsuarioLista(topico.getAutor()),
                new DadosCurso(topico.getCurso())
        );
    }
}
