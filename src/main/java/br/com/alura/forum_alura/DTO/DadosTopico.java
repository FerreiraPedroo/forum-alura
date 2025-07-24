package br.com.alura.forum_alura.DTO;


import br.com.alura.forum_alura.model.Topico;


public record DadosTopico(
        String titulo,
        String mensagem,
        String data_criacao,
        String status,
        DadosTopicoUsuario autor,
        DadosTopicoCurso curso
) {
    public DadosTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getData_criacao(),
                topico.getStatus(),
                new DadosTopicoUsuario(topico.getAutor()),
                new DadosTopicoCurso(topico.getCurso())
        );
    }
}
