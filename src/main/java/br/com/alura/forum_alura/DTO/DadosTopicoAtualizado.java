package br.com.alura.forum_alura.DTO;

import br.com.alura.forum_alura.model.Topico;

public record DadosTopicoAtualizado(
        String titulo,
        String mensagem,
        String data_criacao,
        String status,
        DadosUsuario autor,
        DadosCurso curso
) {
    public DadosTopicoAtualizado(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getData_criacao(),
                topico.getStatus(),
                new DadosUsuario(topico.getAutor()),
                new DadosCurso(topico.getCurso())
        );
    }
}
