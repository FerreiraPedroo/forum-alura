package br.com.alura.forum_alura.DTO;


import br.com.alura.forum_alura.model.Topico;


public record DadosTopico(
        Long id,
        String titulo,
        String mensagem,
        String dataCriacao,
        String status,
        DadosTopicoUsuario autor,
        DadosTopicoCurso curso
) {
    public DadosTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                new DadosTopicoUsuario(topico.getAutor()),
                new DadosTopicoCurso(topico.getCurso())
        );
    }
}
