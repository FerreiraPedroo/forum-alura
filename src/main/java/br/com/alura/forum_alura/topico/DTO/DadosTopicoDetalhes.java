package br.com.alura.forum_alura.topico.DTO;


import br.com.alura.forum_alura.topico.Topico;

import java.util.List;


public record DadosTopicoDetalhes(
        Long id,
        String titulo,
        String mensagem,
        String dataCriacao,
        String status,
        DadosTopicoUsuario autor,
        DadosTopicoCurso curso,
        List<DadosTopicoRespostas> respostas
) {
    public DadosTopicoDetalhes(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                new DadosTopicoUsuario(topico.getAutor()),
                new DadosTopicoCurso(topico.getCurso()),
                topico.getRespostas().stream().map(resposta ->
                        new DadosTopicoRespostas(
                                resposta.getId(),
                                resposta.getMensagem(),
                                resposta.getDataCriacao(),
                                new DadosTopicoUsuario(resposta.getAutor()),
                                resposta.getSolucao()
                        )
                ).toList()
        );
    }
}
